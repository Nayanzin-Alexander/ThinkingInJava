package chapter7innerclasses;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 28.06.17.
 */
public class Parcel1 {
    class Contents{
        private int i = 1;
        public int value(){
            return i;
        }
    }

    class Destination{
        private String whereTo;
        public Destination(String whereTo){
            this.whereTo = whereTo;
        }
        public String readLabel(){
            return whereTo;
        }
    }

    public void ship(String dest){
        Contents contents = new Contents();
        Destination destination = new Destination(dest);
        print("Contents valued " + contents.value() + " delivered to "
                + destination.readLabel());
    }

    public static void main(String... args){
        Parcel1 parcel1 = new Parcel1();
        parcel1.ship("Singapore");



    }
}
