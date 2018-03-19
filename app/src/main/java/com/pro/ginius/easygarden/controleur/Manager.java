package com.pro.ginius.easygarden.controleur;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.pro.ginius.easygarden.model.AccesDistant;
import com.pro.ginius.easygarden.model.Profil;
import com.pro.ginius.easygarden.vue.LoginActivity;
import com.pro.ginius.easygarden.vue.MainActivity;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fcd on 08/03/2018.
 */

public class Manager {

    private static Manager instance = null;
    private Profil utilisateur = null;
    private static AccesDistant accesDistant;
    private static Context c;
    private JSONArray parameters;

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
        accesDistant  = new AccesDistant();
        return instance;

    }

    /**
     * fonction qui créer un utilisateur
     * @param nom
     * @param prenom
     * @param age
     * @param pseudo
     * @param password
     * @param email
     */
    public void creerUtilisatreur(String nom, String prenom, Integer age, String pseudo, String password, String email){
        Profil newP = new Profil(nom,prenom,age,pseudo,password,email);
        accesDistant.envoi("enreg",newP.convertToJSONArray());
    }

    /**
     * fonction qui recupère l'identifiant de la base correspondant au profil.
     * @param pseudo
     * @param password
     */
    public void controleUtilisateur(String pseudo, String password){

        List liste = new ArrayList();
        liste.add(pseudo);
        liste.add(password);

         parameters = new JSONArray(liste);
       accesDistant.envoi("login", parameters);

    }

    /**
     * inserer les données récup de la bd dans le profil du manager
     * @param profil
     */
    public void setProfil(Profil profil){
        utilisateur = profil;
    }

    public Profil getProfil(){
        return utilisateur;
    }
}


