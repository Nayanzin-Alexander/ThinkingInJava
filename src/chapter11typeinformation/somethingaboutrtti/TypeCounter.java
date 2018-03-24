package chapter11typeinformation.somethingaboutrtti;

import java.util.HashMap;

/**
 * Created by nayanzin on 11.07.17.
 */
public class TypeCounter extends HashMap<Class<?>, Integer>{
    private Class<?> baseType;

    public TypeCounter(Class<?> baseType){
        this.baseType = baseType;
    }

    public void count(Object obj){
        Class<?> type = obj.getClass();
        if(!baseType.isAssignableFrom(type)){
            throw new RuntimeException(obj + " incorrect type: "
                    + type + ", should be type or subtype of "
                    + baseType);
        }
        countClass(type);
    }

    private void countClass(Class<?> type){
        Integer quantity = this.get(type);
        put(type, quantity == null ? 1 : quantity + 1);

        Class<?> superClass = type.getSuperclass();
        if(superClass != null && baseType.isAssignableFrom(superClass)){
            countClass(superClass);
        }
    }
}
