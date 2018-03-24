package chapter11typeinformation.robot;

import java.util.Arrays;
import java.util.List;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 12.07.17.
 */
public class SnowRemovalRobot implements Robot{

    private String name;

    public SnowRemovalRobot(String name) {this.name = name;}

    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return "SnowBot Series 11";
    }

    @Override
    public List<Operation> operations() {
        return Arrays.asList(
                new Operation() {
                    @Override
                    public String description() {
                        return name + " can shovel snow";
                    }

                    @Override
                    public void command() {
                        print(name + " shoveling snow");
                    }
                },
                new Operation() {
            public String description() {
                return name + " can chip ice";
            }
            public void command() {
                print(name + " chipping ice");
            }
        },
                new Operation() {
                    public String description() {
                        return name + " can clear the roof";
                    }
                    public void command() {
                        print(name + " clearing roof");
                    }
                }
        );
    }

    public static void main(String[] args) {
        Robot.Test.test(new SnowRemovalRobot("Slusher"));
    }
}
