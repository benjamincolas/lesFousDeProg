package com.app.lesfousdeprog.motstordus;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import java.util.ArrayList;

public class MemoRigolo extends AppCompatActivity {

    private int click = 0;
    private ImageView[] imageView;
    private ImageView imageClick;
    private ImageView choiceImage1;
    private ImageView choiceImage2;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_rigolo);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setImage();

        this.findViewById(R.id.imageView10).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImageView temp1 = imageView[0];
                ImageView temp2 = findViewById(R.id.imageView10);
                testClick(temp1, temp2);
                testImage();
            }
        });

        this.findViewById(R.id.imageView11).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImageView temp1 = imageView[1];
                ImageView temp2 = findViewById(R.id.imageView11);
                testClick(temp1, temp2);
                testImage();
            }
        });

        this.findViewById(R.id.imageView12).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImageView temp1 = imageView[2];
                ImageView temp2 = findViewById(R.id.imageView12);
                testClick(temp1, temp2);
                testImage();
            }
        });

        this.findViewById(R.id.imageView13).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImageView temp1 = imageView[3];
                ImageView temp2 = findViewById(R.id.imageView13);
                testClick(temp1, temp2);
                testImage();
            }
        });

        this.findViewById(R.id.imageView14).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImageView temp1 = imageView[4];
                ImageView temp2 = findViewById(R.id.imageView14);
                testClick(temp1, temp2);
                testImage();
            }
        });

        this.findViewById(R.id.imageView15).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImageView temp1 = imageView[5];
                ImageView temp2 = findViewById(R.id.imageView15);
                testClick(temp1, temp2);
                testImage();
            }
        });

        this.findViewById(R.id.imageView16).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImageView temp1 = imageView[6];
                ImageView temp2 = findViewById(R.id.imageView16);
                testClick(temp1, temp2);
                testImage();
            }
        });

        this.findViewById(R.id.imageView17).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImageView temp1 = imageView[7];
                ImageView temp2 = findViewById(R.id.imageView17);
                testClick(temp1, temp2);
                testImage();
            }
        });
    }

    public void testImage(){
        if(click == 2){
            handler.postDelayed(new Runnable() {
                public void run() {
                    choiceImage1.setVisibility(View.VISIBLE);
                    choiceImage2.setVisibility(View.VISIBLE);
                    imageClick.setVisibility(View.INVISIBLE);
                    click = 0;
                }
            }, 1000);
        }
    }

    public void setImage(){
        Integer[] listImage = new Integer[]{
                R.mipmap.balai,
                R.mipmap.batman,
                R.mipmap.luffy,
                R.mipmap.titeuf
        };


        imageView = new ImageView[]{
                this.findViewById(R.id.imageView),
                this.findViewById(R.id.imageView2),
                this.findViewById(R.id.imageView3),
                this.findViewById(R.id.imageView4),
                this.findViewById(R.id.imageView5),
                this.findViewById(R.id.imageView6),
                this.findViewById(R.id.imageView7),
                this.findViewById(R.id.imageView8)
        };

        ArrayList<Integer> nbAlea = new ArrayList<>();


        nbAlea.add(0);
        nbAlea.add(0);
        nbAlea.add(1);
        nbAlea.add(1);
        nbAlea.add(2);
        nbAlea.add(2);
        nbAlea.add(3);
        nbAlea.add(3);

        for (ImageView imageTemp : imageView){
            int alea = (int) (nbAlea.size() * Math.random());
            imageTemp.setBackgroundResource(listImage[nbAlea.get(alea)]);
            imageTemp.setTag(listImage[nbAlea.get(alea)]);
            nbAlea.remove(alea);
        }
    }

    @SuppressLint("CutPasteId")
    public void testClick(ImageView iv1, ImageView iv2){
        click ++;
        if(click == 1){
            imageClick = iv1;
            imageClick.setVisibility(View.VISIBLE);
            choiceImage1 = iv2;
            choiceImage1.setVisibility(View.INVISIBLE);
        }
        else if(click == 2){
            imageClick = iv1;
            imageClick.setVisibility(View.VISIBLE);
            choiceImage2 = iv2;
            choiceImage2.setVisibility(View.INVISIBLE);
        }
    }
}
