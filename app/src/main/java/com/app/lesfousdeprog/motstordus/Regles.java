package com.app.lesfousdeprog.motstordus;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Regles extends AppCompatActivity {


    private Button btn_retour;
    private final int code_fenetre=20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regles);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);



        btn_retour= (Button)this.findViewById(R.id.btn_retour);
        btn_retour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent unIntent = new Intent(Regles.this, Accueil.class);
                Regles.this.startActivityForResult(unIntent, code_fenetre);

            }
        });
    }
}
