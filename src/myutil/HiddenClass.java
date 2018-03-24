package myutil;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 12.07.17.
 */
public class HiddenClass {
        private String privateName = "Private";
        String packageName = "Package";
        protected String protectedName = "Protected";

        private String getPrivate(String s){return privateName; }
        String getPackage(HiddenClass i){return packageName;}
        protected String getProtected(String b){return protectedName; }
}
