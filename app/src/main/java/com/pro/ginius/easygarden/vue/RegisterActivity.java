package com.pro.ginius.easygarden.vue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pro.ginius.easygarden.R;
import com.pro.ginius.easygarden.controleur.Manager;

import java.util.regex.Pattern;

public class RegisterActivity extends Activity {

    //déclaration des variables
    Button btnRegister, btnLinkToLogin;
    EditText nomEt, prenomEt, ageEt, pseudoEt, passwordEt, emailEt;
    String nom,prenom,pseudo,password,email;
    Integer age;
    Manager manager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //défini le nom de l'activité
        setTitle("Nouveau compte");
        //initialise les objets graphique
        init();

        manager = manager.getInstance(this);

    }

    /**
     * fonction d'initialisation des objets graphique
     */
    public void init() {

        nomEt = (EditText) findViewById(R.id.EtRegisterNom);
        prenomEt = (EditText) findViewById(R.id.EtRegisterPrenom);
        ageEt = (EditText) findViewById(R.id.EtRegisterAge);
        pseudoEt = (EditText) findViewById(R.id.EtRegisterLogin);
        passwordEt = (EditText) findViewById(R.id.EtRegisterPassword);
        emailEt = (EditText) findViewById(R.id.EtRegisterMail);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLinkToLogin = (Button) findViewById(R.id.btnLinkToLoginScreen);
        ecouteRegister();
        alreadyLogin();
    }


    /**
     * gestion du bouton enregistrement
     */
    public void ecouteRegister(){
        ((Button)findViewById(R.id.btnRegister)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
            // Récupération du contenu des EditText
                nom= nomEt.getText().toString();
                prenom = prenomEt.getText().toString();
                age = Integer.parseInt(ageEt.getText().toString());
                pseudo = pseudoEt.getText().toString();
                password = passwordEt.getText().toString();
                email = emailEt.getText().toString();

                Toast.makeText(RegisterActivity.this, "test d'enregistrement", Toast.LENGTH_SHORT).show();
                manager.creerUtilisatreur(nom,prenom,age,pseudo,password,email);

               // Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
               // startActivity(intent);
               // finish();

            }
        });
    }

    /**
     * gestion du bouton enregistré
     */
    public void alreadyLogin(){
        ((Button)findViewById(R.id.btnLinkToLoginScreen)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}