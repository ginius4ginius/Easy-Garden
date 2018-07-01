package com.pro.ginius.easygarden.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.pro.ginius.easygarden.R;
import com.pro.ginius.easygarden.controleur.Manager;

import java.util.ArrayList;

/**
 * Created by fcd on 29/03/2018.
 */

public class ListeFavoriAdapter extends BaseAdapter {

    //déclaration des variables
    private ArrayList<Plante> lesFavori;
    private LayoutInflater inflater;
    Manager controle;
    Context c;


    /**
     * constructeur initialisant la liste des plantes
     */
    public ListeFavoriAdapter(Context cont, ArrayList<Plante> lesPlantes){

        this.c = cont;
        this.lesFavori = lesPlantes;
        this.inflater = LayoutInflater.from(c);
        this.controle = Manager.getInstance(null);
    }

    /**
     * retourne le nombre de lignes
     * @return
     */
    @Override
    public int getCount() {
        return lesFavori.size();
    }

    /**
     * retourne l'item de la ligne actuelle
     * @param i
     * @return
     */
    @Override
    public Object getItem(int i) {
        return lesFavori.get(i);
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
        ListeFavoriAdapter.ViewHolder holder;
        //si la ligne n'exsite pas encore
        if(view == null){
            holder = new ListeFavoriAdapter.ViewHolder();
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
            holder = (ListeFavoriAdapter.ViewHolder) view.getTag();
        }
        //valorisation du contenu du holder
        holder.tvNom.setText(lesFavori.get(i).getNom().toString());
        holder.tvNomScientifique.setText(lesFavori.get(i).getNomScientifique().toString());
        holder.tvDescriptif.setText(lesFavori.get(i).getDescriptif().toString());
        holder.tvType.setText(lesFavori.get(i).getType().toString());
        holder.tvExposition.setText(lesFavori.get(i).getExposition().toString());
        holder.btnAddFavori.setTag(i);
        //click sur le bouton pour supprimer la plante du favori
        holder.btnAddFavori.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = (int)v.getTag();
                controle.RecupPlanteByFavori(lesFavori.get(position));
                //rafraichissement de la liste
                notifyDataSetChanged();
            }
        });
        PicassoPlante.downloadImage(c,lesFavori.get(i).getImage(),holder.imagePlante);

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
