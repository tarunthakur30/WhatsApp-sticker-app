package com.professionalcipher.stickers.newyearstickers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SaveDataOnSharePref {
    public void setData( String data, String Key, Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Key,data);
        editor.apply();
    }
    public String getData(String Default_Data,String Key,Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return  sharedPreferences.getString(Key,Default_Data);
    }
}
