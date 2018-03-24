package chapter16enum;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 09.08.17.
 */
public enum OzWitch {
    // Instances must be defined first, before methods:
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby " +
            "Slippers, crushed by Dorothy’s house"),
    SOUTH("Good by inference, but missing");

    // Fields:
    private String description;

    // Constructor must be package or private access:
    OzWitch(String description) {
        this.description = description;
    }

    // Methods
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return name() + ": " + description;
    }

    public static void main(String[] args) {
        for(OzWitch witch : OzWitch.values())
            print(witch);
            //print(witch + ": " + witch.getDescription());
    }
}
