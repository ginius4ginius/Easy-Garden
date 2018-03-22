package com.pro.ginius.easygarden.vue;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.pro.ginius.easygarden.model.Plante;

import java.util.ArrayList;

/**
 * Created by fcd on 22/03/2018.
 */

public class ListePlanteAdapter extends BaseAdapter {

    //déclaration des variables
    private ArrayList<Plante> lesPlantes;


    /**
     * constructeur initialisant la liste des plantes
     */
    public ListePlanteAdapter(ArrayList<Plante> lesPlantes){
        this.lesPlantes = lesPlantes;
    }

    /**
     * retourne le nombre de lignes
     * @return
     */
    @Override
    public int getCount() {
        return lesPlantes.size();
    }

    /**
     * retourne l'item de la ligne actuelle
     * @param position
     * @return
     */
    @Override
    public Object getItem(int i) {
        return lesPlantes.get(i);
    }

    /**
     * retourne un indice par rapport à la ligne actuelle
     * @param i
     * @return
     */
    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * retourne la ligne (view) formatée avec les éléments et la gestion des évènements
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

}
