package chapter11typeinformation.somethingaboutrtti;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nayanzin on 10.07.17.
 */
public class ForNamePetCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
    private static String[] typeNames = {
            "chapter11typeinformation.somethingaboutrtti.Cat",
            "chapter11typeinformation.somethingaboutrtti.Mutt",
            "chapter11typeinformation.somethingaboutrtti.Pug",
            "chapter11typeinformation.somethingaboutrtti.EgyptianMau",
            "chapter11typeinformation.somethingaboutrtti.Manx",
            "chapter11typeinformation.somethingaboutrtti.Cymric",
            "chapter11typeinformation.somethingaboutrtti.Rat",
            "chapter11typeinformation.somethingaboutrtti.Mouse",
            "chapter11typeinformation.somethingaboutrtti.Hamster"
    };

    private static void loader(){
        for(String typeName : typeNames){
            try{
                types.add( (Class<? extends Pet> ) Class.forName(typeName));
            } catch(ClassNotFoundException e){
                throw new RuntimeException(e);
            }
        }
    }

    static{
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
