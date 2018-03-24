package chapter4reusingobjects;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 26.06.17.
 */

class Plate{
    Plate(int i) {
        print("Plate constuctor");
    }
}

class DinnerPlate extends Plate{
    DinnerPlate(int i){
        super(i);
        print("DinnerPlate constuctor");
    }
}

class Utensil{
    Utensil(int i){
        print("Utensil constuctor");
    }
}

class Spoon extends Utensil{
    Spoon(int i){
        super(i);
        print("Spoon constructor");
    }
}

class Fork extends Utensil{
    Fork(int i){
        super(i);
        print("Fork constructor");
    }
}

class Knife extends Utensil{
    Knife(int i){
        super(i);
        print("Knife constructor");
    }
}

class Custom{
    Custom(int i){
        print("Custom constructor");
    }
}

public class InheritanceAndComposition extends Custom{
    private Spoon sp;
    private Fork frk;
    private Knife kn;
    private DinnerPlate pl;

    public InheritanceAndComposition(int i){
        super(i+1);
        sp = new Spoon(i+2);
        frk = new Fork(i+3);
        kn = new Knife(i+4);
        pl = new DinnerPlate(i + 5);
        print("InheritanceAndComposition constructor");
    }

    public static void main(String... args){
        InheritanceAndComposition ic = new InheritanceAndComposition(9);
    }
} /* Output:
Custom constructor
Utensil constructor
Spoon constructor
Utensil constructor
Fork constructor
Utensil constructor
Knife constructor
Plate constructor
DinnerPlate constructor
PlaceSetting constructor
*/
