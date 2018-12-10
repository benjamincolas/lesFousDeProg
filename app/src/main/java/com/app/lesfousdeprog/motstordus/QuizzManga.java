package com.app.lesfousdeprog.motstordus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizzManga extends AppCompatActivity {

    private Quizz nQuizz = new Quizz();

    private TextView nScoreView;
    private TextView nQuestionView;
    private Button nButtonChoice1;
    private Button nButtonChoice2;
    private Button nButtonChoice3;
    private Button nButtonChoice4;


    private String nAnswer;
    private int nscore = 0;
    private int nQuestionNumber = 0;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz_bd);

        nScoreView = (TextView)findViewById(R.id.score);
        nQuestionView =(TextView)findViewById(R.id.txt_qu);
        nButtonChoice1=(Button)findViewById(R.id.choix1);
        nButtonChoice2=(Button)findViewById(R.id.choix2);
        nButtonChoice3=(Button)findViewById(R.id.choix3);
        nButtonChoice4=(Button)findViewById(R.id.choix4);

        updateQuestion();


        nButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nButtonChoice1.getText() == nAnswer){
                    nscore = nscore +1;
                    updateScore(nscore);
                    updateQuestion();

                    Toast.makeText(QuizzManga.this, "Correct", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(QuizzManga.this, "Faux", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        nButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nButtonChoice2.getText() == nAnswer){
                    nscore = nscore +1;
                    updateScore(nscore);
                    updateQuestion();

                    Toast.makeText(QuizzManga.this, "Correct", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(QuizzManga.this, "Faux", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        nButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nButtonChoice3.getText() == nAnswer){
                    nscore = nscore +1;
                    updateScore(nscore);
                    updateQuestion();

                    Toast.makeText(QuizzManga.this, "Correct", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(QuizzManga.this, "Faux", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        nButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nButtonChoice4.getText() == nAnswer){
                    nscore = nscore +1;
                    updateScore(nscore);
                    updateQuestion();

                    Toast.makeText(QuizzManga.this, "Correct", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(QuizzManga.this, "Faux", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
    }
    private void updateQuestion(){
        nQuestionView.setText(nQuizz.getQuestionsm(nQuestionNumber));
        nButtonChoice1.setText(nQuizz.getChoicesm(nQuestionNumber));
        nButtonChoice2.setText(nQuizz.getChoices2m(nQuestionNumber));
        nButtonChoice3.setText(nQuizz.getChoices3m(nQuestionNumber));
        nButtonChoice4.setText(nQuizz.getChoices4m(nQuestionNumber));

        nAnswer = nQuizz.getCorrectAnwerm(nQuestionNumber);
        nQuestionNumber++;
    }



    private  void updateScore(int a){
        nScoreView.setText("" + nscore);
    }
}
