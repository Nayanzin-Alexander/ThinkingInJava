package myutil;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 26.06.17.
 */
public class AccessTest {
    public      static String publicStatic;
                static String packageStatic;
    protected   static String protectedStatic;
    private     static String privateStatic;
    static{
        publicStatic    = "Public static";
        packageStatic   = "Package static";
        protectedStatic = "Protected static";
        privateStatic   = "Private static";
    }

    public      String publicStr;
                String packageStr;
    protected   String protectedStr;
    private     String privateStr;
    {
        publicStr       = "Public";
        packageStr      = "Package";
        protectedStr    = "Protected";
        privateStr      = "Private";
    }

    public      static void doPublicStatic(){       print("doPublicStatic");    }
                static void doPackageStatic(){      print("doPackageStatic");   }
    protected   static void doProtectedStatic(){    print("doProtectedStatic"); }
    private     static void doPrivateStatic(){      print("doPrivateStatic");   }

    public      void doPublic(){    print("doPublic");      }
                void doPackage(){   print("doPackage");     }
    protected   void doProtected(){ print("doProtected");   }
    private     void doPrivate(){   print("doPrivate");     }
}

