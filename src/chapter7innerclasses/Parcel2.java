package chapter7innerclasses;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 28.06.17.
 */
public class Parcel2 {
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

    public Destination to(String dest){
        return new Destination(dest);
    }

    public Contents getContents(){
        return new Contents();
    }

    public void ship(String dest){
        Destination destination = to(dest);
        Contents contents = getContents();

        print("Contents valued " + contents.value() + " delivered to "
                + destination.readLabel());
    }

    public static void main(String... args){
        Parcel2 parcel2 = new Parcel2();
        parcel2.ship("Tanzania");

        Parcel2.Contents c = parcel2.getContents();
    }
}
