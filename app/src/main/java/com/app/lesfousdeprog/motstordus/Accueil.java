package com.app.lesfousdeprog.motstordus;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Accueil extends AppCompatActivity implements View.OnClickListener {

    private Button btn_quitter;
    private Button btn_regles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        btn_quitter = (Button)this.findViewById(R.id.btn_quitter);
        btn_quitter.setOnClickListener(this);

        btn_regles = (Button)this.findViewById(R.id.btn_regles);
        btn_regles.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
