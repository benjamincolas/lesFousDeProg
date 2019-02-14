package com.app.lesfousdeprog.motstordus;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurBdd {

    private static final String TABLE_NAME = "utilisateur";
    public static final String IDUSER="idUser";
    public static final String NOMUTIL="pseudo";
    public static final String SCOREQUIZCOMICS="scoreQuizComics";
    public static final String SCOREQUIZMANGA="scoreQuizManga";
    public static final String SCOREMEMO="scoreMemo";
    public static final String SCOREQUIZBD="scoreQuizBd";
    public static final String SCORERANGE="scoreRange";


    public static int lastIdUser;
    private Utilisateur user;
    public static final String CREATE_TABLE_UTIL = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+
            " (" +
            " "+IDUSER+" INTEGER primary key AUTOINCREMENT," +
            " "+NOMUTIL+" TEXT," +
            " "+SCOREMEMO+" INTEGER," +
            " "+SCOREQUIZBD+" INTEGER," +
            " "+SCOREQUIZCOMICS+" INTEGER," +
            " "+SCOREQUIZMANGA+" INTEGER," +
            " "+SCORERANGE+" INTEGER" +
            ");";
    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    public UtilisateurBdd(Context context)
    {
        maBaseSQLite = MySQLite.getInstance(context);
        db=maBaseSQLite.getReadableDatabase();

    }

    public void open()
    {
        //on ouvre la table en lecture/écriture
        db = maBaseSQLite.getWritableDatabase();
    }

    public void close()
    {
        //on ferme l'accès à la BDD
        db.close();
    }

    public int lastId(){

        open();
        Cursor cursor = db.rawQuery("SELECT MAX(idUser) FROM "+TABLE_NAME, null);
        if(cursor.moveToLast()){

            lastIdUser = cursor.getInt(0)+1;//to get id, 0 is the column index
        }


        return lastIdUser;}

    public long addUser(Utilisateur utilisateur) {
        // Ajout d'un enregistrement dans la table
    open();
   // int id =
        ContentValues values = new ContentValues();
        values.put(IDUSER, utilisateur.getIdUser());
        values.put(NOMUTIL, utilisateur.getPseudo());
        values.put(SCOREMEMO, utilisateur.getScoreMemo());
        values.put(SCOREQUIZBD, utilisateur.getScorequizbd());
        values.put(SCOREQUIZCOMICS, utilisateur.getScorequizcomics());
        values.put(SCOREQUIZMANGA, utilisateur.getScorequizmanga());
        values.put(SCORERANGE, utilisateur.getScoreRange());
        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        //lastIdUser = ;
      return db.insert(TABLE_NAME,null,values) ;
    }

    public int updateUser(Utilisateur utilisateur) {
        // Ajout d'un enregistrement dans la table
        open();
        ContentValues values = new ContentValues();
        values.put(SCOREQUIZCOMICS, utilisateur.getScorequizcomics());
        values.put(NOMUTIL, utilisateur.getPseudo());
        values.put(SCOREMEMO, utilisateur.getScoreMemo());
        values.put(SCORERANGE, utilisateur.getScoreRange());
        values.put(SCOREQUIZMANGA, utilisateur.getScorequizmanga());
        values.put(SCOREQUIZBD, utilisateur.getScorequizbd());
       // values.put(IDUSER, utilisateur.getIdUser());
        String[] arg = {String.valueOf(utilisateur.getIdUser())};
        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.update(TABLE_NAME,values,"idUser = ?",arg);
    }

    public List<Utilisateur> getUtilScoreBD() //Instancie et ajoute les 10 meilleurs utilisateur en fonction de leur score au quiz dans une liste
    {
        List<Utilisateur> list = new ArrayList<Utilisateur>();

        Cursor cursor = null;
        try {
            db=maBaseSQLite.getWritableDatabase();
            cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY "+SCOREQUIZBD + " DESC LIMIT 10",null);
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false)
            {
                user = new Utilisateur(cursor.getInt(4),cursor.getString(1),cursor.getInt(2),cursor.getInt(6),cursor.getInt(5),cursor.getInt(3));
                list.add(user);
                cursor.moveToNext();
            }

        } finally {
            if (cursor != null) cursor.close();
        }
return list;
    }
    public List<Utilisateur> getUtilScoreRTBD()//Instancie et ajoute les 10 meilleurs utilisateur en fonction de leur score au jeu Range Ta BD dans une liste
    {
        List<Utilisateur> list = new ArrayList<Utilisateur>();

        Cursor cursor = null;
        try {
            db=maBaseSQLite.getWritableDatabase();
            cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY "+SCORERANGE + "  LIMIT 10",null);
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false)
            {
                user = new Utilisateur(cursor.getInt(4),cursor.getString(1),cursor.getInt(2),cursor.getInt(6),cursor.getInt(5),cursor.getInt(3));
                list.add(user);
                cursor.moveToNext();
            }

        } finally {
            if (cursor != null) cursor.close();
        }
        return list;
    }
    public List<Utilisateur> getUtilScoreMemo()//Instancie et ajoute les 10 meilleurs utilisateur en fonction de leur score au mémo rigolo dans une liste
    {
        List<Utilisateur> list = new ArrayList<Utilisateur>();

        Cursor cursor = null;
        try {
            db=maBaseSQLite.getWritableDatabase();
            cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY "+SCOREMEMO + "  LIMIT 10",null);
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false)
            {
                user = new Utilisateur(cursor.getInt(4),cursor.getString(1),cursor.getInt(2),cursor.getInt(6),cursor.getInt(5),cursor.getInt(3));
                list.add(user);
                cursor.moveToNext();
            }

        } finally {
            if (cursor != null) cursor.close();
        }
        return list;
    }
    private Utilisateur cursorToClient(Cursor cursor) {
         user = new Utilisateur(cursor.getInt(3),cursor.getString(1),cursor.getInt(6),cursor.getInt(5),cursor.getInt(2),cursor.getInt(0),cursor.getInt(4));

        return user;
    }







}
