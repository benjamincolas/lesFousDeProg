package com.app.lesfousdeprog.motstordus;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class MemoRigolo extends AppCompatActivity implements View.OnClickListener {

    //region propriétées
    private ArrayList<Integer> imgBack;
    private ArrayList<ImageView> imgDes;
    private int tempOnClick;
    private int nbClick;
    private ImageView imgClick1;
    private int img1;
    private ImageView imgClick2;
    private int img2;
    private ImageView[] listImageView;
    private Handler handler;
    private int score;
    private Chronometer chronometer;
    private boolean jeuOn;
    private LottieAnimationView trophy;
    private ImageView imgBlanc;
    private TextView txtFin;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_rigolo);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE); //autorise seulement la rotation horizontal
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //met l'application en plein écran

        //region initialisation de certaines propriétées
        jeuOn = false;
        tempOnClick = 0;
        nbClick = 0;
        imgBack = new ArrayList<>();
        imgDes = new ArrayList<>();
        chronometer = this.findViewById(R.id.timer);
        imgBlanc = this.findViewById(R.id.imgBlancMemo);
        txtFin = this.findViewById(R.id.txtFinMemo);
        trophy = this.findViewById(R.id.trophy);
        imgClick1 = new ImageView(this);
        imgClick2 = new ImageView(this);
        //endregion
        setImages(); //permet l'affectation des images
        desactiveClick(); //désactive les images
    }

    @Override
    public void onClick(View v) {
        if(jeuOn){
            switch (v.getId()) {
                case R.id.imageView:
                    if (imgClick1.getId() != R.id.imageView || imgClick2.getId() != R.id.imageView) {
                        tempOnClick++;
                        nbClick++;
                        v.setBackground(getDrawable(imgBack.get(0)));
                        setClickImage((ImageView) v, imgBack.get(0));
                    }
                    break;
                case R.id.imageView2:
                    if (imgClick1.getId() != R.id.imageView2 || imgClick2.getId() != R.id.imageView2) {
                        tempOnClick++;
                        nbClick++;
                        v.setBackground(getDrawable(imgBack.get(1)));
                        setClickImage((ImageView) v, imgBack.get(1));
                    }
                    break;
                case R.id.imageView3:
                    if (imgClick1.getId() != R.id.imageView3 || imgClick2.getId() != R.id.imageView3) {
                        tempOnClick++;
                        nbClick++;
                        v.setBackground(getDrawable(imgBack.get(2)));
                        setClickImage((ImageView) v, imgBack.get(2));
                    }
                    break;
                case R.id.imageView4:
                    if (imgClick1.getId() != R.id.imageView4 || imgClick2.getId() != R.id.imageView4) {
                        tempOnClick++;
                        nbClick++;
                        v.setBackground(getDrawable(imgBack.get(3)));
                        setClickImage((ImageView) v, imgBack.get(3));
                    }
                    break;
                case R.id.imageView5:
                    if (imgClick1.getId() != R.id.imageView5 || imgClick2.getId() != R.id.imageView5) {
                        tempOnClick++;
                        nbClick++;
                        v.setBackground(getDrawable(imgBack.get(4)));
                        setClickImage((ImageView) v, imgBack.get(4));
                    }
                    break;
                case R.id.imageView6:
                    if (imgClick1.getId() != R.id.imageView6 || imgClick2.getId() != R.id.imageView6) {
                        tempOnClick++;
                        nbClick++;
                        v.setBackground(getDrawable(imgBack.get(5)));
                        setClickImage((ImageView) v, imgBack.get(5));
                    }
                    break;
                case R.id.imageView7:
                    if (imgClick1.getId() != R.id.imageView7 || imgClick2.getId() != R.id.imageView7) {
                        tempOnClick++;
                        nbClick++;
                        v.setBackground(getDrawable(imgBack.get(6)));
                        setClickImage((ImageView) v, imgBack.get(6));
                    }
                    break;
                case R.id.imageView8:
                    if (imgClick1.getId() != R.id.imageView8 || imgClick2.getId() != R.id.imageView8) {
                        tempOnClick++;
                        nbClick++;
                        v.setBackground(getDrawable(imgBack.get(7)));
                        setClickImage((ImageView) v, imgBack.get(7));
                    }
                    break;
                case R.id.imageView9:
                    if (imgClick1.getId() != R.id.imageView9 || imgClick2.getId() != R.id.imageView9) {
                        tempOnClick++;
                        nbClick++;
                        v.setBackground(getDrawable(imgBack.get(8)));
                        setClickImage((ImageView) v, imgBack.get(8));
                    }
                    break;
                case R.id.imageView10:
                    if (imgClick1.getId() != R.id.imageView10 || imgClick2.getId() != R.id.imageView10) {
                        tempOnClick++;
                        nbClick++;
                        v.setBackground(getDrawable(imgBack.get(9)));
                        setClickImage((ImageView) v, imgBack.get(9));
                    }
                    break;
            }
        }
        if(v.getId() == R.id.btn_commencer){
            voirImage(); //permet de voir où sont placé les images avant le début du jeu
            jeuOn = true;
            chronometer.start();
        }
    }

    public void setImages() {
        ArrayList<Integer> nbAlea = new ArrayList<>();

        Integer[] listImage = new Integer[]{ //liste des images du jeu
                R.drawable.batman,
                R.drawable.captain_america,
                R.drawable.tintin,
                R.drawable.naruto,
                R.drawable.schtroumpf
        };

        listImageView = new ImageView[]{ //liste des imageView
                this.findViewById(R.id.imageView),
                this.findViewById(R.id.imageView2),
                this.findViewById(R.id.imageView3),
                this.findViewById(R.id.imageView4),
                this.findViewById(R.id.imageView5),
                this.findViewById(R.id.imageView6),
                this.findViewById(R.id.imageView7),
                this.findViewById(R.id.imageView8),
                this.findViewById(R.id.imageView9),
                this.findViewById(R.id.imageView10)
        };

        for (Integer image : listImage) {
            nbAlea.add(image);
            nbAlea.add(image);
        }

        for (ImageView imageView : listImageView) {
            int alea = (int) (nbAlea.size() * Math.random());
            imgBack.add(nbAlea.get(alea));
            nbAlea.remove(alea);
        }
    }

    public void setClickImage(ImageView v, int img) {
        if (tempOnClick == 1) {
            imgClick1 = v;
            img1 = img;
        } else if (tempOnClick == 2) {
            imgClick2 = v;
            img2 = img;
            tempOnClick = 0;
            compare();
        }
    }

    public void compare() {
        if (img1 == img2) {
            imgClick1.setEnabled(false);
            imgClick2.setEnabled(false);
            imgDes.add(imgClick1);
            imgDes.add(imgClick2);

            if(imgDes.size() == 10){
                chronometer.stop();
                desactiveClick();
                jeuOn=false;

                imgBlanc.setVisibility(View.VISIBLE);
                txtFin.setVisibility(View.VISIBLE);
                trophy.setVisibility(View.VISIBLE);
                //trophy.playAnimation();
                //trophy.loop(true);

                if((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 25000){
                    score = 0;
                }
                else{
                    score = (int) (((SystemClock.elapsedRealtime() - chronometer.getBase())/1000)*100) - nbClick;
                }
            }
        } else {
            desactiveClick();
            handler = new Handler();
            handler.postDelayed(new Runnable() { //lance un délai
                public void run() {
                    imgClick1.setBackground(getDrawable(R.drawable.pow));
                    imgClick2.setBackground(getDrawable(R.drawable.pow));
                    activeClick();

                    for (ImageView imageView : imgDes) {
                        imageView.setEnabled(false);
                    }
                }
            }, 1000);
        }
    }
    public void activeClick(){
        for (ImageView imageView : listImageView) {
            imageView.setEnabled(true);
        }
    }

    public void desactiveClick(){
        for (ImageView imageView : listImageView) {
            imageView.setEnabled(false);
        }
    }
    public void voirImage() {
        int temp = 0;
        for (ImageView imageView : listImageView) {
            imageView.setBackground(getDrawable(imgBack.get(temp)));
            temp++;
        }
        findViewById(R.id.btn_commencer).setVisibility(View.INVISIBLE);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                for (ImageView imageView : listImageView) {
                    imageView.setBackground(getDrawable(R.drawable.pow));
                }
                activeClick();
            }
        }, 2000);
    }
}
