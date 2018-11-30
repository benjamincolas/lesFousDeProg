package com.app.lesfousdeprog.motstordus;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class MemoRigolo extends AppCompatActivity {

    private int click = 0;
    private TextView txtV;
    private ImageView[] imageView;
    private int[] image;
    private int[] numero;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_rigolo);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        txtV = (TextView) this.findViewById(R.id.numero);

        image = new int[]{
                R.drawable.balai,
                R.drawable.batman,
                R.drawable.luffy,
                R.drawable.titeuf
        };

        imageView = new ImageView[]{
                this.findViewById(R.id.imageView),
                this.findViewById(R.id.imageView2)
        };

        numero = new int[]{
                1,2,3,4,5,6,7,8
        };


        imageView[0].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                int imageAlea = 0 + (int)(Math.random() * ((4 - 0) + 1));

                imageView[0].setTag(image[imageAlea]);
                imageView[0].setBackgroundResource(image[imageAlea]);
                click ++;
                txtV.setText(Integer.toString(click));

                if(click == 2){
                    if(getImageResource(imageView[0]) == getImageResource(imageView[1])){
                        imageView[0].setVisibility(View.INVISIBLE);
                        imageView[1].setVisibility(View.INVISIBLE);
                        click = 0;
                    }
                    else{
                        imageView[0].setBackgroundResource(R.drawable.pow);
                        imageView[1].setBackgroundResource(R.drawable.pow);
                        click = 0;
                    }
                }
            }
        });

        imageView[1].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                int imageAlea = 0 + (int)(Math.random() * ((4 - 0) + 1));

                imageView[1].setTag(image[imageAlea]);
                imageView[1].setBackgroundResource(image[imageAlea]);
                click ++;
                txtV.setText(Integer.toString(click));

                if(click == 2){
                    if(getImageResource(imageView[0]) == getImageResource(imageView[1])){
                        imageView[0].setVisibility(View.INVISIBLE);
                        imageView[1].setVisibility(View.INVISIBLE);
                        click = 0;
                    }
                    else{
                        imageView[0].setBackgroundResource(R.drawable.pow);
                        imageView[1].setBackgroundResource(R.drawable.pow);
                        click = 0;
                    }
                }
            }
        });
    }

    public int getImageResource(ImageView iv) {
        return (Integer) iv.getTag();
    }
}
