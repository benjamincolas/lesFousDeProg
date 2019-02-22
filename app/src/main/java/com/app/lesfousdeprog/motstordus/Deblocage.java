
package com.app.lesfousdeprog.motstordus;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;
import static java.net.Proxy.Type.HTTP;

public class Deblocage extends AppCompatActivity {

    //region propriétés

    //déclarations des propriétés

    private Button jouerrtbd;
    private Button jouermr;
    private Button recommencer;
    private Button accueil;
    private TextView bravo;
    private HttpHandler httpHandler;
    private final int code_fenetre = 20;
private Utilisateur utilisateur;
private UtilisateurBdd utilisateurBdd;

private int idUser;
    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deblocage);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE); //permet de bloquer l'orientation de la tablette en mode paysage

        //permet de mettre l'application en plein écran pour ne pas avoir de bandeau en haut de l'écran de tablette
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bravo = (TextView)findViewById(R.id.txt_bravo);
        jouermr=(Button)findViewById(R.id.jouermr);
        jouerrtbd=(Button)findViewById(R.id.jouerrtbd);
        accueil=(Button)findViewById(R.id.accueildeb);
        recommencer=(Button)findViewById(R.id.recommencer);
httpHandler = new HttpHandler();
         utilisateurBdd = new UtilisateurBdd(this);
         idUser = utilisateurBdd.lastId();

        //affiche la phrase ci-dessous en fonction du score du joueur dans le textview bravo
        final int scoreRecup = this.getIntent().getExtras().getInt("nbscore"); //récupère le score du joueur réalisé dans le quiz
        bravo.setText("Bravo !! Avec ton score de " + scoreRecup + " sur 10, tu as débloqué ceci :");
        final String pseudo = (String) this.getIntent().getExtras().getString("pseudo");
        utilisateur = new Utilisateur(0,pseudo,99,99,0,scoreRecup,idUser);

        //le bouton jouerrtbd permet de lancer le jeu Range ta BD
        jouerrtbd.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {

                Intent unIntent = new Intent(Deblocage.this, RangeTaBd.class);
                unIntent.putExtra("user",  utilisateur);
                Deblocage.this.startActivityForResult(unIntent, code_fenetre);

            }
        });


        //le bouton jouermr permet de lancer le jeu Memo-Rigolo
        jouermr.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                Intent unIntent = new Intent(Deblocage.this, MemoRigolo.class);
                unIntent.putExtra("user", utilisateur);
                Deblocage.this.startActivityForResult(unIntent, code_fenetre);
            }
        });


        //le bouton recommencer permet de revenir à la page de choix de thème du quiz
        recommencer.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                Intent unIntent = new Intent(Deblocage.this, Quizz.class);
                unIntent.putExtra("user", (Serializable) utilisateur);
                Deblocage.this.startActivityForResult(unIntent, code_fenetre);
            }
        });

        accueil.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                Intent unIntent = new Intent(Deblocage.this, Accueil.class);
                Deblocage.this.startActivityForResult(unIntent, code_fenetre);
            }
        });



        //permet de ne pas débloquer le jeu Memo-Rigolo si le score du joueur dans le quiz est inférieur à 5
        if (scoreRecup<5)
        {

            jouermr.setText("Bloqué");//le texte du bouton jouermr devient "Bloqué"
            jouermr.setClickable(false);//le bouton jouermr devient incliquable
            jouermr.setBackgroundColor(Color.GRAY);// le bouton jouermr devient gris
            jouermr.requestLayout();
            bravo.setText("Dommage ! Avec ton score de " + scoreRecup + " sur 10, tu as débloqué ceci :");

        }


       long lastId =  utilisateurBdd.addUser(utilisateur);
    }

    //permet de ne pas pouvoir cliquer sur le bouton retour de la tablette
    @Override
    public void onBackPressed() {

    }

}
