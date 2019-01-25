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
    public static final String SCORE="score";
    public static final String SCOREMEMO="scoreMemo";
    public static final String SCOREQUIZ="scoreQuiz";
    public static final String SCORERANGE="scoreRange";
    private Utilisateur user;
    public static final String CREATE_TABLE_ANIMAL = "CREATE TABLE "+TABLE_NAME+
            " (" +
            " "+IDUSER+" INTEGER primary key," +
            " "+NOMUTIL+" TEXT" +
            ");";
    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    public UtilisateurBdd(Context context)
    {
        maBaseSQLite = MySQLite.getInstance(context);
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

    public long addUser(Utilisateur utilisateur) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(NOMUTIL, utilisateur.getPseudo());

        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_NAME,null,values);
    }
    public Cursor getAnimaux() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }
    public ArrayList<Utilisateur> getAllClients() {
        ArrayList<Utilisateur> ref = new ArrayList<Utilisateur>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
          cursorToClient(cursor);
            ref.add(user);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return ref;
    }
    private Utilisateur cursorToClient(Cursor cursor) {
         user = new Utilisateur(cursor.getInt(3),cursor.getString(1),cursor.getInt(6),cursor.getInt(5),cursor.getInt(2),cursor.getInt(0),cursor.getInt(4));

        return user;
    }

    public int modAnimal(Utilisateur utilisateur) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(NOMUTIL, utilisateur.getPseudo());

        String where = IDUSER+" = ?";
        String[] whereArgs = {utilisateur.getIdUser()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int supAnimal(Utilisateur user) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = IDUSER+" = ?";
        String[] whereArgs = {user.getIdUser()+""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public Utilisateur getUtil(int id) {
        // Retourne l'animal dont l'id est passé en paramètre

        Utilisateur a=new Utilisateur(0,"Spidertom");

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+IDUSER+"="+id, null);
        if (c.moveToFirst()) {
            a.setIdUser(c.getInt(c.getColumnIndex(IDUSER)));
            a.setPseudo(c.getString(c.getColumnIndex(NOMUTIL)));
            c.close();
        }

        return a;
    }

}
