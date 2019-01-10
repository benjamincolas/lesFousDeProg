package com.app.lesfousdeprog.motstordus;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.View;
import android.widget.Button;

public class Regles extends AppCompatActivity {
//region propriétés
    //déclarations des propriétés
    private Button btn_retour;
    private final int code_fenetre=20;

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regles);
        //permet de mettre l'application en plein écran pour ne pas avoir de bandeau en haut de l'écran de tablette
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//permet de bloquer l'orientation de la tablette en mode paysage



        //le bouton retour permet de revenir à la page d'accuel
        btn_retour= (Button)this.findViewById(R.id.btn_retour);
        btn_retour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent unIntent = new Intent(Regles.this, Accueil.class);
                Regles.this.startActivityForResult(unIntent, code_fenetre);

            }
        });
    }
}
