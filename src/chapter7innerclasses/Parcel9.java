package chapter7innerclasses;

/**
 * Created by nayanzin on 29.06.17.
 */
public class Parcel9 {
    public Destination destination(String dest) {
        return new Destination() {
            private String label = dest;
            public String readLabel() { return label; }
        };
    }
    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
    }
}
