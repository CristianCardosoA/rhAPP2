package fca.mx.rhapp;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {

    public enum SHAREDPREFERENCE_KEY {

        KEY_LOGIN(false);

        SHAREDPREFERENCE_KEY(final Object defaultValue) {
            mDefaultValue = defaultValue;
        }

        public Object getDefault() {
            return mDefaultValue;
        }

        private final Object mDefaultValue;
    }

    private Preferences() {
    }

    private static SharedPreferences getSharedPreferences(final Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences;
    }

    private static SharedPreferences.Editor getEditor(final Context context) {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.edit();
    }


    public static void setBoolean(final Context context, final SHAREDPREFERENCE_KEY key, final boolean value) {
        final Object defaultValue = key.getDefault();
        if (defaultValue instanceof Boolean) {
            getEditor(context).putBoolean(key.name(), value).commit();
        } else {
            throw new IllegalArgumentException("Can not store boolean value in " + key.name());
        }
    }


    public static Boolean getBoolean(final Context context, final SHAREDPREFERENCE_KEY key) {
        final Object defaultValue = key.getDefault();
        if (defaultValue instanceof Boolean) {
            return getSharedPreferences(context).getBoolean(key.name(), (Boolean) defaultValue);
        } else {
            throw new IllegalArgumentException("Boolean value does not exist for " + key.name());
        }
    }


    public static void setInteger(final Context context, final SHAREDPREFERENCE_KEY key, final int value) {
        final Object defaultValue = key.getDefault();
        if (defaultValue instanceof Integer) {
            getEditor(context).putInt(key.name(), value).commit();
        } else {
            throw new IllegalArgumentException("Can not store Integer value in " + key.name());
        }
    }


    public static int getInteger(final Context context, final SHAREDPREFERENCE_KEY key) {
        final Object defaultValue = key.getDefault();

        if (defaultValue instanceof Integer) {
            return getSharedPreferences(context).getInt(key.name(), (Integer) defaultValue);
        } else {
            throw new IllegalArgumentException("Integer value does not exist for " + key.name());
        }
    }


    public static void setString(final Context context, final SHAREDPREFERENCE_KEY key, final String value) {
        final Object defaultValue = key.getDefault();
        if ((defaultValue == null) || (defaultValue instanceof String)) {
            getEditor(context).putString(key.name(), value).commit();
        } else {
            throw new IllegalArgumentException("Can not store String value in " + key.name());
        }
    }


    public static String getString(final Context context, final SHAREDPREFERENCE_KEY key) {
        final Object defaultValue = key.getDefault();

        if ((defaultValue == null) || (defaultValue instanceof String)) {
            return getSharedPreferences(context).getString(key.name(), (String) defaultValue);
        } else {
            throw new IllegalArgumentException("String value does not exist for " + key.name());
        }
    }


    public static void setLong(final Context context, final SHAREDPREFERENCE_KEY key, final long value) {
        final Object defaultValue = key.getDefault();
        if ((defaultValue == null) || (defaultValue instanceof Long)) {
            getEditor(context).putLong(key.name(), value).commit();
        } else {
            throw new IllegalArgumentException("Can not store String value in " + key.name());
        }
    }


    public static long getLong(final Context context, final SHAREDPREFERENCE_KEY key) {
        final Object defaultValue = key.getDefault();

        if ((defaultValue == null) || (defaultValue instanceof Long)) {
            return getSharedPreferences(context).getLong(key.name(), (Long) defaultValue);
        } else {
            throw new IllegalArgumentException("String value does not exist for " + key.name());
        }
    }
}
