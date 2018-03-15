package com.pro.ginius.easygarden.controleur;

import android.content.Context;

import com.pro.ginius.easygarden.model.Dao;
import com.pro.ginius.easygarden.model.Profil;

/**
 * Created by fcd on 08/03/2018.
 */

public class Manager {

    private static Manager instance = null;
    private static Profil profil = null;
    private static Dao accesDistant;
    private static Context c;

    //constructeur privée (pour singleton)
    private Manager(){
        super();
    }

    public static final Manager getInstance(Context cont ){

        if(instance != null) {
            return instance;

        }else
            c = cont;
        instance = new Manager();
        // accesLocal = new AccesLocal(c);
        accesDistant  = new Dao();


        return instance;

    }
}


