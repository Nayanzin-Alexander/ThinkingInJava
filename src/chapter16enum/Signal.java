package chapter16enum;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 14.08.17.
 */
public class Signal {

    private enum Colors {RED, YELLOW, GREEN}
    public static   Colors currentColor = Colors.RED;

    public static void change(){
        switch(currentColor){
            case RED: currentColor = Colors.GREEN;
                break;
            case YELLOW: currentColor = Colors.RED;
                break;
            case GREEN: currentColor = Colors.YELLOW;
                break;

        }
    }

    public static void main(String... args) {
        for(int i = 0; i<6; i++){
            change();
            print(currentColor);
        }
        for(Colors color:Colors.values()){
            print(color);
        }

    }

}
