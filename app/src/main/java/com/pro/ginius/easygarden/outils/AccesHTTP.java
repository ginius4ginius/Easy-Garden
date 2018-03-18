package com.pro.ginius.easygarden.outils;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Derieu on 17/03/2018.
 */

public class AccesHTTP extends AsyncTask<String,Integer,Long> {

    //déclaration des variables
    private ArrayList<NameValuePair> parametres;
    private String retour = null;
    public AsyncResponse delegate = null;


    /**
     * constructeur
     */
    public AccesHTTP (){
        parametres = new ArrayList<NameValuePair>();
    }

    /**
     * ajout d'un paramètre POST
     * @param nom
     * @param valeur
     */
    public void addParam(String nom, String valeur){
        parametres.add(new BasicNameValuePair(nom,valeur));
    }

    /**
     * connexion en tache de fond dans un thread séparé.
     * @param strings
     * @return
     */
    @Override
    protected Long doInBackground(String... strings) {
        HttpClient cnxHttp = new DefaultHttpClient();
        HttpPost paramCnx = new HttpPost(strings[0]);

        try {
            //encodage des paramètres
            paramCnx.setEntity(new UrlEncodedFormEntity(parametres));

            //connexion et envoi des paramètres, attente de réponse
            HttpResponse reponse = cnxHttp.execute(paramCnx);

            //transformation de la réponse
            retour = EntityUtils.toString(reponse.getEntity());

        } catch (UnsupportedEncodingException e) {
            Log.d( "erreur encodage","******** "+e.toString());
        } catch (ClientProtocolException e) {
            Log.d( "erreur protocole","******** "+e.toString());
        } catch (IOException e) {
            Log.d( "erreur I/O","******** "+e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Long result){
        delegate.processFinish(retour.toString());
    }


}
