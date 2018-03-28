package com.pro.ginius.easygarden.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pro.ginius.easygarden.R;
import com.pro.ginius.easygarden.controleur.Manager;
import com.pro.ginius.easygarden.model.Profil;

public class ProfilActivity extends AppCompatActivity {

    //déclaration des variables
    EditText UserNomEt,UserPrenomEt,UserAgeEt,UserPseudoEt,UserPasswordEt;
    private String nom, prenom,pseudo,password,email;
    private Integer age;
    private Manager controle;
    private Profil profil = controle.getProfil();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        controle = Manager.getInstance(this);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        MenuItem mProfil = menu.findItem(R.id.menu_profil);
        MenuItem mLogin = menu.findItem(R.id.menu_login);
        MenuItem mLogout = menu.findItem(R.id.menu_deconnect);
        if(controle.getProfil()==null){
            mProfil.setVisible(false);
            mLogout.setVisible(false);
        }else{
            mLogin.setVisible(false);
        }


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_exposition:

                Toast.makeText(this, "liste par exposition selectionnée", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ProfilActivity.this, SunnyActivity.class);
                startActivity(intent);
                finish();
                return true;

            case R.id.menu_profil: // si le profil utilisateur est existant donc il a acces au menu profil

                Toast.makeText(this, "menu profil selectionné", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(ProfilActivity.this, ProfilActivity.class);
                startActivity(intent5);
                finish();
                return true;

            case R.id.menu_login:

                Toast.makeText(this, "page de connexion selectionnée", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(ProfilActivity.this, LoginActivity.class);
                startActivity(intent6);
                finish();
                return true;

            case R.id.menu_type:

                Toast.makeText(this, "Liste par type selectionnée", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(ProfilActivity.this, TypeActivity.class);
                startActivity(intent2);
                finish();
                return true;

            case R.id.menu_accueil:

                Toast.makeText(this, "Accueil selectionné", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(ProfilActivity.this, MainActivity.class);
                startActivity(intent3);
                finish();
                return true;

            case R.id.menu_deconnect:
                controle.setProfil(null);
                Intent intent4 = new Intent(ProfilActivity.this, MainActivity.class);
                startActivity(intent4);
                finish();
                return true;

            case R.id.menu_favori:

                Toast.makeText(this, "page de favori selectionnée", Toast.LENGTH_SHORT).show();
                Intent intent7 = new Intent(ProfilActivity.this, FavoriActivity.class);
                startActivity(intent7);
                finish();
                return true;

            case R.id.menu_contact:

                Toast.makeText(this, "Contact selectionné", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * fonction d'initialisation des objets graphique
     */
    public void init(){
        UserNomEt = (EditText)findViewById(R.id.etNomProfil);
        UserPrenomEt = (EditText)findViewById(R.id.etPrenomProfil);
        UserAgeEt = (EditText)findViewById(R.id.etAgeProfil);
        UserPseudoEt = (EditText)findViewById(R.id.etPseudoProfil);
        UserPasswordEt = (EditText)findViewById(R.id.etPasswordProfil);

        initialisationProfil();//initialisation des champs



        ecouteUpdate();
    }

    /**
     * gestion du bouton serveur
     */
    public void ecouteUpdate(){
        ((Button) findViewById(R.id.btnUpdateProfil)).setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                nom = UserNomEt.getText().toString();
                prenom = UserPrenomEt.getText().toString();
                pseudo = UserPseudoEt.getText().toString();
                password = UserPasswordEt.getText().toString();
                age = Integer.parseInt(UserAgeEt.getText().toString());
                email = profil.getEmail();
                //
                controle.updateProfil(nom,prenom,age,pseudo,password,email);

                initialisationProfil();//initialisation des champs
            }
        });
    }

    public void initialisationProfil(){
        //initialisation des champs
        UserNomEt.setText(profil.getNom());
        UserPrenomEt.setText(profil.getPrenom());
        UserAgeEt.setText(profil.getAge());
        UserPseudoEt.setText(profil.getPseudo());
        UserPasswordEt.setText(profil.getPassword());
    }
}
