package com.app.lesfousdeprog.motstordus;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class QuizzComics extends AppCompatActivity {

    private Quizz nQuizz = new Quizz();

    private TextView nScoreView;
    private TextView nQuestionView;
    private Button suivant;
    private Button nButtonChoice1;
    private Button nButtonChoice2;
    private Button nButtonChoice3;
    private Button nButtonChoice4;
    private ImageView imgquest;

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





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz_bd);

        nScoreView = (TextView)findViewById(R.id.score);
        nQuestionView =(TextView)findViewById(R.id.txt_qu);
        suivant=(Button)findViewById(R.id.suivant);
        nButtonChoice1=(Button)findViewById(R.id.choix1);
        nButtonChoice2=(Button)findViewById(R.id.choix2);
        nButtonChoice3=(Button)findViewById(R.id.choix3);
        nButtonChoice4=(Button)findViewById(R.id.choix4);
        imgquest=(ImageView)findViewById(R.id.img_quest) ;

        updateQuestion();


        nButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nButtonChoice1.getText() == nAnswer){
                    nscore = nscore +1;
                    updateScore(nscore);
                    nButtonChoice1.setBackgroundColor(Color.GREEN);
                    suivant.setVisibility(View.VISIBLE);
                    desactivebouton();


                }else {

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

                if (nButtonChoice2.getText() == nAnswer){
                    nscore = nscore +1;
                    updateScore(nscore);
                    nButtonChoice2.setBackgroundColor(Color.GREEN);
                    suivant.setVisibility(View.VISIBLE);
                    desactivebouton();


                }else {

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

                if (nButtonChoice3.getText() == nAnswer){
                    nscore = nscore +1;
                    updateScore(nscore);
                    nButtonChoice3.setBackgroundColor(Color.GREEN);
                    suivant.setVisibility(View.VISIBLE);
                    desactivebouton();


                }else {

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

                if (nButtonChoice4.getText() == nAnswer){
                    nscore = nscore +1;
                    updateScore(nscore);
                    nButtonChoice4.setBackgroundColor(Color.GREEN);
                    suivant.setVisibility(View.VISIBLE);
                    desactivebouton();


                }else {

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
            }
        });
    }
    private void updateQuestion(){

        if (nQuestionNumber==10) {
            lescore=nScoreView.getText().toString();
            Intent unIntent = new Intent(QuizzComics.this,Deblocage.class);
            unIntent.putExtra("score", lescore);
            unIntent.putExtra("nbscore", nscore);
            QuizzComics.this.startActivityForResult(unIntent, code_fenetre);}
        else {
            nQuestionView.setText(nQuizz.getQuestionsc(nQuestionNumber));
            nButtonChoice1.setText(nQuizz.getChoicesc(nQuestionNumber));
            nButtonChoice1.setBackgroundColor(Color.WHITE);
            nButtonChoice2.setText(nQuizz.getChoices2c(nQuestionNumber));
            nButtonChoice2.setBackgroundColor(Color.WHITE);
            nButtonChoice3.setText(nQuizz.getChoices3c(nQuestionNumber));
            nButtonChoice3.setBackgroundColor(Color.WHITE);
            nButtonChoice4.setText(nQuizz.getChoices4c(nQuestionNumber));
            nButtonChoice4.setBackgroundColor(Color.WHITE);
            nButtonChoice1.setClickable(true);
            nButtonChoice2.setClickable(true);
            nButtonChoice3.setClickable(true);
            nButtonChoice4.setClickable(true);
            imgquest.setImageResource(images[nQuestionNumber]);
            suivant.setVisibility(View.INVISIBLE);

            nAnswer = nQuizz.getCorrectAnwerc(nQuestionNumber);
            nQuestionNumber++;
        }}

    private void desactivebouton() {
        nButtonChoice1.setClickable(false);
        nButtonChoice2.setClickable(false);
        nButtonChoice3.setClickable(false);
        nButtonChoice4.setClickable(false);
    }

    private  void updateScore(int a){
        nScoreView.setText("Score de "+ nscore + " sur " + nQuestionNumber);
    }

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

