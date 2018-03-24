package jenkovtutorials;

/**
 * Created by nayanzin on 12.09.17.
 */
public class MySignal {
    protected boolean hasDataToProcess = false;

    public synchronized boolean hasDataToProcess(){
        return this.hasDataToProcess;
    }

    public synchronized void setHasDataToProcess(boolean hasData){
        this.hasDataToProcess = hasData;
    }
}
