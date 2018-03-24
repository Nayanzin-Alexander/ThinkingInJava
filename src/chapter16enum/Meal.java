package chapter16enum;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 14.08.17.
 */
public class Meal {
    public static void main(String... args) {
        for(int i = 0; i < 5; i++) {
            for(Cource course : Cource.values()) {
                Food food = course.randomSelection();
                print(food);
            }
            print("----------");
        }
    }
}
