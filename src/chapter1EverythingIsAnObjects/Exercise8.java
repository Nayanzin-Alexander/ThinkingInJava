package chapter1EverythingIsAnObjects;


/** The first Thinking in Java example program.
 * demonstrates that, no matter how many objects
 * you create of a particular class, there is only one instance of a particular static field in that
 * class.
 * @author Alex Nayanzin
 * @version 1.0
 */
public class Exercise8 {

    /** Entry point to class and application.
     *  @param args array of string arguments
     */
    public static void main(String[] args) {
        InnerClassWithStaticField class1 = new InnerClassWithStaticField();
        InnerClassWithStaticField class2 = new InnerClassWithStaticField();
        InnerClassWithStaticField class3 = new InnerClassWithStaticField();
        InnerClassWithStaticField class4 = new InnerClassWithStaticField();
        InnerClassWithStaticField class5 = new InnerClassWithStaticField();

        for (int i = 0; i < 10; i++) {
            class1.staticIntValue++;
            class2.staticIntValue++;
            class3.staticIntValue++;
            class4.staticIntValue++;
        }
        System.out.println( "class1 staticIntValue is " + class1.staticIntValue);
        System.out.println( "class2 staticIntValue is " + class2.staticIntValue);
        System.out.println( "class3 staticIntValue is " + class3.staticIntValue);
        System.out.println( "class4 staticIntValue is " + class4.staticIntValue);
        System.out.println( "class5 staticIntValue is " + class5.staticIntValue);
    }
}

/**
 * Inner class with static field
 */
class InnerClassWithStaticField {
    public static int staticIntValue = 0;
}
/* Output: (100% match)
    class1 staticIntValue is 40
    class2 staticIntValue is 40
    class3 staticIntValue is 40
    class4 staticIntValue is 40
    class5 staticIntValue is 40
    *///:~
