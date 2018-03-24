package chapter17annotations.databasemapping;

/**
 * Created by nayanzin on 20.08.17.
 */
public @interface Uniqueness {
    Constraints constaints()
            default @Constraints(unique = true);
}
