package com.app.lesfousdeprog.motstordus;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import java.util.ArrayList;

public class MemoRigolo extends AppCompatActivity {

    private int click = 0;
    private ImageView[] imageView;
    private int[] image;
    private ImageView image1;
    private ImageView image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_rigolo);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        image = new int[]{
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

        setImage();

        this.findViewById(R.id.imageView10).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                click ++;

                if(click == 1){
                    image1 = imageView[0];
                }
                if(click == 2){
                    image2 = imageView[0];
                }

                if(click == 2){
                    if(getImageResource(image1) == getImageResource(image2)){
                        click = 0;
                    }
                    else{
                        image1.setBackgroundResource(R.mipmap.pow);
                        image2.setBackgroundResource(R.mipmap.pow);
                        click = 0;
                    }
                }
            }
        });

        this.findViewById(R.id.imageView11).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                click ++;

                if(click == 1){
                    image1 = imageView[1];
                }
                if(click == 2){
                    image2 = imageView[1];
                }

                if(click == 2){
                    if(getImageResource(image1) == getImageResource(image2)){
                        click = 0;
                    }
                    else{
                        image1.setBackgroundResource(R.mipmap.pow);
                        image2.setBackgroundResource(R.mipmap.pow);
                        click = 0;
                    }
                }
            }
        });
    }

    public int getImageResource(ImageView iv) {
        return (Integer) iv.getTag();
    }

    public void setImage(){
        ArrayList<Integer> nbAlea = new ArrayList<>();

        nbAlea.add(1,1);
        nbAlea.add(2,1);
        nbAlea.add(3,2);
        nbAlea.add(4,2);
        nbAlea.add(5,3);
        nbAlea.add(6,3);
        nbAlea.add(7,4);
        nbAlea.add(8,4);

        for (ImageView imageTemp : imageView){
            int alea = (int) (Math.random() * ((nbAlea.size())));

            imageTemp.setTag(image[nbAlea.get(alea)]);
            imageTemp.setBackgroundResource(image[nbAlea.get(alea)]);

            nbAlea.remove(alea);
        }
    }
}
