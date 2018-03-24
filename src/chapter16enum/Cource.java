package chapter16enum;

import myutil.Enums;

/**
 * Created by nayanzin on 14.08.17.
 */
public enum Cource {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;
    // Constructor
    private Cource(Class<?extends Food> kind) {
        values = kind.getEnumConstants();
    }
    public Food randomSelection() {
        return Enums.random(values);
    }
}
