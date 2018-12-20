package com.app.lesfousdeprog.motstordus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Deblocage extends AppCompatActivity {

    private ImageView imgrtbd;
    private ImageView imgmr;
    private Button jouerrtbd;
    private Button jouermr;
    private TextView bravo;
    private final int code_fenetre = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deblocage);

        bravo = (TextView)findViewById(R.id.txt_bravo);
        jouermr=(Button)findViewById(R.id.jouermr);
        jouerrtbd=(Button)findViewById(R.id.jouerrtbd);
        imgmr=(ImageView)findViewById(R.id.img_quest);
        imgrtbd=(ImageView)findViewById(R.id.imgrtbd);

        String lescoreRecup = this.getIntent().getExtras().getString("score");
        bravo.setText("Grâce à ton " + lescoreRecup + ", tu as débloqué ceci :");

        int scoreRecup = this.getIntent().getExtras().getInt("nbscore");

        jouerrtbd.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                Intent unIntent = new Intent(Deblocage.this, RangeTaBd.class);
                Deblocage.this.startActivityForResult(unIntent, code_fenetre);
            }
        });

        jouermr.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                Intent unIntent = new Intent(Deblocage.this, MemoRigolo.class);
                Deblocage.this.startActivityForResult(unIntent, code_fenetre);
            }
        });

        if (scoreRecup<5)
        {

            jouermr.setText("Bloqué");
            jouermr.setClickable(false);



        }



    }
}
