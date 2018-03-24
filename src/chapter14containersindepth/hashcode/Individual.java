package chapter14containersindepth.hashcode;

/**
 * Created by nayanzin on 31.07.17.
 */
public class Individual implements Comparable<Individual> {
    private static long counter = 0;
    private final long ID = counter++;
    private String name;

    public Individual(String name) {
        this.name = name;
    }

    public Individual(){}

    @Override
    public String toString() {
        return String.format("%s %s", getClass().getSimpleName(),
                name == null ? "" : name);
    }

    public long id() {
        return ID;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Individual) &&
                (ID == ( (Individual) o).id());
    }

    @Override
    public int hashCode() {
        int result = 17;
        if( name != null)
            result = 37 * result + name.hashCode();
        result = 37 * result + (int) ID;
        return result;
    }

    @Override
    public int compareTo(Individual arg) {
        // Compare class by name first:
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if(firstCompare != 0)
            return firstCompare;
        if(name != null && arg.name != null){
            int secondCompare = name.compareTo(arg.name);
            if(secondCompare != 0)
                return secondCompare;
        }
        return (arg.id() < id() ? -1 : (arg.id() == id() ? 0 : 1));
    }
}
