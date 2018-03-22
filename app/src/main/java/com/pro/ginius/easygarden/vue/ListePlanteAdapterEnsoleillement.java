package com.pro.ginius.easygarden.vue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.pro.ginius.easygarden.R;
import com.pro.ginius.easygarden.model.Plante;

import java.util.ArrayList;

/**
 * Created by fcd on 22/03/2018.
 */

public class ListePlanteAdapterEnsoleillement extends BaseAdapter {

    //déclaration des variables
    private ArrayList<Plante> lesPlantes;
    private LayoutInflater inflater;
    private Integer[] tab_images_pour_la_liste = {
            R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin,
            R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin,
            R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin, R.drawable.jardin,
    };


    /**
     * constructeur initialisant la liste des plantes
     */
    public ListePlanteAdapterEnsoleillement(Context c, ArrayList<Plante> lesPlantes){

        this.lesPlantes = lesPlantes;
        this.inflater = LayoutInflater.from(c);
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
     * @param i
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
     * @param i
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //déclaration d'un ViewBolder
        ViewHolder holder;
        //si la ligne n'exsite pas encore
        if(view == null){
            holder = new ViewHolder();
            //la ligne est construite avec un formatage (inflater) relié au layout ListePLanteAdapter
            view = inflater.inflate(R.layout.layout_liste_plante,null);
            //chaque propriétés du holder doivent etre reliées avec les propriété graphiques
            holder.tvNom = (TextView)view.findViewById(R.id.tvNom);
            holder.tvNomScientifique = (TextView)view.findViewById(R.id.tvNomScientifique);
            holder.tvDescriptif = (TextView)view.findViewById(R.id.tvDescription);
            holder.tvType = (TextView)view.findViewById(R.id.tvType);
            holder.tvExposition = (TextView)view.findViewById(R.id.tvExposition);
            holder.imagePlante = (ImageView) view.findViewById(R.id.imagePlante);
            holder.btnAddFavori = (ImageButton)view.findViewById(R.id.btnAddFavori);
            //affecter le holder à la vue
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        //valorisation du contenu du holder
        holder.tvNom.setText(lesPlantes.get(i).getNom().toString());
        holder.tvNomScientifique.setText(lesPlantes.get(i).getNomScientifique().toString());
        holder.tvDescriptif.setText(lesPlantes.get(i).getDescriptif().toString());
        holder.tvType.setText(lesPlantes.get(i).getType().toString());
        holder.tvExposition.setText(lesPlantes.get(i).getExposition().toString());
        holder.btnAddFavori.setTag(i);
        holder.imagePlante.setImageResource(tab_images_pour_la_liste[i]);


        return view;
    }

    private class ViewHolder{
        // 7 parties
        ImageButton btnAddFavori;
        ImageView imagePlante;
        TextView tvNom;
        TextView tvNomScientifique;
        TextView tvType;
        TextView tvExposition;
        TextView tvDescriptif;
    }

}
