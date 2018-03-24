package chapter16enum;

import java.util.EnumSet;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 14.08.17.
 */
public class CarWash {
    public enum Cycle {
        UNDERBODY {
            void action() { print("Spraying the underbody"); }
        },
        WHEELWASH {
            void action() { print("Washing the wheels"); }
        },
        PREWASH {
            void action() { print("Loosening the dirt"); }
        },
        BASIC {
            void action() { print("The basic wash"); }
        },
        HOTWAX {
            void action() { print("Applying hot wax"); }
        },
        RINSE {
            void action() { print("Rinsing"); }
        },
        BLOWDRY {
            void action() { print("Blowing dry"); }
        };
        abstract void action();
    }

    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC, Cycle.RINSE);

    public void add(Cycle cycle) {
        cycles.add(cycle);
    }

    public void carWash() {
        for(Cycle cycle : cycles) {
            cycle.action();
        }
    }

    public String toString() {
        return cycles.toString();
    }

    public static void main(String... args) {
        CarWash wash = new CarWash();
        print(wash);
        wash.carWash();

        // Order of addition is unimportand:
        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.RINSE);
        wash.add(Cycle.HOTWAX);
        print(wash);
        wash.carWash();
    }
}
