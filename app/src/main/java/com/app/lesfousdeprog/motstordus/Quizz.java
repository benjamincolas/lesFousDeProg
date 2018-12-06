package com.app.lesfousdeprog.motstordus;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Quizz extends AppCompatActivity {
   private Button btn_manga;
    private Button btn_bd;
    private Button btn_comics;
    private Button btn_retour;
    private int num;
    private final int code_fenetre = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);


        btn_manga = (Button) this.findViewById(R.id.btn_manga);
        btn_manga.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                Intent unIntent = new Intent(Quizz.this, QuizzManga.class);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);
            }
        });

        btn_comics = (Button) this.findViewById(R.id.btn_comics);
        btn_comics.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                Intent unIntent = new Intent(Quizz.this, QuizzComics.class);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);
            }
        });

        btn_bd = (Button) this.findViewById(R.id.btn_bd);
        btn_bd.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                Intent unIntent = new Intent(Quizz.this, QuizzBD.class);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);
            }
        });

       /* btn_retour = (Button) this.findViewById(R.id.btn_retour);
        btn_retour.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                Intent unIntent = new Intent(Quizz.this, Accueil.class);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);
            }
        }); */


    }



    /*    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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

    private void jouerBD(int unNumQ){
        Intent unIntent = new Intent(this, QuizzBD.class);
        unIntent.putExtra("Numero", unNumQ);
        this.startActivityForResult(unIntent,code_fenetre); }

    private void jouerComics(int unNumQ){
        Intent unIntent = new Intent(this, QuizzComics.class);
        unIntent.putExtra("Numero", unNumQ);
        this.startActivityForResult(unIntent,code_fenetre); }

    private void jouerManga(int unNumQ){
        Intent unIntent = new Intent(this, QuizzManga.class);
        unIntent.putExtra("Numero", unNumQ);
        this.startActivityForResult(unIntent,code_fenetre); }



    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {     //super.onActivityResult(requestCode, resultCode, data);     //on gère l’activité concernée
        if(requestCode==code_fenetre){
            //si l’activité a retourner ok
            if(resultCode==RESULT_OK){
                //on vérifie la présence d’un ‘numéro’ (celui de la question traitée)
                if(data.hasExtra(("Numero"))){
                    //récupère e numéro de la dernière question
                    num = data.getExtras().getInt("Numero");
                    //incrémente pour lancer la question suivante
                    num++;
                    jouerBD(num);
                }
            }
            else{
                Toast.makeText(this, "Fin du jeu", Toast.LENGTH_SHORT);
                num = 0;         }     } }*/


        private String mquestions[] = {
                "QUEL EST BLABLA ?",
                "QUEL EST YOYOYAYA ?",
                "QUI EST CE MEC?",};


        private String mChoices[][] = {
                {"CE MEC", "CE TRUC", "CE GARS", "CETTE CHOSE"},
                {"CE MAC", "CE TROC", "CE GORS", "CETTE CHISE"},
                {"CE MIC", "CE TRIC", "CE GIRS", "CETTE CHUSE"},};

        private String mCorrectAnswers[] = {"CE MEC", "CETTE CHISE", "CE TRIC"};


        public String getQuestions ( int a){
            String question = mquestions[a];
            return question;
        }

        public String getChoices ( int a){
            String choices0 = mChoices[a][0];
            return choices0;
        }

        public String getChoices2 ( int a){
            String choice1 = mChoices[a][1];
            return choice1;
        }


        public String getChoices3 ( int a){
            String choice2 = mChoices[a][2];
            return choice2;
        }

        public String getChoices4 ( int a){
            String choice3 = mChoices[a][3];
            return choice3;
        }

        public String getCorrectAnwer ( int a){
            String answer = mCorrectAnswers[a];
            return answer;
        }



































}
