package preference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by nguyentviet3513 on 1/11/2018.
 */

public class SharedPreference {
    public synchronized static SharedPreferences getMainPreferences(Context context) {
        return context.getSharedPreferences(context.getPackageName() + ".MAIN_PREFERENCE", Context.MODE_PRIVATE);
    }

    private synchronized static void setPreferenceString(Context context, String key, String value) {
        SharedPreferences.Editor mEditor = getMainPreferences(context).edit();
        mEditor.putString(key, value);
        mEditor.apply();
    }

    private synchronized static String getPreferenceString(Context context, String key, String defaultValue) {
        return getMainPreferences(context).getString(key, defaultValue);
    }

    private synchronized static void setPreferenceBoolean(Context context, String key, boolean value) {
        SharedPreferences.Editor mEditor = getMainPreferences(context).edit();
        mEditor.putBoolean(key, value);
        mEditor.apply();
    }

    private synchronized static boolean getPreferenceBoolean(Context context, String key, boolean defaultValue) {
        return getMainPreferences(context).getBoolean(key, defaultValue);
    }

    private synchronized static void setPreferenceInt(Context context, String key, int value) {
        SharedPreferences.Editor mEditor = getMainPreferences(context).edit();
        mEditor.putInt(key, value);
        mEditor.apply();
    }

    private synchronized static int getPreferenceInt(Context context, String key, int defaultValue) {
        return getMainPreferences(context).getInt(key, defaultValue);
    }

    private synchronized static void setPreferenceFloat(Context context, String key, float value) {
        SharedPreferences.Editor mEditor = getMainPreferences(context).edit();
        mEditor.putFloat(key, value);
        mEditor.apply();
    }

    private synchronized static float getPreferenceFloat(Context context, String key, float defaultValue) {
        return getMainPreferences(context).getFloat(key, defaultValue);
    }

    private synchronized static void setPreferenceLong(Context context, String key, long value) {
        SharedPreferences.Editor mEditor = getMainPreferences(context).edit();
        mEditor.putLong(key, value);
        mEditor.apply();
    }

    private synchronized static long getPreferenceLong(Context context, String key, long defaultValue) {
        return getMainPreferences(context).getLong(key, defaultValue);
    }

    private synchronized static void removeKey(Context context, String key) {
        SharedPreferences.Editor mEditor = getMainPreferences(context).edit();
        mEditor.remove(key);
        mEditor.apply();
    }

}
