package chapter7innerclasses;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 29.06.17.
 */

interface Contents{
    int value();
}

interface Destination{
    String readLabel();
}

public class Parcel4 {

    private class ParcelContents implements Contents{
        int i = 10;
        @Override
        public int value(){
            return i;
        }
    }

    protected class PacelDestination implements Destination{
        private String label;
        PacelDestination(String label){
            this.label = label;
        }
        @Override
        public String readLabel(){
            return label;
        }
    }

    public Contents getContents(){
        return new ParcelContents();
    }

    public PacelDestination getDestination(String destination){
        return new PacelDestination(destination);
    }
}
