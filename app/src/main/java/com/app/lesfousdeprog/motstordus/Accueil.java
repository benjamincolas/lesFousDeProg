package com.app.lesfousdeprog.motstordus;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Range;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Accueil extends AppCompatActivity {

    //region propriétés
    //déclarations des propriétés
    private Button btn_regles;
    private Button btn_jouer;
    private final int code_fenetre = 20;

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);//permet de bloquer l'orientation de la tablette en mode paysage

        //permet de mettre l'application en plein écran pour ne pas avoir de bandeau en haut de l'écran de tablette
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
    }

}
