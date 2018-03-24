package jenkovtutorials;

/**
 * Created by nayanzin on 12.09.17.
 */
public class Exchanger {
    private Object object = new Object();
    private volatile boolean hasNewObject = false;

        public void put(Object newObject) {
            while(hasNewObject) {
                // wait. do not override existing new object
            }
            object = newObject;
            hasNewObject = true;
        }

        public Object take() {
            while(!hasNewObject) { // volatile read
                // wait, do not take old object or null
            }
            Object obj = object;
            hasNewObject = false; // volatile write
            return obj;
        }
}
