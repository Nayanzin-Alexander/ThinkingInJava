package chapter15io.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 08.08.17.
 */
abstract class Shape implements Serializable {
    public static final int RED = 1, BLUE = 2, GREEN = 3;
    private int xPos, yPos, dimension;
    private static Random rand = new Random(47);
    private static int counter = 0;
    public abstract void setColor(int newColor);
    public abstract int getColor();
    public Shape(int xPos, int yPos, int dimension) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.dimension = dimension;
    }
    @Override
    public String toString() {
        return String.format("\nClass: %s\n" +
                "  color: %d\n" +
                "  xPos: %d\n" +
                "  yPos: %d\n" +
                "  dimension: %d",
                getClass().getSimpleName(), getColor(), xPos, yPos, dimension);
    }
    public static Shape randomFactory() {
        int xPos = rand.nextInt(100);
        int yPos = rand.nextInt(100);
        int dimension = rand.nextInt(100);
        switch(counter++ % 3) {
            default:
            case 0: return new Circle(xPos, yPos, dimension);
            case 1: return new Square(xPos, yPos, dimension);
            case 2: return new Line(xPos, yPos, dimension);
        }
    }
    private void writeObject(ObjectOutputStream stream)
        throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(getColor());
    }
    private void readObject(ObjectInputStream stream)
            throws IOException, ClassNotFoundException{
        stream.defaultReadObject();
        setColor(stream.readInt());
    }
}

class Circle extends Shape {
    private static int color = RED;
    public Circle(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
        color = RED;
    }
    @Override
    public void setColor(int color) {
        Circle.color = color;
    }
    @Override
    public int getColor() {
        return Circle.color;
    }
}

class Square extends Shape {
    private static int color;
    public Square(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
        color = RED;
    }
    @Override
    public void setColor(int color) {
        Square.color = color;
    }
    @Override
    public int getColor() {
        return Square.color;
    }
}

class Line extends Shape {
    private static int color = RED;
    public static void serializeStaticState(ObjectOutputStream os)
        throws IOException {
        os.writeInt(color);
    }
    public static void deserealizeStaticState(ObjectInputStream in)
        throws IOException, ClassNotFoundException {
        color = in.readInt();
    }
    public Line(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }
    @Override
    public void setColor(int color) {
        Line.color = color;
    }
    @Override
    public int getColor() {
        return Line.color;
    }
}



public class StoreCADState {
    public static void main(String... args) throws Exception {
        List<Class<? extends Shape>> shapeTypes =
                new ArrayList<>();
        shapeTypes.add(Circle.class);
        shapeTypes.add(Square.class);
        shapeTypes.add(Line.class);

        List<Shape> shapes = new ArrayList<>();

        // Make more shapes:
        for(int i = 0; i < 10; i++)
            shapes.add(Shape.randomFactory());

        // Set all static colors to GREEN:
        for(Shape shape : shapes)
            shape.setColor(Shape.GREEN);

        // Save the state vector:
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("CADState.dat"));
        out.writeObject(shapeTypes);
        out.writeObject(shapes);
        out.close();

        // Display shapes
        print(shapes);
    }
}
