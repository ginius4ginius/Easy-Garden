package com.pro.ginius.easygarden.outils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fcd on 15/03/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // version de la base de donnée
    private static final int VERSION = 1;

    // nom de la base de donnée
    private static final String DATABASE_NAME = "bd_plante";
    // nom de la table login
    private static final String TABLE_LOGIN = "login";

    // nom des colonnes de la table login
    private static final String ID = "id";
    private static final String NOM = "nom";
    private static final String EMAIL = "email";
    private static final String UID = "uid";
    private static final String  DATE_CREATE = "created_at";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    //creation des tables
    @Override
    public void onCreate(SQLiteDatabase db) {
    String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_LOGIN + "("
            + ID + "INTERGER PRIMARY_KEY,"
            + NOM + " TEXT,"
            + EMAIL + " TEXT UNIQUE,"
            + UID + " TEXT,"
            + DATE_CREATE + " TEXT" + ")";

        db.execSQL(CREATE_LOGIN_TABLE);

    }

    // msie a jour de la base de donnée
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //suppresion de la table
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_LOGIN);

        //creation de la table
        onCreate(db);
    }

    //inserer un utilisateur
    public void addUser(String nom, String email, String uid, String created_at){
    SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valeurs = new ContentValues();
        valeurs.put(NOM, nom);
        valeurs.put(EMAIL, email);
        valeurs.put(UID, uid);
        valeurs.put(DATE_CREATE, created_at);

        //insertion des lignes
        db.insert(TABLE_LOGIN, null, valeurs);
        db.close();
    }

    //récupération des utilisateurs
    public int getRowCount(){
        String countQuery = "SELECT  * FROM " + TABLE_LOGIN;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(countQuery, null);
        int nombreLigne = c.getCount();
        db.close();
        c.close();

        // return row count
        return nombreLigne;
    }

    //supression des tables
    public void resetTables(){
        SQLiteDatabase db = this.getWritableDatabase();
        // supression de toutes les lignes
        db.delete(TABLE_LOGIN, null, null);
        db.close();
    }


}
