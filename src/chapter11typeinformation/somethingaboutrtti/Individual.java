package chapter11typeinformation.somethingaboutrtti;

/**
 * Created by nayanzin on 10.07.17.
 */
public class Individual {
    private final long ID = count++;
    private static long count = 0;
    private String name;

    public Individual(){}
    public Individual(String name){
        this.name = name;
    }

    public String getName(){
        return name != null? name : "";
    }
}
