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

import java.util.ArrayList;

public class MemoRigolo extends AppCompatActivity {

    private int click = 0;
    private ArrayList<ImageView> imageViews;
    private int choiceImage1;
    private View view1;
    private int position1;
    private int choiceImage2;
    private View view2;
    private  int position2;
    private Handler handler = new Handler();
    private int difficulte;
    private GridView gridImage;
    private ArrayList<Integer> idImageView;
    private int tempDifficulte;
    private TextView memorigolo;
    private int score;


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
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, long id) {
                view.setBackgroundResource(idImageView.get(position));
                click ++;

                if(click ==1){
                    choiceImage1 = idImageView.get(position);
                    view1 = view;
                    position1 = position;
                }else if(click == 2){
                    choiceImage2 = idImageView.get(position);
                    view2 = view;
                    position2 = position;
                }

                if(click == 2){
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(choiceImage1 != choiceImage2){
                                gridImage.getAdapter().getView(position1, view1, parent).setBackgroundResource(R.mipmap.pow);
                                gridImage.getAdapter().getView(position2, view2, parent).setBackgroundResource(R.mipmap.pow);
                            }
                            else{
                                score++;
                                if(score == (score*2)/2){
                                    MemoRigolo.this.findViewById(R.id.gagner).setVisibility(View.VISIBLE);
                                }
                            }
                            click = 0;
                        }}, 700);
                }
            }
        });
    }
}
