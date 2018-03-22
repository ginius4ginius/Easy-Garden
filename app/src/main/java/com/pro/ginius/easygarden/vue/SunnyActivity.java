package com.pro.ginius.easygarden.vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.pro.ginius.easygarden.R;
import com.pro.ginius.easygarden.controleur.Manager;
import com.pro.ginius.easygarden.model.Plante;

import java.util.ArrayList;

public class SunnyActivity extends AppCompatActivity {

    //déclaration des variables
    private Manager c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunny);
        c = Manager.getInstance(null);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_ensoleillement:

                Toast.makeText(this, "menu_par_ensoleillement selectionné", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SunnyActivity.this, SunnyActivity.class);
                startActivity(intent);
                finish();
                return true;

            case R.id.menu_type:

                Toast.makeText(this, "menu_par_type selectionné", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(SunnyActivity.this, TypeActivity.class);
                startActivity(intent2);
                finish();
                return true;

            case R.id.menu_acceuil:

                Toast.makeText(this, "menu_acceuil selectionné", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(SunnyActivity.this, MainActivity.class);
                startActivity(intent3);
                finish();
                return true;

            case R.id.menu_deconnect:
                c.setProfil(null);
                Toast.makeText(this, "menu_deconnect selectionné", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(SunnyActivity.this, LoginActivity.class);
                startActivity(intent4);
                finish();
                return true;

            case R.id.menu_contact:

                Toast.makeText(this, "menu_contact selectionné", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

        public void init(){
            //gestion de l'évènement sur le bouton ombre
            ecouteOmbre();
            //gestion de l'évènement sur le bouton mi ombre
            ecouteMiOmbre();
            //gestion de l'évènement sur le bouton soleil
            ecouteSoleil();
        }

    /**
     * gestion du bouton ombre
     */
    public void ecouteOmbre(){
        ((Button) findViewById(R.id.btOmbre)).setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                //

                c.RecupPlanteByOmbre();
                creerListe();

            }
        });
    }

    /**
     * gestion du bouton mi ombre
     */
    public void ecouteMiOmbre(){
        ((Button) findViewById(R.id.btMiombre)).setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                //

                c.RecupPlanteByMiOmbre();
                creerListe();

            }
        });
    }

    /**
     * gestion du bouton soleil
     */
    public void ecouteSoleil(){
        ((Button) findViewById(R.id.btEnsoleillement)).setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                //

                c.RecupPlanteBySoleil();
                creerListe();

            }
        });
    }

    /**
     * permet de créer la listeAdapter
     */
    private void creerListe(){
        ArrayList<Plante> lesPlantes2 = c.getListePlantes2();
        if(lesPlantes2 != null){
            ListView listePlantesb = (ListView)findViewById(R.id.listePlantes);
            ListePlanteAdapterEnsoleillement adapter = new ListePlanteAdapterEnsoleillement(this,lesPlantes2);
            listePlantesb.setAdapter(adapter);
        }
    }

}

