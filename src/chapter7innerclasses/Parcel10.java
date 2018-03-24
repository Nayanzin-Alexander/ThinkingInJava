package chapter7innerclasses;

/**
 * Created by nayanzin on 29.06.17.
 */
public class Parcel10 {
    int i = 100;
    String dest;
    float price;

    public Parcel10(String dest, float price){
        this.dest = dest;
        this.price = price;
    }

    public Destination getDestination(String dest, float price){
        int methodScopeVar = 10;
        return new Destination(){
            private String label = dest;
            int cost;
            {
                cost = Math.round(price);
                if(cost > i)
                    System.out.println("Over budget!");
                Parcel10.this.dest = "";
                Parcel10.this.price = 55F;
                i = 33;

                //Can't do this. Why?
                //dest = "";
                //price = 55F;
                //Answer: Var is accessed within inner class must be final
            }
            public String readLabel(){
                return label;
            }
        };
    }

    public static void main(String... args){
        Parcel10 p10 = new Parcel10("Tanzania", 101.55F);
        Destination dest = p10.getDestination("Tanzania", 101.55F);
    }
}
