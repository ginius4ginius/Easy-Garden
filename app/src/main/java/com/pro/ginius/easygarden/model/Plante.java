package com.pro.ginius.easygarden.model;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Derieu on 21/03/2018.
 */

public class Plante implements Serializable {

    //déclaration des variables
    private String nom;
    private String nomScientifique;
    private String descriptif;
    private String type;
    private String exposition;
    private String image;

    public Plante(String nom, String nomScientifique, String descriptif, String exposition, String type, String image ){
        this.nom = nom;
        this.nomScientifique = nomScientifique;
        this.descriptif = descriptif;
        this.type = type;
        this.exposition = exposition;
        this.image = image;
    }

    //getters
    public String getNom(){
        return nom;
    }

    public String getNomScientifique(){
        return nomScientifique;
    }

    public String getDescriptif(){
        return descriptif;
    }

    public String getType(){
        return type;
    }

    public String getExposition(){return exposition; }

    public String getImage(){
        return image;
    }

    /**
     * conversion de la plante au format JSONArray
     * @return
     */
    public JSONArray convertToJSONArray(){
        List liste = new ArrayList();
        liste.add(nom);
        liste.add(nomScientifique);
        liste.add(descriptif);
        liste.add(type);
        liste.add(exposition);
        liste.add(image);

        return new JSONArray(liste);
    }


}
