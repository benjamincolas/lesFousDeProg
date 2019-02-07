package com.app.lesfousdeprog.motstordus;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Range;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Accueil extends AppCompatActivity {

    //region propriétés
    //déclarations des propriétés
    private Button btn_regles;
    private Button btn_jouer;
    private Button btn_classement;
    private Utilisateur user;
    private MySQLite userbddd = new MySQLite(this);

    int scoreQuizComics =0;int scoreMemo =0;int scoreRange =0;int scoreQuizManga=0;int scoreQuizBd =0;int idUser =0;
    String pseudo ="";
    private final int code_fenetre = 20;
    String uneUrl = String.format("http://benjamincolaspro.ddns.net/appAndroid/json.php");
    ArrayList<HashMap<String, String>>List_etudiants;
    private String TAG = Accueil.class.getSimpleName();
private  UtilisateurBdd userbd;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        List_etudiants = new ArrayList<>();
        setContentView(R.layout.activity_accueil);
         userbd = new UtilisateurBdd(Accueil.this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);//permet de bloquer l'orientation de la tablette en mode paysage
        new GetEtudiants().execute();
        //permet de mettre l'application en plein écran pour ne pas avoir de bandeau en haut de l'écran de tablette
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//gestion page classement
        btn_classement = (Button) this.findViewById(R.id.btn_classement);
        btn_classement.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                Intent unIntent = new Intent(Accueil.this, Classement.class);
                Accueil.this.startActivityForResult(unIntent, code_fenetre);
            }
        });
        //gestion du bouton JOUER
        btn_jouer = (Button) this.findViewById(R.id.btn_jouer);
        btn_jouer.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                Intent unIntent = new Intent(Accueil.this, Quizz.class);
                Accueil.this.startActivityForResult(unIntent, code_fenetre);
            }
        });

        //gestion du bouton REGLES
        btn_regles = (Button) this.findViewById(R.id.btn_regles);
        btn_regles.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent unIntent = new Intent(Accueil.this, Regles.class);
                Accueil.this.startActivityForResult(unIntent, code_fenetre);
            }
        });
        //gestion page classement


    }
    private class GetEtudiants extends AsyncTask<Void, Void, Void> {

        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
// déclenche une requête sur l&#39;url
            String url = uneUrl;
            String jsonStr = sh.makeServiceCall(url);
            Log.e(TAG, "Response from url: " + jsonStr);
            userbd.open();
            if (jsonStr != null) {
                try {
                    JSONArray contacts = new JSONArray(jsonStr);
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);
                        int idUser = c.getInt("idUser");
                        String pseudo = c.getString("pseudo");
                        int scoreMemo = c.getInt("scoreMemo");
                        int scoreQuizBd = c.getInt("scoreQuizBd");
                        int scoreQuizComics = c.getInt("scoreQuizComics");
                        int scoreQuizManga = c.getInt("scoreQuizManga");
                        int scoreRange = c.getInt("scoreRange");

                        HashMap<String, String> etudiant = new HashMap<>();
                        etudiant.put("idUser", String.valueOf(idUser));
                        etudiant.put("pseudo", pseudo);
                        etudiant.put("scoreMemo", String.valueOf(scoreMemo));
                        etudiant.put("scoreQuizBd", String.valueOf(scoreQuizBd));
                        etudiant.put("scoreQuizComics", String.valueOf(scoreQuizComics));
                        etudiant.put("scoreQuizManga", String.valueOf(scoreQuizManga));
                        etudiant.put("scoreRange", String.valueOf(scoreRange));
                        Utilisateur user = new Utilisateur(scoreQuizComics,pseudo,scoreMemo,scoreRange,scoreQuizManga,scoreQuizBd,idUser);

                        long var = userbd.addUser(user);
                       // return db.insert(TABLE_NAME,null,values);
                        List_etudiants.add(etudiant);
                    }

                } catch (final JSONException e) {
                    Log.e(TAG, "erreur de Parse Json: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "erreur de Parse Json:" + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
            } else {
                Log.e(TAG, "Pb récup Json sur le serveur");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Pb récup Json sur le serveur. Voir Logcat!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
            userbd.close();
            return null;
        }
        @Override
        protected void onPostExecute(Void result){
            super.onPostExecute(result);
           //user = new Utilisateur(0,"test",1,2,3,4,5);
           //userbd.addUser(user);
                Log.d("oui", userbd.getUtil()); //List_etudiants.toString()
                userbd.close();
        }
        @Override
        protected  void onPreExecute(){
            super.onPreExecute();
            Toast.makeText(Accueil.this,"Salut ça charge",Toast.LENGTH_LONG).show();
        }}

}
