package chapter15io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 07.08.17.
 */
public class LockingMappedFile {
    static final int LENGTH = 0x8FFFFFF; //128 mb
    static FileChannel fc;

    private static class LockAndModify extends Thread {
        private ByteBuffer buff;
        private int start, end;

        LockAndModify(ByteBuffer mbb, int start, int end) {
            this.start = start;
            this.end = end;
            mbb.limit(end);
            mbb.position(start);
            buff = mbb.slice();
            start();
        }

        public void run() {
            FileLock fl;
            // check if it locked and whait until unlocked
            boolean isLocked = true;
            while (isLocked) {
                try {
                    fl = fc.tryLock(start, end, false);
                    print(String.format("Locked: %d to %d", start, end));
                    // Perform modification:
                    while (buff.position() < buff.limit() - 1)
                        buff.put((byte) (buff.get() + 1));

                    fl.release();
                    print(String.format("Released: %d to %d", start, end));
                    isLocked = false;
                } catch (OverlappingFileLockException ofle) {
                    // do nothing try again
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String... args) throws Exception {
        fc = new RandomAccessFile("test.data", "rw").getChannel();
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for(int i =0; i < LENGTH; i++) {
            out.put( (byte) 'x');
        }

        new LockAndModify(out, 0, 0 + LENGTH/3);
        new LockAndModify(out, 0, 0 + LENGTH/3);
        new LockAndModify(out, LENGTH/2, LENGTH/2 + LENGTH/4);
    }
}
