package chapter4reusingobjects;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 27.06.17.
 */
class  Insect{
    private static int x1 = printInit("static Insect.x1 init");
    private int i = 9;
    protected int j;

    Insect(){
        print("i=" + i + " j=" + j);
    }

    static int printInit(String msg){
        print(msg);
        return 47;
    }
}

public class InitOrder extends Insect{
    private static int x2 = printInit("static InitOrder.x2 init");
    private int k = printInit("InitOrder.k initialized");

    public InitOrder() {
        print("k = " + k);
        print("j = " + j);
    }

    public static void main(String[] args) {
        print("Beetle constructor");
        InitOrder b = new InitOrder();
    }
}/*Output:
static Insect.x1 init
static InitOrder.x2 init
Beetle constructor
i=9 j=0
InitOrder.k initialized
k = 47
j = 0
*/


