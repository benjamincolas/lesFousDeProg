package com.app.lesfousdeprog.motstordus;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RangeTaBd extends AppCompatActivity {
    TextView testTextview,textView3;
    ImageView img1,img2,img3,img4,imgpos1,imgpos2,imgpos3,imgpos4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_ta_bd);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

       img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);

        imgpos1 = (ImageView) findViewById(R.id.imgpos1);
        imgpos2 = (ImageView) findViewById(R.id.imgpos2);
        imgpos3 = (ImageView) findViewById(R.id.imgpos3);
        imgpos4 = (ImageView) findViewById(R.id.imgpos4); //recup id du cetru

        testTextview = (TextView) findViewById(R.id.testtxtview);
        textView3 = (TextView) findViewById(R.id.textView3);
        img1.setOnLongClickListener(longClickListener);
        img2.setOnLongClickListener(longClickListener);
        img3.setOnLongClickListener(longClickListener);
        img4.setOnLongClickListener(longClickListener);

        testTextview.setOnDragListener(dragListener); // = les trucs qui se font écouter
        imgpos1.setOnDragListener(dragListener);
        imgpos2.setOnDragListener(dragListener);
        imgpos2.setOnDragListener(dragListener);
        imgpos4.setOnDragListener(dragListener);
        textView3.setOnDragListener(dragListener);

    }
    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadow = new View.DragShadowBuilder(view);
            view.startDrag(data, myShadow, view, 0); // crée "ombre" de l'image quand long click
            return true;
        }
    };
View.OnDragListener dragListener = new View.OnDragListener() {
    @Override
    public boolean onDrag(View view, DragEvent event) {
        int dragEvent = event.getAction();
        final View vData = (View)event.getLocalState();
        final View vData2 = (View)event.getLocalState();
        switch (dragEvent) {
            case DragEvent.ACTION_DRAG_ENTERED: // si on entre dans le label
                if (vData.getId() == R.id.img1) {
                    testTextview.setText("yo trql ?");
                } else if (vData.getId() == R.id.img2) {
                    testTextview.setText("yo trql ? 2");
                } else if (vData.getId() == R.id.img3) {
                    testTextview.setText("yo trql ? 3");
                } else if (vData.getId() == R.id.img4) {
                    testTextview.setText("yo trql ? 4");
                }


                break;
            case DragEvent.ACTION_DRAG_EXITED:
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                break;
            case DragEvent.ACTION_DROP:
                if (vData.getId() == R.id.img1) {
                   img1.setY(vData2.getY());img1.setX(vData2.getX());


                } else if (vData.getId() == R.id.img2) {

                } else if (vData.getId() == R.id.img3) {

                } else if (vData.getId() == R.id.img4) {

                }
        }
        return true;
    }
};


}
