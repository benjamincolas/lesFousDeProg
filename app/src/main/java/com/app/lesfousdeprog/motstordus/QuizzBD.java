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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizzBD extends AppCompatActivity{
/*    private int NumQuestionRecup;
    private TextView txt_qu;
    private TextView txt_numquest;
    private int[] numBoutonRadio;
    private RadioGroup ensQuestions;
    private RadioButton[] reponses;
    private Button btn_Valider;
    private String questions[][] = {
            {"Quelle est BLABLABLA","Drago Malefoy","Neville Londubat","Ron Weasley","Hermione Granger","1" },
            {"Quelle est BLABLABLA","Rubeus Hagrid","Albus Dumbledoret","Severus Rogue","Hermione Granger","3" },
            {"Quelle est BLABLABLA","Katie Bell","Hermione Granger","Minerva McGonagall","Hermione Granger","2" },
            {"Quelle est BLABLABLA","Pétunia Dursley","Molly Weasley","Alicia Spinnet","Hermione Granger","1" } };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz_bd);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        NumQuestionRecup = this.getIntent().getExtras().getInt("Numero");
        reponses = new RadioButton[4];
        txt_qu=(TextView)this.findViewById(R.id.txt_qu);
        txt_numquest=(TextView)this.findViewById(R.id.txt_numquest);
        ensQuestions = (RadioGroup) this.findViewById(R.id.rdbg_question);

        btn_Valider=(Button)this.findViewById(R.id.btn_valider);
        btn_Valider.setOnClickListener(this);


        numBoutonRadio = new int[4];
        numBoutonRadio[0] = View.generateViewId();
        numBoutonRadio[1] = View.generateViewId();
        numBoutonRadio[2] = View.generateViewId();
        numBoutonRadio[3] = View.generateViewId();




    // creation de boutons radio
    reponses[0].setMinWidth(400);

    reponses[1].setMinWidth(400);

    reponses[2].setMinWidth(400);

    reponses[3].setMinWidth(400);

    rempQuestions(NumQuestionRecup);
    }

    private void rempQuestions(int unNumQ){
        txt_qu.setText(questions[unNumQ][0]);
        reponses[0].setText(questions[unNumQ][1]);
        reponses[1].setText(questions[unNumQ][2]);
        reponses[2].setText(questions[unNumQ][3]);
        reponses[3].setText(questions[unNumQ][4]);
        ensQuestions.addView(reponses[0]);
        ensQuestions.addView(reponses[1]);
        ensQuestions.addView(reponses[2]);
        ensQuestions.addView(reponses[3]);}






@Override
    public void onClick(View v) {
        int retour = ensQuestions.getCheckedRadioButtonId();
        int bonneRep = Integer.parseInt(questions[NumQuestionRecup][5]);
       if(numBoutonRadio[bonneRep-1]==retour) {
           Toast.makeText(this, "Réponse correcte", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Réponse fausse, il fallait choisir : " + questions[NumQuestionRecup][bonneRep], Toast.LENGTH_SHORT).show();
        }


        if(NumQuestionRecup <  (questions.length-1)){
            setResult(RESULT_OK, new Intent().putExtra("Numero",NumQuestionRecup));
        }
        else{
            setResult(RESULT_CANCELED, new Intent());
        }
        finish();

       }*/


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
        R.drawable.qu1bd,
    R.drawable.qu2bd,
    R.drawable.qu3bd,
    R.drawable.qu4bd,
    R.drawable.qu5bd,
    R.drawable.qu6bd,
    R.drawable.qu7bd,
    R.drawable.qu8bd,
    R.drawable.qu9bd,
    R.drawable.qu10bd
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
        Intent unIntent = new Intent(QuizzBD.this,Deblocage.class);
        unIntent.putExtra("score", lescore);
        unIntent.putExtra("nbscore", nscore);
        QuizzBD.this.startActivityForResult(unIntent, code_fenetre);}
        else {
        nQuestionView.setText(nQuizz.getQuestionsbd(nQuestionNumber));
        nButtonChoice1.setText(nQuizz.getChoicesbd(nQuestionNumber));
        nButtonChoice1.setBackgroundColor(Color.WHITE);
        nButtonChoice2.setText(nQuizz.getChoices2bd(nQuestionNumber));
        nButtonChoice2.setBackgroundColor(Color.WHITE);
        nButtonChoice3.setText(nQuizz.getChoices3bd(nQuestionNumber));
        nButtonChoice3.setBackgroundColor(Color.WHITE);
        nButtonChoice4.setText(nQuizz.getChoices4bd(nQuestionNumber));
        nButtonChoice4.setBackgroundColor(Color.WHITE);
        nButtonChoice1.setClickable(true);
        nButtonChoice2.setClickable(true);
        nButtonChoice3.setClickable(true);
        nButtonChoice4.setClickable(true);
        imgquest.setImageResource(images[nQuestionNumber]);
        suivant.setVisibility(View.INVISIBLE);

        nAnswer = nQuizz.getCorrectAnwerbd(nQuestionNumber);
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
