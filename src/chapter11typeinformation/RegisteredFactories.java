package chapter11typeinformation;

import chapter7innerclasses.Parcel1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 11.07.17.
 */
class Part{
    public String toString(){
        return getClass().getSimpleName();
    }

    static List<Class<? extends Part>> partFactories = new
            ArrayList<>();
    static{
        partFactories.add(FuelFilter.class);
        partFactories.add(AirFilter.class);
        partFactories.add(CabinAirFilter.class);
        partFactories.add(OilFilter.class);
        partFactories.add(FanBelt.class);
        partFactories.add(PowerSteeringBelt.class);
        partFactories.add(GeneratorBelt.class);
    }

    private static Random rand = new Random(47);

    public static Part createRandom(){
        //return partFactories.get(rand.nextInt(partFactories.size())).create();
        try {
            return partFactories.get(rand.nextInt(partFactories.size())).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Filter extends Part{}
class FuelFilter extends Filter{
    public static class Factory
            implements chapter11typeinformation.Factory<FuelFilter>{
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }

}
class AirFilter extends Filter {
    public static class Factory
            implements chapter11typeinformation.Factory<AirFilter> {
        public AirFilter create() { return new AirFilter(); }
    }
}
class CabinAirFilter extends Filter {
    public static class Factory
            implements chapter11typeinformation.Factory<CabinAirFilter> {
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}
class OilFilter extends Filter {
    public static class Factory
            implements chapter11typeinformation.Factory<OilFilter> {
        public OilFilter create() { return new OilFilter(); }
    }
}
class Belt extends Part {}
class FanBelt extends Belt {
    public static class Factory
            implements chapter11typeinformation.Factory<FanBelt> {
        public FanBelt create() { return new FanBelt(); }
    }
}
class GeneratorBelt extends Belt {
    public static class Factory
            implements chapter11typeinformation.Factory<GeneratorBelt> {
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}
class PowerSteeringBelt extends Belt {
    public static class Factory
            implements chapter11typeinformation.Factory<PowerSteeringBelt> {
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}


public class RegisteredFactories {
    public static void main(String... args){
        for(int i=0; i<10; i++)
            print(Part.createRandom());
    }
}
