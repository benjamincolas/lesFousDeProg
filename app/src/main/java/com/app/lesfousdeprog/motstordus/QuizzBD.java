package com.app.lesfousdeprog.motstordus;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizzBD extends AppCompatActivity implements View.OnClickListener{
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




















    private TextView joueur;
    private TextView uneQuestion;
    private RadioGroup ensQuestions;
    private int NumQuestionRecup;
    private int[] numBoutonRadio;
    private int numQuestion;
    private RadioButton[] reponses;
    private Button result;
    private String questions[][] = {
            {"Tom Felton","Drago Malefoy","Neville Londubat","Ron Weasley","1" },
            {"Alan Rickman","Rubeus Hagrid","Albus Dumbledoret","Severus Rogue","3" },
            {"Emma Watson","Katie Bell","Hermione Granger","Minerva McGonagall","2" },
            {"Fiona Shaw","Pétunia Dursley","Molly Weasley","Alicia Spinnet","1" } };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz_bd);
        String lePrenomRecup = this.getIntent().getExtras().getString("Joueur");
        NumQuestionRecup = this.getIntent().getExtras().getInt("Numero");

        //initialisation des contrôles
        uneQuestion=(TextView)this.findViewById(R.id.txt_qu);
        uneQuestion.setMinWidth(400);
        ensQuestions = (RadioGroup)this.findViewById(R.id.rdbg_question);
        reponses = new RadioButton[3];


        // creation de boutons radio
        reponses[0].setTextColor(Color.parseColor("#4DF73C"));
        reponses[0].setMinWidth(400);


        reponses[1].setTextColor(Color.parseColor("#4DF73C"));
        reponses[1].setMinWidth(400);



        reponses[2].setTextColor(Color.parseColor("#4DF73C"));
        reponses[2].setMinWidth(400);


        //generation d’un Id pour les boutons radio
        numBoutonRadio = new int[3];
        numBoutonRadio[0] = View.generateViewId();
        numBoutonRadio[1] = View.generateViewId();
        numBoutonRadio[2] = View.generateViewId();


        // affectation d’un id aux boutons radio afin de savoir lequel est selectionné
        reponses[0].setId(numBoutonRadio[0]);
        reponses[1].setId(numBoutonRadio[1]);
        reponses[2].setId(numBoutonRadio[2]);


        // gestion du bouton
        result=(Button)this.findViewById(R.id.btn_valider);
        result.setOnClickListener(this);


        //lancement des questions….
        rempQuestions(NumQuestionRecup);
    }

    private void rempQuestions(int unNumQ){
        uneQuestion.setText("Qui joue " + questions[unNumQ][0] + " dans l'école des sorciers ?");
        reponses[0].setText(questions[unNumQ][1]);
        reponses[1].setText(questions[unNumQ][2]);
        reponses[2].setText(questions[unNumQ][3]);
        ensQuestions.addView(reponses[0]);
        ensQuestions.addView(reponses[1]);
        ensQuestions.addView(reponses[2]); }

    @Override
    public void onClick(View v) {
        int retour = ensQuestions.getCheckedRadioButtonId();
        //int bonneRep = Integer.parseInt(questions[numQuestion][4]);
        int bonneRep = Integer.parseInt(questions[NumQuestionRecup][4]);
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
    }
}
