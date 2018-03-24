package chapter5polymorphysm;

import static myutil.Printer.*;
import java.util.*;

/**
 * Created by nayanzin on 27.06.17.
 */

class Triangle extends Shape{
    int field = 100;
    @Override
    public int getField(){  return field;               }
    @Override
    public void draw()  {   print("Triangle.draw();"); };
    @Override
    public void erase() {   print("Triangle.erase;");  };
}

class Square extends Shape{
    int field = 100;
    @Override
    public int getField(){  return field;               }
    @Override
    public void draw()  {   print("Square.draw();"); };
    @Override
    public void erase() {   print("Square.erase;");  };
}

class Circle extends Shape{
    int field = 100;
    @Override
    public int getField(){  return field;               }
    @Override
    public void draw()  {   print("Circle.draw();"); };
    @Override
    public void erase() {   print("Circle.erase;");  };
}

class Ellipse extends Circle{
    int field = 100;
    @Override
    public int getField(){  return field;               }
    @Override
    public void draw()  {   print("Ellipse.draw();"); };
    @Override
    public void erase() {   print("Ellipse.erase;");  };
    public void roll()  {   print("Ellipse.roll;");  };
}

public class Figures {
    static Random rand = new Random(47);
    static Shape doShape(){
        switch(rand.nextInt(5)){
            default:
            case 1: return new Triangle();
            case 2: return new Square();
            case 3: return new Circle();
            case 4: return new Ellipse();
        }
    }

    public static void main(String... args){
        Shape[] shapes = new Shape[15];
        for(int i=0; i< shapes.length; i++) {
            shapes[i] = doShape();
            //print(shapes[i].field);
            //print(shapes[i].getField());
            shapes[i].draw();
            shapes[i].move();
            shapes[i].erase();
            try{
                ( (Ellipse) shapes[i]).roll();
            }catch(ClassCastException e){
                //do nothing for now
            }
        }
        Triangle tirangle = new Triangle();
        print(tirangle.field);
        print(tirangle.getField());
    }
}
