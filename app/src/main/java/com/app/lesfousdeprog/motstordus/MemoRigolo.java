package com.app.lesfousdeprog.motstordus;

import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MemoRigolo extends AppCompatActivity {

    private int click = 0;
    private ArrayList<ImageView> imageViews;
    private ImageView choiceImage1;
    private ImageView choiceImage2;
    private Handler handler = new Handler();
    private int difficulte;
    private GridView gridImage;
    private ArrayList<Integer> idImageView;
    private int tempDifficulte;
    private TextView memorigolo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_rigolo);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageViews = new ArrayList<>();
        idImageView = new ArrayList<>();
        gridImage = this.findViewById(R.id.gridView);

        difficulte = 12;
        tempDifficulte = difficulte/2;

        memorigolo = findViewById(R.id.memorigolo);

        setImage();
    }


    public void testImage(){
        handler.postDelayed(new Runnable() {
            public void run() {
                if(choiceImage1.getTag() != choiceImage2.getTag()){
                    choiceImage1.setVisibility(View.INVISIBLE);
                    choiceImage2.setVisibility(View.INVISIBLE);
                }
                click = 0;
            }}, 700);
    }

    public void setImage(){
        ArrayList<Integer> nbAlea = new ArrayList<>();
        tempDifficulte-=1;
        final Integer[] listImage = new Integer[]{
                R.mipmap.batman,
                R.mipmap.captain_america,
                R.mipmap.captain_marvel,
                R.mipmap.naruto,
                R.mipmap.schtroumpf,
                R.mipmap.son_goku,
                R.mipmap.tintin,
                R.mipmap.wonder_woman
        };

        if(difficulte == 8){
            GridView dataGrid = findViewById(R.id.gridView);
            dataGrid.setColumnWidth(450);
            dataGrid.requestLayout();
        }
        else if(difficulte == 12){
            GridView dataGrid = findViewById(R.id.gridView);
            dataGrid.setColumnWidth(325);
            dataGrid.requestLayout();
        }
        /*else if(difficulte == 16){
            GridView dataGrid = findViewById(R.id.gridView);
            dataGrid.setColumnWidth(250);
            dataGrid.setNumColumns(5);
            dataGrid.requestLayout();
        }*/

        while(tempDifficulte > -1){
            nbAlea.add(tempDifficulte);
            nbAlea.add(tempDifficulte);
            tempDifficulte --;
        }
        difficulte-=1;
        while (difficulte > -1){
            int alea = (int) (nbAlea.size() * Math.random());
            ImageView iv = new ImageView(this);
            iv.setImageResource(listImage[nbAlea.get(alea)]);
            iv.setId(difficulte);
            iv.setTag(listImage[nbAlea.get(alea)]);

            imageViews.add(iv);
            idImageView.add(listImage[nbAlea.get(alea)]);
            difficulte --;
            nbAlea.remove(alea);
        }

        GridAdapter adapter = new GridAdapter(MemoRigolo.this, idImageView);
        gridImage.setAdapter(adapter);
        gridImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MemoRigolo.this, "id image" + imageViews.get(position).getId(), Toast.LENGTH_SHORT).show();
                view.setBackgroundResource(idImageView.get(position));
                //testClick();
            }
        });

        /*for (Integer uneImage : idImageView) {

            this.findViewById(uneImage).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ImageView temp1 = imageViews.get(0);
                    testClick(temp1);
                }
            });
        }*/
    }

    public void testClick(ImageView iv1){
        click ++;
        if(click == 1){
            choiceImage1 = iv1;
            choiceImage1.setVisibility(View.VISIBLE);
        }
        else if(click == 2){
            choiceImage2 = iv1;
            choiceImage2.setVisibility(View.VISIBLE);

            testImage();
        }
    }
}
