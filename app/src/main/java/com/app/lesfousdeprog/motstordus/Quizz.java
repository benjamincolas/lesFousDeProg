package com.app.lesfousdeprog.motstordus;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Quizz extends AppCompatActivity {
    private Button btn_manga;
    private Button btn_bd;
    private Button btn_comics;
    private Button btn_retour;
    private final int code_fenetre = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        btn_bd = (Button) this.findViewById(R.id.btn_bd);
        btn_bd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent unIntent = new Intent(Quizz.this, QuizzBD.class);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);
            }
        });

        btn_comics = (Button) this.findViewById(R.id.btn_comics);
        btn_comics.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent unIntent = new Intent(Quizz.this, QuizzComics.class);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);
            }
        });

        btn_manga = (Button) this.findViewById(R.id.btn_manga);
        btn_manga.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent unIntent = new Intent(Quizz.this, QuizzManga.class);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);
            }
        });


        btn_retour = (Button) this.findViewById(R.id.btn_retour2);
        btn_retour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent unIntent = new Intent(Quizz.this, Accueil.class);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);
            }
        });
    }
}
