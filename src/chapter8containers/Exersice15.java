package chapter8containers;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 03.07.17.
 * Exercise 15: (4) Stacks are often used to evaluate expressions in programming languages.
 * Using net.mindview.util.Stack, evaluate the following expression,
 * where’+’ means "push the following letter onto the stack,
 * " and’-’ means "pop the top of the stack and print it":
 *  "+U+n+c—+e+r+t—+a-+i-+n+t+y—+ -+r+u—+l+e+s—"
 */
public class Exersice15 {
    public static void main(String... args){
        Stack<Character> stack = new Stack<>();
        String expression = "+U+n+c—+e+r+t—+a-+i-+n+t+y—+ -+r+u—+l+e+s—";
        int operation = 0;
        for(char ch : expression.toCharArray()){
            switch (ch){
                case '+':{
                    operation = 1;
                    break;
                }
                case '—':
                case '-':{
                    operation = 0;
                    print(stack.pop());
                    break;
                }
                default:{
                    if(operation == 1){
                        stack.push(ch);
                    }
                    break;
                }
            }
        }
        print(stack);
    }
}
