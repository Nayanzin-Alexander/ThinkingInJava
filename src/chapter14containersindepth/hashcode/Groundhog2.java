package chapter14containersindepth.hashcode;

/**
 * Created by nayanzin on 28.07.17.
 */
public class Groundhog2 extends Groundhog {

    public Groundhog2(int number){
        super(number);
    }

    @Override
    public int hashCode(){
        return number;
    }

    @Override
    public boolean equals(Object o){
        return ( (o instanceof Groundhog2) && ( ((Groundhog2) o).number == number));
    }
}
