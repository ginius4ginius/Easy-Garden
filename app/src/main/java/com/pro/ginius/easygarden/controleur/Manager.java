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
    public ArrayList<Plante> listePlantesFavori = new ArrayList<Plante>();

    /**
     * constructeur privée (pour singleton)
     */
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
//////////////////////getters et setters
    public ArrayList<Plante> getListePlantes(){

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

  /////////////////////////methodes

    /**
     * fonction qui créer un utilisateur
     * @param nom
     * @param prenom
     * @param age
     * @param pseudo
     * @param password
     * @param email
     */
    public void creerUtilisateur(String nom, String prenom, Integer age, String pseudo, String password, String email){
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
     * fonction pour mettre à jour le profil utilisateur
     * @param nom
     * @param prenom
     * @param age
     * @param pseudo
     */
    public void updateProfil(String nom, String prenom, int age, String pseudo,String password, String email){
        List liste = new ArrayList();
        liste.add(nom);
        liste.add(prenom);
        liste.add(age);
        liste.add(pseudo);
        liste.add(password);
        liste.add(email);

        parameters = new JSONArray(liste);
        accesDistant.envoi("updateProfil", parameters);
    }

    /**
     * fonction qui récupère les plantes vivace de la bd
     */
    public void RecupPlanteByVicace(){

        List liste = new ArrayList();
        liste.add(instance.getProfil());

        parameters = new JSONArray(liste);

        accesDistant.envoi("showPlanteVivace", parameters);

    }

    /**
     * fonction qui récupère les plantes annuelle de la bd
     */
    public void RecupPlanteByAnnuelle(){

        List liste = new ArrayList();
        liste.add(instance.getProfil());

        parameters = new JSONArray(liste);

        accesDistant.envoi("showPlanteAnnuelle", parameters);

    }

    /**
     * fonction qui récupère les plantes d'ombre de la bd
     */
    public void RecupPlanteByOmbre(){

        List liste = new ArrayList();
        liste.add(instance.getProfil());

        parameters = new JSONArray(liste);

        accesDistant.envoi("showPlanteOmbre", parameters);

    }

    /**
     * fonction qui récupère les plantes d'ombre de la bd
     */
    public void RecupPlanteByMiOmbre(){

        List liste = new ArrayList();
        liste.add(instance.getProfil());

        parameters = new JSONArray(liste);

        accesDistant.envoi("showPlanteMiOmbre", parameters);

    }

    /**
     * fonction qui récupère les plantes d'ombre de la bd
     */
    public void RecupPlanteBySoleil(){

        List liste = new ArrayList();
        liste.add(instance.getProfil());

        parameters = new JSONArray(liste);

        accesDistant.envoi("showPlanteSoleil", parameters);

    }

    /**
     * fonction qui récupère les plantes en favori de la bd
     */
    public void RecupPlanteByFavori(Plante plante){

        accesDistant.envoi("insertFavori", plante.convertToJSONArray());
        listePlantesFavori.add(plante);
    }

    /**
     * fonction qui supprime une plante depuis le favori de la bd
     */
    public void delFromFavori(Plante plante){

        accesDistant.envoi("delFromFavori", plante.convertToJSONArray());
        listePlantesFavori.remove(plante);

    }


}


