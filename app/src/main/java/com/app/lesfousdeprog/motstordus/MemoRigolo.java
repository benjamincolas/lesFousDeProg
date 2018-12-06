package com.app.lesfousdeprog.motstordus;

import android.content.pm.ActivityInfo;
import android.media.Image;
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
    private Integer[] image;
    private ImageView image1;
    private ImageView image2;
    private ImageView tempimage1;
    private ImageView tempimage2;
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
                click ++;

                if(click == 1){
                    imageView[0].setVisibility(View.VISIBLE);
                    image1 = imageView[0];
                    tempimage1 = findViewById(R.id.imageView10);
                    tempimage1.setVisibility(View.INVISIBLE);
                }
                if(click == 2){
                    imageView[0].setVisibility(View.VISIBLE);
                    image2 = imageView[0];
                    tempimage2 = findViewById(R.id.imageView10);
                    tempimage2.setVisibility(View.INVISIBLE);
                }

                testImage();
            }
        });

        this.findViewById(R.id.imageView11).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                click ++;

                if(click == 1){
                    imageView[1].setVisibility(View.VISIBLE);
                    image1 = imageView[1];
                    tempimage1 = findViewById(R.id.imageView11);
                    tempimage1.setVisibility(View.INVISIBLE);
                }
                if(click == 2){
                    imageView[1].setVisibility(View.VISIBLE);
                    image2 = imageView[1];
                    tempimage2 = findViewById(R.id.imageView11);
                    tempimage2.setVisibility(View.INVISIBLE);
                }

                testImage();
            }
        });

        this.findViewById(R.id.imageView12).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                click ++;

                if(click == 1){
                    imageView[2].setVisibility(View.VISIBLE);
                    image1 = imageView[2];
                    tempimage1 = findViewById(R.id.imageView12);
                    tempimage1.setVisibility(View.INVISIBLE);
                }
                if(click == 2){
                    imageView[2].setVisibility(View.VISIBLE);
                    image2 = imageView[2];
                    tempimage2 = findViewById(R.id.imageView12);
                    tempimage2.setVisibility(View.INVISIBLE);
                }

                testImage();
            }
        });

        this.findViewById(R.id.imageView13).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                click ++;

                if(click == 1){
                    imageView[3].setVisibility(View.VISIBLE);
                    image1 = imageView[3];
                    tempimage1 = findViewById(R.id.imageView13);
                    tempimage1.setVisibility(View.INVISIBLE);
                }
                if(click == 2){
                    imageView[3].setVisibility(View.VISIBLE);
                    image2 = imageView[3];
                    tempimage2 = findViewById(R.id.imageView13);
                    tempimage2.setVisibility(View.INVISIBLE);
                }

                testImage();
            }
        });

        this.findViewById(R.id.imageView14).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                click ++;

                if(click == 1){
                    imageView[4].setVisibility(View.VISIBLE);
                    image1 = imageView[4];
                    tempimage1 = findViewById(R.id.imageView14);
                    tempimage1.setVisibility(View.INVISIBLE);
                }
                if(click == 2){
                    imageView[4].setVisibility(View.VISIBLE);
                    image2 = imageView[4];
                    tempimage2 = findViewById(R.id.imageView14);
                    tempimage2.setVisibility(View.INVISIBLE);
                }

                testImage();
            }
        });

        this.findViewById(R.id.imageView15).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                click ++;

                if(click == 1){
                    imageView[5].setVisibility(View.VISIBLE);
                    image1 = imageView[5];
                    tempimage1 = findViewById(R.id.imageView15);
                    tempimage1.setVisibility(View.INVISIBLE);
                }
                if(click == 2){
                    imageView[5].setVisibility(View.VISIBLE);
                    image2 = imageView[5];
                    tempimage2 = findViewById(R.id.imageView15);
                    tempimage2.setVisibility(View.INVISIBLE);
                }

                testImage();
            }
        });

        this.findViewById(R.id.imageView16).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                click ++;

                if(click == 1){
                    imageView[6].setVisibility(View.VISIBLE);
                    image1 = imageView[6];
                    tempimage1 = findViewById(R.id.imageView16);
                    tempimage1.setVisibility(View.INVISIBLE);
                }
                if(click == 2){
                    imageView[6].setVisibility(View.VISIBLE);
                    image2 = imageView[6];
                    tempimage2 = findViewById(R.id.imageView16);
                    tempimage2.setVisibility(View.INVISIBLE);
                }

                testImage();
            }
        });

        this.findViewById(R.id.imageView17).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                click ++;

                if(click == 1){
                    imageView[7].setVisibility(View.VISIBLE);
                    image1 = imageView[7];
                    tempimage1 = findViewById(R.id.imageView17);
                    tempimage1.setVisibility(View.INVISIBLE);
                }
                if(click == 2){
                    imageView[7].setVisibility(View.VISIBLE);
                    image2 = imageView[7];
                    tempimage2 = findViewById(R.id.imageView17);
                    tempimage2.setVisibility(View.INVISIBLE);
                }

                testImage();
            }
        });
    }

    public int getImageResource(ImageView iv) {
        return (Integer) iv.getTag();
    }

    public void testImage(){
        if(click == 2){
            if(getImageResource(image1) == getImageResource(image2)){
                click = 0;
            }
            else{
                handler.postDelayed(new Runnable() {
                    public void run() {
                        tempimage1.setVisibility(View.VISIBLE);
                        tempimage2.setVisibility(View.VISIBLE);
                        image1.setVisibility(View.INVISIBLE);
                        image2.setVisibility(View.INVISIBLE);
                        click = 0;
                    }

                }, 1000);
            }
        }
    }

    public void setImage(){
        image = new Integer[]{
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
            imageTemp.setBackgroundResource(image[nbAlea.get(alea)]);
            imageTemp.setTag(image[nbAlea.get(alea)]);
            nbAlea.remove(alea);
        }
    }
}
