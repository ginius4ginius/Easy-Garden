package com.pro.ginius.easygarden.vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pro.ginius.easygarden.R;
import com.pro.ginius.easygarden.controleur.Manager;

public class TypeActivity extends AppCompatActivity {

    //déclaration des variables
    Manager controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
        controle = Manager.getInstance(this);
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

        switch (item.getItemId()){

            case R.id.menu_ensoleillement:

                Toast.makeText(this,"menu_par_ensoleillement selectionné",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TypeActivity.this,SunnyActivity.class);
                startActivity(intent);
                finish();
                return true;

            case R.id.menu_type:

                Toast.makeText(this,"menu_par_type selectionné",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(TypeActivity.this,TypeActivity.class);
                startActivity(intent2);
                finish();
                return true;

            case R.id.menu_acceuil:

                Toast.makeText(this,"menu_acceuil selectionné",Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(TypeActivity.this,MainActivity.class);
                startActivity(intent3);
                finish();
                return true;

            case R.id.menu_deconnect:
                controle.setProfil(null);
                Toast.makeText(this,"menu_deconnect selectionné",Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(TypeActivity.this,LoginActivity.class);
                startActivity(intent4);
                finish();
                return true;

            case R.id.menu_contact:

                Toast.makeText(this,"menu_contact selectionné",Toast.LENGTH_SHORT).show();
                return true;

            default : return super.onOptionsItemSelected(item);
        }


    }

    public void init(){
        //gestion de l'évènement sur le bouton vivace
        ecouteVivace();
        //gestion de l'évènement sur le bouton vivace
        ecouteAnnuelle();
    }

    /**
     * gestion du bouton vivace
     */
    public void ecouteVivace(){
        ((Button) findViewById(R.id.btVivace)).setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                //
                controle.RecupPlanteByVicace();

            }
        });
    }

    /**
     * gestion du bouton annuelle
     */
    public void ecouteAnnuelle(){
        ((Button) findViewById(R.id.btVivace)).setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                //
                controle.RecupPlanteByAnnuelle();

            }
        });
    }


}
