package com.pro.ginius.easygarden.model;

import android.util.Log;

import com.pro.ginius.easygarden.controleur.Manager;
import com.pro.ginius.easygarden.outils.AccesHTTP;
import com.pro.ginius.easygarden.outils.AsyncResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by fcd on 08/03/2018.
 */

public class AccesDistant implements AsyncResponse{

    //variables
    Manager controle;
    //constante
    public static final String SERVEURADDR = "http://192.168.0.14/easyGarden/serveur.php";
    //public static final String SERVEURADDR = "http://172.16.1.134/easyGarden/login.php";//ecole

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
        Log.d("serveur", "****************" + output);
        //découpage du message reçu avec %
        String[] message = output.split("%");
        //dans message[0] = "enreg","serveur","erreur !"
        //dans message[1] = reste du message

        //si il y a 2 cases
        if (message.length > 1) {
            if (message[0].equals("enreg")) {
                Log.d("enreg", "**************" + message[1]);
            } else {
                if (message[0].equals("serveur")) {
                    Log.d("serveur", "**************" + message[1]);
                    try {
                        JSONObject identifiant = new JSONObject(message[1]);
                        String nom = identifiant.getString("nom");
                        String prenom = identifiant.getString("prenom");
                        Integer age = identifiant.getInt("age");
                        String pseudo = identifiant.getString("pseudo");
                        String password = identifiant.getString("password");
                        String email = identifiant.getString("email");
                        Profil profil = new Profil(nom, prenom, age, pseudo, password, email);
                        controle.setProfil(profil);
                    } catch (JSONException e) {
                        Log.d("erreur", "Recup profil conversion JSON impossible" + e.toString());
                        e.printStackTrace();
                    }
                } else {
                    if (message[0].equals("showPlanteVivace")) {
                        Log.d("showPlanteVivace", "**************" + message[1]);
                        try {
                            JSONArray liste = new JSONArray(message[1]);
                            ArrayList<Plante> l = new ArrayList<Plante>();
                            for (int k = 0; k < liste.length(); k++) {
                                JSONObject ligne = new JSONObject(liste.get(k).toString());
                                String nom = ligne.getString("nom");
                                String nomScientifique = ligne.getString("nom_scientifique");
                                String descriptif = ligne.getString("descriptif");
                                String type = ligne.getString("type");
                                String exposition = ligne.getString("exposition");
                                String image = ligne.getString("image");

                                Plante plante = new Plante(nom, nomScientifique, descriptif, exposition, type, image);
                                l.add(plante);
                            }
                            controle.setListePlantes(l);
                        } catch (JSONException e) {
                            Log.d("erreur", "Recup liste Plante Vivaces conversion JSON impossible" + e.toString());
                            e.printStackTrace();
                        }
                    } else {
                        if (message[0].equals("showPlanteAnnuelle")) {
                            Log.d("showPlanteAnnuelle", "**************" + message[1]);
                            try {
                                JSONArray liste = new JSONArray(message[1]);
                                ArrayList<Plante> l = new ArrayList<Plante>();
                                for (int k = 0; k < liste.length(); k++) {
                                    JSONObject ligne = new JSONObject(liste.get(k).toString());
                                    String nom = ligne.getString("nom");
                                    String nomScientifique = ligne.getString("nom_scientifique");
                                    String descriptif = ligne.getString("descriptif");
                                    String type = ligne.getString("type");
                                    String exposition = ligne.getString("exposition");
                                    String image = ligne.getString("image");

                                    Plante plante = new Plante(nom, nomScientifique, descriptif, exposition, type, image);
                                    l.add(plante);
                                }
                                controle.setListePlantes(l);
                            } catch (JSONException e) {
                                Log.d("erreur", "Recup liste Plante Annuelles conversion JSON impossible" + e.toString());
                                e.printStackTrace();
                            }
                        }
                        if (message[0].equals("erreur!")) {
                            Log.d("erreur!", "**************" + message[1]);
                        }
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
