package com.pro.ginius.easygarden.model;

import android.util.Log;

import com.pro.ginius.easygarden.controleur.Manager;
import com.pro.ginius.easygarden.outils.AccesHTTP;
import com.pro.ginius.easygarden.outils.AsyncResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fcd on 08/03/2018.
 */

public class AccesDistant implements AsyncResponse{

    //variables
    Manager controle;
    //constante
    //public static final String SERVEURADDR = "http://192.168.0.14/easyGarden/login.php";
    public static final String SERVEURADDR = "http://172.16.1.134/easyGarden/login.php";//ecole

    /**
     * constructeur
     */
    public AccesDistant(){
        controle = Manager.getInstance(null);
    }

    /**
     * retour du serveur distant
     * @param output
     */
    @Override
    public void processFinish(String output) {
        Log.d("serveur","****************"+output);
       //découpage du message reçu avec %
        String[] message = output.split("%");
        //dans message[0] = "enreg","login","erreur !"
        //dans message[1] = reste du message

        //si il y a 2 cases
        if(message.length >1){
            if(message[0].equals("enreg")){
                Log.d("enreg","**************"+message[1]);
            }else{
                if(message[0].equals("login")) {
                    Log.d("login","**************"+message[1]);
                    try {
                        JSONObject identifiant = new JSONObject(message[1]);
                        String nom = identifiant.getString("nom");
                        String prenom = identifiant.getString("prenom");
                        Integer age = identifiant.getInt("age");
                        String pseudo = identifiant.getString("pseudo");
                        String password = identifiant.getString("password");
                        String email = identifiant.getString("email");
                        Profil profil = new Profil(nom,prenom,age,pseudo,password,email);
                        controle.setProfil(profil);
                    } catch (JSONException e) {
                        Log.d("erreur","Recup profil conversion JSON impossible"+e.toString());
                        e.printStackTrace();
                    }
                }else{
                    if(message[0].equals("erreur!")){
                        Log.d("erreur!","**************"+message[1]);
                    }
                }
            }
        }

    }

    public void envoi(String operation, JSONArray lesDonneesJSON){
        AccesHTTP accesDonnees = new AccesHTTP();
        //lien de délégation
        accesDonnees.delegate = this;
        //ajout paramètres
        accesDonnees.addParam("operation",operation);
        accesDonnees.addParam("lesdonnees",lesDonneesJSON.toString());
        accesDonnees.execute(SERVEURADDR);
    }
}
