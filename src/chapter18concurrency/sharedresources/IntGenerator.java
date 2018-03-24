package chapter18concurrency.sharedresources;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 01.09.17.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();

    // Allow this to be canceled:
    public void cancel() {
        canceled = true;
    }
    public boolean isCanceled() {
        return canceled;
    }
}
