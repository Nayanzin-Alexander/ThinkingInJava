package unittest;

import java.lang.annotation.*;

/**
 * Created by nayanzin on 20.08.17.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestProperty {
}
