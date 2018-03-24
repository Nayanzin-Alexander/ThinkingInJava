package chapter11typeinformation.robot;

import myutil.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

/**
 * Created by nayanzin on 12.07.17.
 */

class NullRobotProxyHandler implements InvocationHandler{

    String nullName;
    String nullModel;
    private Robot proxiedRobot = new NRobot();

    NullRobotProxyHandler(Class<? extends Robot> type) {
        nullName = type.getSimpleName() + " NullRobot";
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxiedRobot, args);
    }

    private class NRobot implements Null, Robot {
        public String name() { return nullName; }
        public String model() { return nullModel; }
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }
}

public class NullRobot {
    public static Robot newNullRobot(Class<? extends Robot> type) {
        return (Robot) Proxy.newProxyInstance(
                NullRobot.class.getClassLoader(),
                new Class[]{ Null.class, Robot.class },
                new NullRobotProxyHandler(type));
    }


    public static void main(String[] args) {
        Robot[] bots = {
                new SnowRemovalRobot("SnowBee"),
                newNullRobot(SnowRemovalRobot.class)
        };
        for(Robot bot : bots)
            Robot.Test.test(bot);
    }
}
