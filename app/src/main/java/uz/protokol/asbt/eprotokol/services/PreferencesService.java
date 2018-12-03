package uz.protokol.asbt.eprotokol.services;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesService {

    private static PreferencesService preferencesService;

    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;

    private PreferencesService(Context context) {
        preferences = context
                .getApplicationContext()
                .getSharedPreferences("SecurePref", 0);
    }

    public static PreferencesService getPreferencesService(Context context) {
        if (preferencesService == null) {
            preferencesService = new PreferencesService(context);
        }
        return preferencesService;
    }

    public <T> void addPreferences(String key, T value) {
        editor = preferences.edit();
        if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        }
        editor.apply();
    }

    public void clear() {
        if (editor != null) {
            editor.clear();
            editor.commit();
        }
    }

    public void deleteValueByKey(String key) {
        editor.remove(key);
        editor.commit();
    }

    public boolean getBoolean(String key) {
        return preferencesService.getBoolean(key);
    }

    public Integer getInt(String key) {
        return preferencesService.getInt(key);
    }

    public Long getLong(String key) {
        return preferencesService.getLong(key);
    }

    public Float getFloat(String key) {
        return preferencesService.getFloat(key);
    }

    public String getString(String key) {
        return preferencesService.getString(key);
    }

}
