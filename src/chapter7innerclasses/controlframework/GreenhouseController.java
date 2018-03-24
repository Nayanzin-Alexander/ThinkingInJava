package chapter7innerclasses.controlframework;

import java.util.Arrays;

/**
 * Created by nayanzin on 01.07.17.
 */
public class GreenhouseController {
    public static void main(String... args){
        GreenhouseControls gc = new GreenhouseControls();

        // Instead of hard-wiring, you could parse
        // configuration information from a text file here:
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000, Arrays.asList(eventList)));
        //gc.addEvent(gc.new Terminate(10000));
        gc.run();
    }
}
