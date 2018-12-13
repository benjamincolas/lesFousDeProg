package com.app.lesfousdeprog.motstordus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Deblocage extends AppCompatActivity {

    private ImageView imgrtbd;
    private ImageView imgmr;
    private Button jouerrtbd;
    private Button jouermr;
    private TextView bravo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deblocage);

        bravo = (TextView)findViewById(R.id.txt_bravo);
        jouermr=(Button)findViewById(R.id.jouermr);
        jouerrtbd=(Button)findViewById(R.id.jouerrtbd);
        imgmr=(ImageView)findViewById(R.id.img_quest);
        imgrtbd=(ImageView)findViewById(R.id.imgrtbd);

        String scoreRecup = this.getIntent().getExtras().getString("score");
        bravo.setText("Grâce à ton score de " + scoreRecup + " sur 10, tu as débloqué ceci :");
    }
}
