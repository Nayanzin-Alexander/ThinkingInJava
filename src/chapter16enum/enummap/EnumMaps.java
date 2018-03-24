package chapter16enum.enummap;

import chapter16enum.enumset.AlarmPoints;

import java.util.EnumMap;
import java.util.Map;

import static chapter16enum.enumset.AlarmPoints.*;
import static myutil.Printer.print;
import static myutil.Printer.printInLine;

/**
 * Created by nayanzin on 14.08.17.
 */

interface Command {
    void action();
}

public class EnumMaps {
    public static void main(String... args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);

        em.put(KITCHEN, ()->printInLine("Kitchen fire\n"));
        em.put(BATHROOM, ()->printInLine("Bathroom alert\n"));

        for(Map.Entry<AlarmPoints, Command>  e : em.entrySet()){
            print(e.getKey() + ":");
            e.getValue().action();
        }


    }

}
