package chapter15io.preferences;

import java.util.prefs.Preferences;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 09.08.17.
 */
public class PreferencesDemo {
    public static void main(String... args) throws Exception {
        Preferences prefs =
                Preferences.userNodeForPackage(PreferencesDemo.class);
        prefs.put("Location", "Oz");
        prefs.put("Footwear", "Ruby Slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are there witches?", true);
        int usageCount = prefs.getInt("UsageCount", 0);
        usageCount++;
        prefs.putInt("UsageCount", usageCount);

        for(String key : prefs.keys()){
            print(key + ": " + prefs.get(key, null));
        }

        print("How many companions does Dorothy have?");
        print(prefs.getInt("Companions", 0));
    }
}
