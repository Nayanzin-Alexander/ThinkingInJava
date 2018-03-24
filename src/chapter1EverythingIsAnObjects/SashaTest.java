package chapter1EverythingIsAnObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nayanzin on 07.08.17.
 */
abstract class  Figure {
    abstract double coutSquare();
}

class Cirkle extends Figure {
    double radius = 1;
    @Override
    double coutSquare() {
        System.out.println("Cirkle square");
        return Math.PI * Math.pow(radius, 2);
    }
}

class Square extends Figure {
    float a, b;
    @Override
    double coutSquare() {
        System.out.println("Square square");
        return a * b;
    }
}

class Triangle extends Figure{
    float height, width;
    @Override
    double coutSquare() {
        System.out.println("Triangle square");
        return (height * width) / 2;
    }
}

public class SashaTest {



    public static void main(String... args) {

        List<Figure> figures = new ArrayList<>();

        Cirkle obj1 = new Cirkle();
        obj1.radius = 10;
        figures.add(obj1);

        Cirkle obj2 = new Cirkle();
        obj2.radius = 5;
        figures.add(obj2);

        Square obj3 = new Square();
        obj3.a = 1;
        obj3.b = 5;
        figures.add(obj3);

        Triangle obj4 = new Triangle();
        obj4.width = 5;
        obj4.height = 3;
        figures.add(obj4);

        double commonSquare = 0;

        for(int i = 0; i<figures.size(); i++){
            commonSquare += figures.get(i).coutSquare();
        }

        System.out.println("Common square = " + commonSquare);

    }
}
