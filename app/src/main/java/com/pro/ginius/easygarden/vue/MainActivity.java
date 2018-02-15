package com.pro.ginius.easygarden.vue;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.pro.ginius.easygarden.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                Toast.makeText(this,"menu_par_ensoleillement selectionné",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,SunnyActivity.class);
                startActivity(intent);
                return true;

            case R.id.menu_type:

                Toast.makeText(this,"menu_par_type selectionné",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(MainActivity.this,TypeActivity.class);
                startActivity(intent2);
                return true;

            case R.id.menu_acceuil:

                Toast.makeText(this,"menu_acceuil selectionné",Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent3);
                return true;

            case R.id.menu_contact:

                Toast.makeText(this,"menu_contact selectionné",Toast.LENGTH_SHORT).show();
                return true;

            default : return super.onOptionsItemSelected(item);
        }


    }
}
