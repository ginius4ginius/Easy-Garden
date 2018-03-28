package com.pro.ginius.easygarden.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.pro.ginius.easygarden.R;
import com.pro.ginius.easygarden.controleur.Manager;

public class MainActivity extends AppCompatActivity {

    //déclaration des variables
    Manager controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controle = Manager.getInstance(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        MenuItem mProfil = menu.findItem(R.id.menu_profil);
        MenuItem mLogin = menu.findItem(R.id.menu_login);
        MenuItem mLogout = menu.findItem(R.id.menu_deconnect);
        MenuItem mFavori = menu.findItem(R.id.menu_favori);
        if(controle.getProfil()==null){
            mProfil.setVisible(false);
            mFavori.setVisible(false);
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
                    Intent intent = new Intent(MainActivity.this, SunnyActivity.class);
                    startActivity(intent);
                    finish();
                    return true;

                case R.id.menu_profil: // si le profil utilisateur est existant donc il a acces au menu profil

                    Toast.makeText(this, "menu profil selectionné", Toast.LENGTH_SHORT).show();
                    Intent intent5 = new Intent(MainActivity.this, ProfilActivity.class);
                    startActivity(intent5);
                    finish();
                    return true;

                case R.id.menu_login:

                    Toast.makeText(this, "page de connexion selectionnée", Toast.LENGTH_SHORT).show();
                    Intent intent6 = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent6);
                    finish();
                    return true;

                case R.id.menu_favori:

                    Toast.makeText(this, "page de favori selectionnée", Toast.LENGTH_SHORT).show();
                    Intent intent7 = new Intent(MainActivity.this, FavoriActivity.class);
                    startActivity(intent7);
                    finish();
                    return true;

                case R.id.menu_type:

                    Toast.makeText(this, "Liste par type selectionnée", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(MainActivity.this, TypeActivity.class);
                    startActivity(intent2);
                    finish();
                    return true;

                case R.id.menu_accueil:

                    Toast.makeText(this, "Accueil selectionné", Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent3);
                    finish();
                    return true;

                case R.id.menu_deconnect:
                    controle.setProfil(null);
                    Intent intent4 = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent4);
                    finish();
                    return true;

                case R.id.menu_contact:

                    Toast.makeText(this, "Contact selectionné", Toast.LENGTH_SHORT).show();
                    return true;

                default:
                    return super.onOptionsItemSelected(item);

        }
    }
}
