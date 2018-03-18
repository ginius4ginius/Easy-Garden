package com.pro.ginius.easygarden.model;

import android.util.Log;

import com.pro.ginius.easygarden.outils.AccesHTTP;
import com.pro.ginius.easygarden.outils.AsyncResponse;

import org.json.JSONArray;

/**
 * Created by fcd on 08/03/2018.
 */

public class AccesDistant implements AsyncResponse{

    //constante
    public static final String SERVEURADDR = "http://192.168.0.14/easyGarden/login.php";

    /**
     * constructeur
     */
    public AccesDistant(){
        super();
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
