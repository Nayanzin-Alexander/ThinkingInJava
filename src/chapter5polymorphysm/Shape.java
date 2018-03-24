package chapter5polymorphysm;

import static myutil.Printer.*;
/**
 * Created by nayanzin on 27.06.17.
 */
public class Shape {
    public Shape(){
        draw();
    }
    int field = 10;
    public int getField(){  return field;           }
    public void draw()  {   print("Shape.draw();"); };
    public void move()  {   print("Shape.move();"); };
    public void erase() {   print("Shape.erase;");  };
}
