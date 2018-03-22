package com.pro.ginius.easygarden.controleur;

import android.content.Context;

import com.pro.ginius.easygarden.model.AccesDistant;
import com.pro.ginius.easygarden.model.Plante;
import com.pro.ginius.easygarden.model.Profil;

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
    public ArrayList<Plante> listePlantes = new ArrayList<Plante>();

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

    public ArrayList<Plante> getListePlantes() {
        return listePlantes;
    }

    public void setListePlantes(ArrayList<Plante> listePlantes) {
        this.listePlantes = listePlantes;
    }

    public void setProfil(Profil profil){
        utilisateur = profil;
    }

    public Profil getProfil(){
        return utilisateur;
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
     * fonction qui récupère les plantes vivace de la bd
     */
    public void RecupPlanteByVicace(){

        accesDistant.envoi("showPlanteVivace", null);

    }

    /**
     * fonction qui récupère les plantes annuelle de la bd
     */
    public void RecupPlanteByAnnuelle(){

        accesDistant.envoi("showPlanteAnnuelle", null);

    }
}


