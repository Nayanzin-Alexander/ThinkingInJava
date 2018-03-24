package chapter7innerclasses.controlframework;

/**
 * Created by nayanzin on 01.07.17.
 */

public abstract class Event {
    private long eventTime;
    protected long delayTime;

    public Event(long delayTime){
        this.delayTime = delayTime;
        this.start();
    }

    public void start(){
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready(){
        return System.nanoTime() >= eventTime;
    }

    // must be implemented in descendant classes
    public abstract void action();
}
