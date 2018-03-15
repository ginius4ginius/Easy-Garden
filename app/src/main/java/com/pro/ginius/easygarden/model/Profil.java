package com.pro.ginius.easygarden.model;

import java.io.Serializable;

/**
 * Created by fcd on 08/03/2018.
 */

public class Profil implements Serializable {

    //déclaration des variables
    private String login;
    private String email;
    private String motDePasse;
    private String adresseRue;
    private Integer adresseCp;
    private String adresseVille;
    private Integer age;

    /**
     * constructeur avec paramètres
     * @param login
     * @param email
     * @param motDePasse
     * @param adresseRue
     * @param adresseCp
     * @param adresseVille
     * @param age
     */
    public Profil(String login, String email, String motDePasse, String adresseRue, Integer adresseCp, String adresseVille, Integer age){

        this.login = login;
        this.email = email;
        this.motDePasse = motDePasse;
        this.adresseRue = adresseRue;
        this.adresseCp = adresseCp;
        this.adresseVille = adresseVille;
        this.age = age;

    }

    //getters
    public String getLogin(){
        return login;
    }

    public String getEmail(){
        return email;
    }

    public String getMotDePasse(){
        return motDePasse;
    }

    public String getAdresseRue(){
        return adresseRue;
    }

    public Integer getAdresseCp(){
        return adresseCp;
    }

    public String getAdresseVille(){
        return adresseVille;
    }

    public Integer getAge(){
        return age;
    }


}
