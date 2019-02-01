package com.app.lesfousdeprog.motstordus;

import android.database.MatrixCursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Classement extends AppCompatActivity {
    private UtilisateurBdd userbdd;
private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);
        userbdd = new UtilisateurBdd(this);

        txt =  this.findViewById(R.id.txt);
txt.setText(userbdd.getUtil());
}}
