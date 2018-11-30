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
    TextView testTextview,txtView1,txtView2,txtView3,txtView4;
    ImageView img1,img2,img3,img4,imgpos1,imgpos2,imgpos3,imgpos4;
 int visibilite;
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
        imgpos4 = (ImageView) findViewById(R.id.imgpos4);

        txtView1 = (TextView) findViewById(R.id.txtView1);
        txtView2 = (TextView) findViewById(R.id.txtView2);
        txtView3 = (TextView) findViewById(R.id.txtView3);
        txtView4 = (TextView) findViewById(R.id.txtView4); //recup id du cetru

        testTextview = (TextView) findViewById(R.id.testtxtview);

        img1.setOnLongClickListener(longClickListener);
        img2.setOnLongClickListener(longClickListener);
        img3.setOnLongClickListener(longClickListener);
        img4.setOnLongClickListener(longClickListener);

        testTextview.setOnDragListener(dragListener); // = les trucs qui se font écouter

        txtView1.setOnDragListener(dragListener);
        txtView2.setOnDragListener(dragListener);
        txtView3.setOnDragListener(dragListener);
        txtView4.setOnDragListener(dragListener);
       // img1.setOnDragListener(testafondlesballons);
        img2.setOnDragListener(testafondlesballons);
        //img3.setOnDragListener(testafondlesballons);
        //img4.setOnDragListener(testafondlesballons);


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
        final View vData = (View)event.getLocalState(); //prend la position de l'img en cours de sélection

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
          /*  case DragEvent.ACTION_DROP:
                if (vData.getId() == R.id.img1) {//si c'est l'image 1
                   img2.setY(vData.getY());img2.setX(vData.getX()); //l'image 2 prend la place de l'img1


                } else if (vData.getId() == R.id.img2) {
                    img3.setY(vData.getY());img3.setX(vData.getX()); //l'image 2 prend la place de l'img1
                } else if (vData.getId() == R.id.img3) {
                    img4.setY(vData.getY());img4.setX(vData.getX()); //l'image 2 prend la place de l'img1
                } else if (vData.getId() == R.id.img4) {
                    img1.setY(vData.getY());img1.setX(vData.getX()); //l'image 2 prend la place de l'img1
                }*/
        }
        return true;
    }
};
/*
    View.OnDragListener dragListener2 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent event) {
            int dragEvent = event.getAction();
            final View vData = (View)event.getLocalState();


            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED: // si on entre dans le label
                    if (vData.getId() == R.id.img1) {

                        testTextview.setText("img1 "+Double.toString(vData.getX())+"   "+Double.toString(vData.getY()));
                    } else if (vData.getId() == R.id.img2) {
                        testTextview.setText("img2 "+Double.toString(vData.getX())+"   "+Double.toString(vData.getY()));
                    } else if (vData.getId() == R.id.img3) {
                        testTextview.setText("img3 "+Double.toString(vData.getX())+"   "+Double.toString(vData.getY()));
                    } else if (vData.getId() == R.id.img4) {
                        testTextview.setText("img4 "+Double.toString(vData.getX())+"   "+Double.toString(vData.getY()));
                    }


                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    break;
                case DragEvent.ACTION_DROP:
                    if (vData.getId() == R.id.img1) {
                        img1.setY(imgpos2.getY());img1.setX(imgpos2.getX());
                      img2.setY(imgpos1.getY());img2.setX(imgpos1.getX());



                    } else if (vData.getId() == R.id.img2) {
                        img2.setY(imgpos2.getY());img2.setX(imgpos2.getX());
                        img2.setY(imgpos3.getY());img2.setX(imgpos3.getX());
                    } else if (vData.getId() == R.id.img3) {
                        img3.setY(imgpos2.getY());img3.setX(imgpos2.getX());
                        img2.setY(imgpos3.getY());img2.setX(imgpos3.getX());

                    } else if (vData.getId() == R.id.img4) {
                        img4.setY(imgpos2.getY());img4.setX(imgpos2.getX());
                        img2.setY(imgpos4.getY());img2.setX(imgpos4.getX());

                    }
            }
            return true;
        }
    };
*/
View.OnDragListener testafondlesballons = new View.OnDragListener() {
    @Override
    public boolean onDrag(View view, DragEvent event) {
        int dragEvent = event.getAction();
        final View vData = (View)event.getLocalState();
       // testTextview.setText(Double.toString(vData.getX())+" "+Double.toString(img1.getX()));

        switch (dragEvent) {
            case DragEvent.ACTION_DRAG_ENTERED: // si on entre dans le label
                if (vData.getId() == R.id.img1) {

                    testTextview.setText("img1 "+Double.toString(vData.getX())+"   "+Double.toString(vData.getY()));
                } else if (vData.getId() == R.id.img2) {
                    testTextview.setText("img2 "+Double.toString(vData.getX())+"   "+Double.toString(vData.getY()));
                } else if (vData.getId() == R.id.img3) {
                    testTextview.setText("img3 "+Double.toString(vData.getX())+"   "+Double.toString(vData.getY()));
                } else if (vData.getId() == R.id.img4) {
                    testTextview.setText("img4 "+Double.toString(vData.getX())+"   "+Double.toString(vData.getY()));
                }


                break;
            case DragEvent.ACTION_DRAG_EXITED:
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                break;
            case DragEvent.ACTION_DROP:
                if (vData.getId() == R.id.img1) {
                    img2.setX(vData.getX());img2.setY(vData.getY());
                    img1.setX(img2.getX());img1.setY(img2.getY());img1.setZ(img2.getZ());
                    testTextview.setText("salut moi c lolo ");
                } else if (vData.getId() == R.id.img2) {
                    img2.setX(vData.getX());img2.setY(vData.getY());
                    img2.setX(img2.getX());img2.setY(img2.getY());img2.setZ(img2.getZ());
                } else if (vData.getId() == R.id.img3) {
                    img2.setX(vData.getX());img2.setY(vData.getY());
                    img3.setX(img2.getX());img3.setY(img2.getY());img3.setZ(img2.getZ());
                } else if (vData.getId() == R.id.img4) {
                    img2.setX(vData.getX());img2.setY(vData.getY());
                    img4.setX(img2.getX());img4.setY(img2.getY());img4.setZ(img2.getZ());
                }

        }
        return true;
    }
};


}
