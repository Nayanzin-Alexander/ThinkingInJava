package chapter1EverythingIsAnObjects;

/**
 * Created by nayanzin on 21.06.17.
 * Exercise 1: (2) Create a class containing an int and a char that are not initialized,
 * and print their values to verify that Java performs default initialization.
 */
public class Exercise1 {
    int  fieldA;  // class fields of primitive types ara initialized with default values
    char fieldB;  // class fields of primitive types ara initialized with default values

    public static void main(String[] args){
        int  intValue = 0;      //local variables have to be initialized
        char charValue = 'a';   //local variables have to be initialized
        System.out.println(intValue);
        System.out.println(charValue);
        Exercise1 exercise1 = new Exercise1();
        System.out.println(exercise1.fieldA);
        System.out.println(exercise1.fieldB);
    }
}
/**
 * Output: compile error: variable intValue and charValue
 * might not have been initialized. Why?
 * Because they are local variables, so they have to be initialized.
 * So I had to initialize it
 * Now output is:
 * 0
 * a
 */
