package protect.babysleepsounds;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {

    private static final String LOW_PASS_FILTER_ENABLED = "filter_enabled";
    private static final String LOW_PASS_FILTER_FREQUENCY = "filter_value";

    private static Preferences instance;

    private final SharedPreferences preferences;

    private Preferences(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static Preferences get(Context context) {
        if (instance == null) {
            instance = new Preferences(context);
        }

        return instance;
    }

    public boolean isLowPassFilterEnabled() {
        return preferences.getBoolean(LOW_PASS_FILTER_ENABLED, false);
    }

    public int getLowPassFilterFrequency() {
        return preferences.getInt(LOW_PASS_FILTER_FREQUENCY, 1000);
    }

}
