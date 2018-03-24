package chapter7innerclasses;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 29.06.17.
 */
public class TestParcel4 {
    public static void main(String... args){
        Parcel4 p4 = new Parcel4();
        Contents c = p4.getContents(); // Upcasting occurs here
        Destination d = p4.getDestination("Tasmania"); // Upcasting occurs here
    }
}
