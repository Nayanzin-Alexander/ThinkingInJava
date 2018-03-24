package chapter7innerclasses.controlframework;

import java.util.ArrayList;
import java.util.List;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 01.07.17.
 */
public class Controller {
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event event){
        eventList.add(event);
    }

    public void run(){
        print("Starting");
        while(eventList.size() > 0){
            // Make a copy so you’re not modifying the list
            // while you’re selecting the elements in it:
            for(Event e : new ArrayList<Event>(eventList)){
                if(e.ready()){
                    e.start();
                    print(e);
                    eventList.remove(e);
                }
            }
        }
    }
}
