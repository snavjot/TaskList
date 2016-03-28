package com.navjot.storage;

import android.content.SharedPreferences;

/**
 * Created by navsin on 3/29/2016.
 */
public class KeyValueStoreHelper {
    private SharedPreferences sharedPreferences;

    public KeyValueStoreHelper (SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void putLong(String key, Long value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public Long getLong(String key) {
        if (sharedPreferences.contains(key))
            return sharedPreferences.getLong(key, 0);
        else
            return null;
    }

    public String getString(String key) {
        if (sharedPreferences.contains(key))
            return sharedPreferences.getString(key, null);
        else
            return null;
    }
}
