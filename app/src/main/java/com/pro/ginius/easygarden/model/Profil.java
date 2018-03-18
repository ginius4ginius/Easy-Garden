package com.pro.ginius.easygarden.model;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fcd on 08/03/2018.
 */

public class Profil implements Serializable {

    //déclaration des variables
    private String nom;
    private String prenom;
    private Integer age;
    private String pseudo;
    private String password;
    private String email;

    /**
     * constructeur avec paramètres
     * @param nom
     * @param prenom
     * @param age
     * @param pseudo
     * @param password
     * @param email
     * @param age
     */
    public Profil(String nom, String prenom, Integer age, String pseudo, String password, String email){

        this.nom = nom;
        this.email = email;
        this.prenom = prenom;
        this.password = password;
        this.pseudo = pseudo;
        this.age = age;

    }

    //getters
    public String getNom(){
        return nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public Integer getAge(){
        return age;
    }

    public String getPseudo(){
        return pseudo;
    }

    public String getPassword(){return password; }

    public String getEmail(){
        return email;
    }

    /**
     * conversion du profil au format JSONArray
     * @return
     */
    public JSONArray convertToJSONArray(){
        List liste = new ArrayList();
        liste.add(nom);
        liste.add(prenom);
        liste.add(age);
        liste.add(pseudo);
        liste.add(password);
        liste.add(email);

        return new JSONArray(liste);
    }
}
