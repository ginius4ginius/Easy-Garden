package com.pro.ginius.easygarden.vue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pro.ginius.easygarden.R;
import com.pro.ginius.easygarden.controleur.Manager;
import com.pro.ginius.easygarden.controleur.ManagerLogin;

public class LoginActivity extends AppCompatActivity {

    //déclaration des variables
    EditText UserNameEt,PasswordEt;
    String username,password;
    Manager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        manager = manager.getInstance(this);
    }

    /**
     * fonction d'initialisation des objets graphique
     */
    public void init(){
        UserNameEt = (EditText)findViewById(R.id.etUserName);
        PasswordEt = (EditText)findViewById(R.id.etPassword);
        //gestion de l'évènement sur le bouton login
        ecouteLogin();
    }

    /**
     * gestin du bouton login
     */
    public void ecouteLogin(){
        ((Button) findViewById(R.id.btnLogin)).setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "test", Toast.LENGTH_SHORT).show();
                username = UserNameEt.getText().toString();
                password = PasswordEt.getText().toString();
                //
                manager.controleUtilisateur(username,password);
            }
        });
    }


}
