package chapter16enum.enumset;

import java.util.EnumSet;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 14.08.17.
 */
public class EnumSets {
    public static void main(String... args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(AlarmPoints.BATHROOM);
        print(points);

        points.addAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        print(points);

        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        print(points);

        points.removeAll(EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));
        print(points);

        points = EnumSet.complementOf(points);
        print(points);
    }
}
