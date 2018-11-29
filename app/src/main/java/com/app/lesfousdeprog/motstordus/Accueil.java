package com.app.lesfousdeprog.motstordus;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Accueil extends AppCompatActivity {

    private Button btn_quitter;
    private Button btn_regles;
    private Button btn_jouer;
    private final int code_fenetre=20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        btn_regles = (Button)this.findViewById(R.id.btn_regles);
        btn_regles.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent unIntent = new Intent(Accueil.this, Regles.class);
                Accueil.this.startActivityForResult(unIntent, code_fenetre);
            }
        });
    }
}
