package chapter5polymorphysm;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 27.06.17.
 */
enum Note{
    MIDDLE_C, C_SHARP, B_FLAT;
}

class Instrument{
    public void play(Note n){
        print("Instrument.play(" + n + ")");
    }
}

class Wind extends Instrument{
    @Override
    public void play(Note n){
        print("Wind.play(" + n + ")");
    }
}

class Stringed extends Instrument{
    @Override
    public void play(Note n){
        print("Stringed.play(" + n + ")");
    }
}

class Brass extends Instrument{
    @Override
    public void play(Note n){
        print("Brass.play(" + n + ")");
    }
}

public class Music {
    public static void tune(Instrument i, Note n){
        i.play(n);
    }

    public static void main(String[] args){
        Music.tune(new Wind(), Note.C_SHARP);
        Music.tune(new Stringed(), Note.MIDDLE_C);
        Music.tune(new Brass(), Note.B_FLAT);
    }
}
