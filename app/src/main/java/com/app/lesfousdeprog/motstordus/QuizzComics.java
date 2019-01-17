package com.app.lesfousdeprog.motstordus;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class QuizzComics extends AppCompatActivity {

    //region propriétés
    //déclarations des propriétés
    private Quizz nQuizz = new Quizz();

    private TextView nScoreView;
    private TextView nQuestionView;
    private Button suivant;
    private Button nButtonChoice1;
    private Button nButtonChoice2;
    private Button nButtonChoice3;
    private Button nButtonChoice4;
    private ImageView imgquest;

    //stocke les images des questions
    int [] images = {
            R.drawable.qu1comics,
            R.drawable.qu2comics,
            R.drawable.qu3comics,
            R.drawable.qu4comics,
            R.drawable.qu5comics,
            R.drawable.qu6comics,
            R.drawable.qu7comics,
            R.drawable.qu8comics,
            R.drawable.qu9comics,
            R.drawable.qu10comics
    };

    private String lescore;
    private String nAnswer;
    private int nscore = 0;
    private int nQuestionNumber = 0;
    private final int code_fenetre=20;

//endregion



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz_bd);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);//permet de bloquer l'orientation de la tablette en mode paysage

        //permet de mettre l'application en plein écran pour ne pas avoir de bandeau en haut de l'écran de tablette
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        nScoreView = (TextView)findViewById(R.id.score);
        nQuestionView =(TextView)findViewById(R.id.txt_qu);
        suivant=(Button)findViewById(R.id.suivant);
        nButtonChoice1=(Button)findViewById(R.id.choix1);
        nButtonChoice2=(Button)findViewById(R.id.choix2);
        nButtonChoice3=(Button)findViewById(R.id.choix3);
        nButtonChoice4=(Button)findViewById(R.id.choix4);
        imgquest=(ImageView)findViewById(R.id.img_quest) ;

        updateQuestion();//appel de la méthode updateQuestion


        nButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //si la réponse est bonne : augmente le score de 1pt et recharge le score avec la méthode updateScore, met le bouton de la réponse en vert, désactive les boutons de réponse
                // et affiche le bouton suivant pour passer à la question suivante
                if (nButtonChoice1.getText() == nAnswer){
                    nscore = nscore +1;
                    updateScore(nscore);
                    nButtonChoice1.setBackgroundColor(Color.GREEN);
                    suivant.setVisibility(View.VISIBLE);
                    desactivebouton();


                }else {
                    //si la réponse est fausse : met le bouton de la réponse du joueur en rouge, recharge le score, désactive les boutons de réponse, affiche le bouton suivant
                    // et met le bouton de la bonne réponse en vert

                    nButtonChoice1.setBackgroundColor(Color.RED);
                    suivant.setVisibility(View.VISIBLE);
                    updateScore(nscore);
                    desactivebouton();
                    reponsebonne();
                }
            }
        });

        nButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //si la réponse est bonne : augmente le score de 1pt et recharge le score avec la méthode updateScore, met le bouton de la réponse en vert, désactive les boutons de réponse
                // et affiche le bouton suivant pour passer à la question suivante
                if (nButtonChoice2.getText() == nAnswer){
                    nscore = nscore +1;
                    updateScore(nscore);
                    nButtonChoice2.setBackgroundColor(Color.GREEN);
                    suivant.setVisibility(View.VISIBLE);
                    desactivebouton();


                }else {
                    //si la réponse est fausse : met le bouton de la réponse du joueur en rouge, recharge le score, désactive les boutons de réponse, affiche le bouton suivant
                    // et met le bouton de la bonne réponse en vert

                    nButtonChoice2.setBackgroundColor(Color.RED);
                    suivant.setVisibility(View.VISIBLE);
                    updateScore(nscore);
                    desactivebouton();
                    reponsebonne();
                }
            }
        });

        nButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //si la réponse est bonne : augmente le score de 1pt et recharge le score avec la méthode updateScore, met le bouton de la réponse en vert, désactive les boutons de réponse
                // et affiche le bouton suivant pour passer à la question suivante
                if (nButtonChoice3.getText() == nAnswer){
                    nscore = nscore +1;
                    updateScore(nscore);
                    nButtonChoice3.setBackgroundColor(Color.GREEN);
                    suivant.setVisibility(View.VISIBLE);
                    desactivebouton();


                }else {
                    //si la réponse est fausse : met le bouton de la réponse du joueur en rouge, recharge le score, désactive les boutons de réponse, affiche le bouton suivant
                    // et met le bouton de la bonne réponse en vert

                    nButtonChoice3.setBackgroundColor(Color.RED);
                    suivant.setVisibility(View.VISIBLE);
                    updateScore(nscore);
                    desactivebouton();
                    reponsebonne();
                }
            }
        });

        nButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //si la réponse est bonne : augmente le score de 1pt et recharge le score avec la méthode updateScore, met le bouton de la réponse en vert, désactive les boutons de réponse
                // et affiche le bouton suivant pour passer à la question suivante
                if (nButtonChoice4.getText() == nAnswer){
                    nscore = nscore +1;
                    updateScore(nscore);
                    nButtonChoice4.setBackgroundColor(Color.GREEN);
                    suivant.setVisibility(View.VISIBLE);
                    desactivebouton();


                }else {
                    //si la réponse est fausse : met le bouton de la réponse du joueur en rouge, recharge le score, désactive les boutons de réponse, affiche le bouton suivant
                    // et met le bouton de la bonne réponse en vert

                    nButtonChoice4.setBackgroundColor(Color.RED);
                    suivant.setVisibility(View.VISIBLE);
                    updateScore(nscore);
                    desactivebouton();
                    reponsebonne();
                }
            }
        });

        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
                if (nQuestionNumber==10){
                    suivant.setText("Fin du Quiz");                }
            }
        });
    }
    private void updateQuestion(){


        //si le quiz est terminé, récupère le score effectué pour la page de déblocage des jeux et lance cette page
        if (nQuestionNumber==10) {
            lescore=nScoreView.getText().toString();
            Intent unIntent = new Intent(QuizzComics.this,Deblocage.class);
            unIntent.putExtra("score", lescore);
            unIntent.putExtra("nbscore", nscore);
            QuizzComics.this.startActivityForResult(unIntent, code_fenetre);}

        //s'il reste des questions :
        else {
            nQuestionView.setText(nQuizz.getQuestionsc(nQuestionNumber));//affecte le texte de la question correspondant au numéro de question

            //pour chaque bouton de réponse affecte le texte des questions correspondant au numéro de la question et rend les boutons blancs
            nButtonChoice1.setText(nQuizz.getChoicesc(nQuestionNumber));
            nButtonChoice1.setBackgroundColor(Color.WHITE);
            nButtonChoice2.setText(nQuizz.getChoices2c(nQuestionNumber));
            nButtonChoice2.setBackgroundColor(Color.WHITE);
            nButtonChoice3.setText(nQuizz.getChoices3c(nQuestionNumber));
            nButtonChoice3.setBackgroundColor(Color.WHITE);
            nButtonChoice4.setText(nQuizz.getChoices4c(nQuestionNumber));
            nButtonChoice4.setBackgroundColor(Color.WHITE);

            //rend les boutons de réponse cliquable
            nButtonChoice1.setClickable(true);
            nButtonChoice2.setClickable(true);
            nButtonChoice3.setClickable(true);
            nButtonChoice4.setClickable(true);
            imgquest.setImageResource(images[nQuestionNumber]);//affecte l'image correspondant au numéro de la question
            suivant.setVisibility(View.INVISIBLE);//rend le bouton suivant invisible

            nAnswer = nQuizz.getCorrectAnwerc(nQuestionNumber);
            nQuestionNumber++;//augmente de 1 le numéro de la question
        }}


    //permet de désactiver les 4 boutons de réponse
    private void desactivebouton() {
        nButtonChoice1.setClickable(false);
        nButtonChoice2.setClickable(false);
        nButtonChoice3.setClickable(false);
        nButtonChoice4.setClickable(false);
    }

    private  void updateScore(int a){
        nScoreView.setText("Score : "+ nscore + " / " + nQuestionNumber);//permet d'afficher le score dans le text view score en fonction du score actuel et du numéro de la question
    }


    //permet de rendre vert le bouton contenant la bonne réponse
    private void reponsebonne() {
        if(nButtonChoice1.getText() == nAnswer){
            nButtonChoice1.setBackgroundColor(Color.GREEN);
        }
        if(nButtonChoice2.getText() == nAnswer){
            nButtonChoice2.setBackgroundColor(Color.GREEN);
        }
        if(nButtonChoice3.getText() == nAnswer){
            nButtonChoice3.setBackgroundColor(Color.GREEN);
        }
        if(nButtonChoice4.getText() == nAnswer){
            nButtonChoice4.setBackgroundColor(Color.GREEN);
        }
    }

}

