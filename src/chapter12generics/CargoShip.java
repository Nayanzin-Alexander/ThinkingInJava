package chapter12generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 13.07.17.
 */
class Product{
    private final int id;
    private String description;
    private double price;
    public Product(int IDnumber, String descr, double price) {
        id = IDnumber;
        description = descr;
        this.price = price;
        System.out.println(toString());
    }
    public void priceChange(double change) {
        price += change;
    }
    public static Generator<Product> generator =
            new Generator<Product>() {
                private Random rand = new Random(47);
                public Product next() {
                    return new Product(rand.nextInt(1000), "TestJunit1",
                            Math.round(rand.nextDouble() * 1000.0) + 0.99);
                }
            };
    public String toString() {
        return id + ": " + description + ", price: $" + price;
    }
}

class Container extends ArrayList<Product> {
    public Container(int nProducts){
        Generators.fill(this, Product.generator, nProducts);
    }
}

class Level extends ArrayList<Container> {
    public Level(int nContainers, int nProducts){
        for(int i=0; i<nContainers; i++)
            add(new Container(nProducts));
    }
}

public class CargoShip {
    List<Level> levels = new ArrayList<>();

    public CargoShip(int nLevels, int nContainers, int nProducts){
        for(int i=0; i<nLevels; i++)
            levels.add(new Level(nContainers, nProducts));
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Level a : levels)
            for(Container s : a)
                for(Product p : s) {
                    result.append(p);
                    result.append("\n");
                }
        return result.toString();
    }

    public static void main(String... args){
        CargoShip cs = new CargoShip(1,2,3);
        print(cs);
    }
}
