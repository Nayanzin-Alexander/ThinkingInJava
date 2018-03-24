package chapter14containersindepth.hashcode;

import java.util.Random;

/**
 * Created by nayanzin on 28.07.17.
 */
public class Prediction {
    private static Random rand = new Random(47);
    private boolean shadow = rand.nextDouble() < 0.5;
    public String toString(){
        if(shadow){
            return "Six more weeks of winter";
        } else {
            return "Early spring";
        }
    }
}
