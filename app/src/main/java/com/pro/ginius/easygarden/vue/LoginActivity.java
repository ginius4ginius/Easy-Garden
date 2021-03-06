package com.pro.ginius.easygarden.vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pro.ginius.easygarden.R;
import com.pro.ginius.easygarden.controleur.Manager;
import com.pro.ginius.easygarden.model.Profil;

public class LoginActivity extends AppCompatActivity {

    //déclaration des variables
    EditText UserNameEt,PasswordEt;
    Profil profil;
    String username,password;
    Manager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //défini le nom de l'activité
        setTitle("Authentification");
        //initialise les objets graphique
        init();

        manager = Manager.getInstance(this);
    }

    /**
     * fonction d'initialisation des objets graphique
     */
    public void init(){
        UserNameEt = (EditText)findViewById(R.id.etUserName);
        PasswordEt = (EditText)findViewById(R.id.etPassword);
        //gestion de l'évènement sur le bouton serveur
        ecouteLogin();
        saveLogin();


    }

    /**
     * gestion du bouton serveur
     */
    public void ecouteLogin(){
        ((Button) findViewById(R.id.btnLogin)).setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Toast.makeText(LoginActivity.this, "test", Toast.LENGTH_SHORT).show();
                username = UserNameEt.getText().toString();
                password = PasswordEt.getText().toString();
                //
                manager.controleUtilisateur(username,password);

                //vérification si Profil récupéré et envois au main si true
                if(manager.getProfil() != null){
                    Log.d("profil ","initialisé");
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Log.d("profil "," non initialisé");
                }
            }
        });
    }


    /**
     * gestion du bouton enregistrement
     */
    public void saveLogin(){
        ((Button)findViewById(R.id.btnEnregistrement)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                Toast.makeText(LoginActivity.this,"Enregistrement terminé",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }




}
