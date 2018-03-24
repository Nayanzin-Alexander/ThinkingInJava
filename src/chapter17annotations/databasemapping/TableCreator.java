package chapter17annotations.databasemapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 20.08.17.
 */
public class TableCreator {
    public static void main(String... args)
        throws Exception {
        if(args.length < 1) {
            print("arguments: annotated classes");
            System.exit(-1);
        }
        for(String className : args) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if(dbTable == null) {
                print("No DBTable annotation in class " + className);
                continue;
            }
            String tableName = dbTable.name();
            // If the name is empty, use Class name;
            if(tableName.length() < 1)
                tableName = className.toUpperCase();

            StringBuilder createCommand = new StringBuilder("" +
                    "CREATE TABLE " + tableName + "(");

            List<String> columnDefs = new ArrayList<>();
            for(Field field : cl.getDeclaredFields()) {
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if(anns.length < 1)
                    continue;
                if(anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    // Use field name if name is not specified
                    if(sInt.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sInt.name();
                    columnDefs.add(columnName + " INT" +
                    getConstraints(sInt.constraints()));
                }

                if(anns[0] instanceof SQLString) {
                    SQLString sStr = (SQLString) anns[0];
                    // Use field name if name is not specified
                    if(sStr.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sStr.name();
                    columnDefs.add(columnName + " VARCHAR(" +
                            sStr.value() + ") " +
                            getConstraints(sStr.constraints()));
                }


            }

            for(String columnDef : columnDefs)
                createCommand.append("\n   " + columnDef + ",");
            // Remove trailing comma
            String tableCreate =
                    createCommand.substring(0, createCommand.length()-1) + "\n);";
            print("Table Creation SQL for " + className + " is\n" + tableCreate);
        }
    }

    private static String getConstraints(Constraints con) {
        StringBuilder constraints = new StringBuilder();
        if(!con.allowNull())
            constraints.append(" NOT NULL");
        if(con.primaryKey())
            constraints.append(" PRIMARY KEY");
        if(con.unique())
            constraints.append(" UNIQUE");
        return constraints.toString();
    }
}
