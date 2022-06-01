package com.rizky_02736.desemar;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.rizky_02736.desemar.model.login.LoginData;

import java.util.HashMap;

public class SessionManager {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String ID_USER ="id_user";
    public static final String USERNAME ="username";
    public static final String NAMA ="nama";

    public SessionManager (Context context){
        this._context=context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(LoginData user){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(ID_USER, user.getIdUser());
        editor.putString(USERNAME, user.getUsername());
        editor.putString(NAMA, user.getNama());
        editor.commit();
    }
    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(ID_USER, sharedPreferences.getString(ID_USER, null));
        user.put(USERNAME, sharedPreferences.getString(USERNAME, null));
        user.put(NAMA, sharedPreferences.getString(NAMA, null));
        return user;
    }

    public void logoutSession(){
        editor.clear();
        editor.commit();

    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);


    }

}
