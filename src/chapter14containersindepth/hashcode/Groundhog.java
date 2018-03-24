package chapter14containersindepth.hashcode;

/**
 * Created by nayanzin on 28.07.17.
 */
public class Groundhog {
    protected int number;
    public Groundhog(int number){
        this.number = number;
    }
    @Override
    public String toString(){
        return String.format("Groundhog #%d", number);
    }
}
