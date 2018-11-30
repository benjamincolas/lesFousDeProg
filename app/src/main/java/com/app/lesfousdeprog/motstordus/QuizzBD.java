package com.app.lesfousdeprog.motstordus;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizzBD extends AppCompatActivity {
    private RadioButton mOneRadioButton;
    private RadioButton mTwoRadioButton;
    private RadioButton mThreeRadioButton;
    private RadioButton mFourRadioButton;
    private int NumQuestionRecup;
    private TextView txt_qu;
    private int[] numBoutonRadio;
    private LinearLayout ensQuestions;
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


        mOneRadioButton = (RadioButton) findViewById(R.id.radioButton1);
        mOneRadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mOneRadioButton.setChecked(true);
                mTwoRadioButton.setChecked(false);
                mThreeRadioButton.setChecked(false);
                mFourRadioButton.setChecked(false);
            }
        });

        mTwoRadioButton = (RadioButton) findViewById(R.id.radioButton2);
        mTwoRadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mOneRadioButton.setChecked(false);
                mTwoRadioButton.setChecked(true);
                mThreeRadioButton.setChecked(false);
                mFourRadioButton.setChecked(false);
            }
        });

        mThreeRadioButton = (RadioButton) findViewById(R.id.radioButton3);
        mThreeRadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mOneRadioButton.setChecked(false);
                mTwoRadioButton.setChecked(false);
                mThreeRadioButton.setChecked(true);
                mFourRadioButton.setChecked(false);
            }
        });

        mFourRadioButton = (RadioButton) findViewById(R.id.radioButton4);
        mFourRadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mOneRadioButton.setChecked(false);
                mTwoRadioButton.setChecked(false);
                mThreeRadioButton.setChecked(false);
                mFourRadioButton.setChecked(true);
            }
        });

        NumQuestionRecup = this.getIntent().getExtras().getInt("Numero");

        txt_qu=(TextView)this.findViewById(R.id.txt_qu);
        ensQuestions = (LinearLayout) this.findViewById(R.id.linearLayout);

       // btn_Valider=(Button)this.findViewById(R.id.btn_valider);
       // btn_Valider.setOnClickListener(this);

        numBoutonRadio = new int[4];
        //numBoutonRadio[0] = mOneRadioButton;
        //numBoutonRadio[1] = mTwoRadioButton;
        //numBoutonRadio[2] = mThreeRadioButton;
        //numBoutonRadio[3] = mFourRadioButton;


    }

    private void rempQuestions(int unNumQ){
        txt_qu.setText(questions[unNumQ][0]);
        mOneRadioButton.setText(questions[unNumQ][1]);
        mTwoRadioButton.setText(questions[unNumQ][2]);
        mThreeRadioButton.setText(questions[unNumQ][3]);
        mFourRadioButton.setText(questions[unNumQ][4]);
        ensQuestions.addView(mOneRadioButton);
        ensQuestions.addView(mTwoRadioButton);
        ensQuestions.addView(mThreeRadioButton);
        ensQuestions.addView(mFourRadioButton);

    }

   // @Override
   // public void onClick(View v) {
        //int retour = ensQuestions.getCheckedRadioButtonId();
       // int bonneRep = Integer.parseInt(questions[NumQuestionRecup][5]);
       // if(numBoutonRadio[bonneRep-1]==retour) {
   //         Toast.makeText(this, "Réponse correcte", Toast.LENGTH_SHORT).show();
     //   }
       // else{
         //   Toast.makeText(this, "Réponse fausse, il fallait choisir : " + questions[NumQuestionRecup][bonneRep], Toast.LENGTH_SHORT).show();
       // }


       // if(NumQuestionRecup <  (questions.length-1)){
         //   setResult(RESULT_OK, new Intent().putExtra("Numero",NumQuestionRecup));
       // }
       // else{
        //    setResult(RESULT_CANCELED, new Intent());
        //}
        //finish();
    //}
}
