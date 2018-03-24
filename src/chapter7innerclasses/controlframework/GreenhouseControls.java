package chapter7innerclasses.controlframework;

import java.util.List;

/**
 * Created by nayanzin on 01.07.17.
 */
public class GreenhouseControls extends Controller {
    private boolean light = false;
    public class LightOn extends Event{
        public LightOn(long delayTime){
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here to
            // physically turn on the light.
            light = true;
        }

        public String toString(){
            return "The light is on";
        }
    }
    public class LightOff extends Event{
        public LightOff(long delayTime){
            super(delayTime);
        }
        @Override
        public void action(){
            // Put hardware control code here to
            // physically turn off the light.
            light = false;
        }
        public String toString(){
            return "The light is off";
        }
    }

    private boolean water = false;
    public class WaterOn extends Event{
        public WaterOn(long delayTime){
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here to
            // physically turn on the water.
            water = true;
        }

        public String toString(){
            return "The water is on";
        }
    }
    public class WaterOff extends Event{
        public WaterOff(long delayTime){
            super(delayTime);
        }
        @Override
        public void action(){
            // Put hardware control code here to
            // physically turn off the water.
            water = false;
        }
        public String toString(){
            return "The water is off";
        }
    }

    private String thermostat = "Day";
    public class ThermostatDay extends Event{
        public ThermostatDay(long delayTime){
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Day";
        }

        public String toString(){
            return "Thermostat on day setting";
        }
    }
    public class ThermostatNight extends Event{
        public ThermostatNight(long delayTime){
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }

        public String toString(){
            return "Thermostat on night setting";
        }
    }

    // An example of an action() that inserts a
    // new one of itself into the event list:
    public class Bell extends Event{
        public Bell(long delayTime){
            super(delayTime);
        }

        @Override
        public void action() {
            // we inherits from Controller method addEvent, so we can:
            addEvent(new Bell(delayTime));
        }

        public String toString(){
            return "Bing Bing!!!";
        }
    }

    public class Restart extends Event{

        private List<Event> eventList;

        public Restart(long delayTime, List<Event> eventList){
            super(delayTime);
            this.eventList = eventList;
            for(Event e : eventList){
                addEvent(e);
            }
        }

        @Override
        public void action() {
            for(Event e : eventList) {
                e.start(); // Rerun each event
                addEvent(e);
            }
            start(); // Rerun this Event
            addEvent(this);
        }

        public String toString(){
            return "Restarting system";
        }
    }
    public class Terminate extends Event{
        public Terminate(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            System.exit(0);
        }
        public String toString() {
            return "Terminating";
        }
    }
}
