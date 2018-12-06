package com.app.lesfousdeprog.motstordus;

import android.annotation.SuppressLint;
import android.app.LauncherActivity;
import android.content.ClipData;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

public class RangeTaBd extends AppCompatActivity {

    ImageView img1, img2, img3, img4, imgFond;
    TextView txtView2;
    Button valider, lancer,suivant;
    LinearLayout rect1, rect2, rect3, rect4;
    int visibilite = 0;
    private boolean boolImg1 = false;
    private boolean boolImg2 = false;
    private boolean boolImg3 = false;
    private boolean boolImg4 = false;

    float y;
    float x;
    private float xImg1, xImg2, xImg3, xImg4;
    private float yImg1, yImg2, yImg3, yImg4;
    private List<Float> listPosX;
    private List<Float> listPosY;
    private List<Integer> spiderman;
    private List<List<Integer>> listImg;
public int score=0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_ta_bd);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//mode horizontale
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //met en fullscreen l'app
        img1 = (ImageView) findViewById(R.id.img1); // initialise une variable img1 de type imageview et dont l'id dans le fichier xml est img1
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        imgFond = (ImageView) findViewById(R.id.imgfondblancgris);
        rect1 = (LinearLayout) findViewById(R.id.rect1);
        rect2 = (LinearLayout) findViewById(R.id.rect2);
        rect3 = (LinearLayout) findViewById(R.id.rect3);
        rect4 = (LinearLayout) findViewById(R.id.rect4);
        valider = (Button) findViewById(R.id.btn_valider);
        lancer = (Button) findViewById(R.id.btn_lancer);
        suivant = (Button) findViewById(R.id.btn_suivant);
        txtView2 = (TextView) findViewById(R.id.txtView2);
        img1.setOnLongClickListener(longClickListener);
        img2.setOnLongClickListener(longClickListener);
        img3.setOnLongClickListener(longClickListener);
        img4.setOnLongClickListener(longClickListener);
        lancer.setOnClickListener(clickListener);
        valider.setOnClickListener(clickListenerValider);
        suivant.setOnClickListener(clickListener2);
        img1.setOnDragListener(listenerimg1);
        img2.setOnDragListener(listenerimg2);
        img3.setOnDragListener(listenerimg3);
        img4.setOnDragListener(listenerimg4);
        lol();
    }

//region onclicklistener
    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) { //quand on fait un long click
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadow = new View.DragShadowBuilder(view);
            view.startDrag(data, myShadow, view, 0); // crée l'ombre de l'image quand long click
            return true;
        }
    };
    //endregion
//region dragListener
    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent event) { // quand on drag quelque chose
            int dragEvent = event.getAction();
            final View vData = (View) event.getLocalState(); //prend la position de l'img en cours de sélection

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    break;

            }
            return true;
        }
    };
    //endregion
//region listenering 1
    View.OnDragListener listenerimg1 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent event) { //Quand l'image 1 reçoit une action de drop
            int dragEvent = event.getAction();
            final View vData = (View) event.getLocalState();


            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED: // si on entre dans l'image 1 fait un prévisualisation de sa place si on le drop
                    if (boolImg1 == false) {
                        if (vData.getId() == R.id.img2) {
                            x = vData.getX();
                            y = vData.getY();

                            vData.setX(img1.getX());
                            vData.setY(img1.getY());
                            img1.setX(x);
                            img1.setY(y);
                        } else if (vData.getId() == R.id.img3) {
                            x = vData.getX();
                            y = vData.getY();

                            vData.setX(img1.getX());
                            vData.setY(img1.getY());
                            img1.setX(x);
                            img1.setY(y);
                        } else if (vData.getId() == R.id.img4) {
                            y = vData.getY();
                            x = vData.getX();
                            vData.setY(img1.getY());
                            vData.setX(img1.getX());
                            img1.setY(y);
                            img1.setX(x);

                        }
                    }
                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    break;
                case DragEvent.ACTION_DROP:
                    if (boolImg1 == false) {
                        if (vData.getId() == R.id.img1) { // si l'image drag est l'img 1
                            x = vData.getX(); // prend le x de l'image drag
                            y = vData.getY(); // prend le y
//
                            vData.setX(img1.getX());
                            vData.setY(img1.getY()); // envoie l'image drag dans la pos de l'img1
                            img1.setX(x);
                            img1.setY(y); // envoie l'img 1 sur la pos de l'img drop

                        } else if (vData.getId() == R.id.img2) {
                            x = vData.getX();
                            y = vData.getY();
                            vData.setX(img1.getX());
                            vData.setY(img1.getY());
                            img1.setX(x);
                            img1.setY(y);
                        } else if (vData.getId() == R.id.img3) {
                            x = vData.getX();
                            y = vData.getY();

                            vData.setX(img1.getX());
                            vData.setY(img1.getY());
                            img1.setX(x);
                            img1.setY(y);
                        } else if (vData.getId() == R.id.img4) {
                            y = vData.getY();
                            x = vData.getX();
                            vData.setY(img1.getY());
                            vData.setX(img1.getX());
                            img1.setY(y);
                            img1.setX(x);

                        }

                        break;
                    }
            }

            return true;
        }
    };
    //endregion
//region listenering 2
    View.OnDragListener listenerimg2 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent event) {//Quand l'image 2 reçoit une action de drop
            int dragEvent = event.getAction();
            final View vData = (View) event.getLocalState();


            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:// si on entre dans l'image 1 fait un prévisualisation de sa place si on le drop
                    if (boolImg2 == false) {
                        if (vData.getId() == R.id.img1) {
                            x = vData.getX();
                            y = vData.getY();

                            vData.setX(img2.getX());
                            vData.setY(img2.getY());
                            img2.setX(x);
                            img2.setY(y);

                        } else if (vData.getId() == R.id.img3) {
                            x = vData.getX();
                            y = vData.getY();

                            vData.setX(img2.getX());
                            vData.setY(img2.getY());
                            img2.setX(x);
                            img2.setY(y);
                        } else if (vData.getId() == R.id.img4) {
                            y = vData.getY();
                            x = vData.getX();
                            vData.setY(img2.getY());
                            vData.setX(img2.getX());
                            img2.setY(y);
                            img2.setX(x);

                        }
                    }


                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    break;
                case DragEvent.ACTION_DROP:
                    if (boolImg2 == false) {
                        if (vData.getId() == R.id.img1) {
                            x = vData.getX();
                            y = vData.getY();
//
                            vData.setX(img2.getX());
                            vData.setY(img2.getY());
                            img2.setX(x);
                            img2.setY(y);

                        } else if (vData.getId() == R.id.img2) {
                            x = vData.getX();
                            y = vData.getY();
                            vData.setX(img2.getX());
                            vData.setY(img2.getY());
                            img2.setX(x);
                            img2.setY(y);
                        } else if (vData.getId() == R.id.img3) {
                            x = vData.getX();
                            y = vData.getY();

                            vData.setX(img2.getX());
                            vData.setY(img2.getY());
                            img2.setX(x);
                            img2.setY(y);
                        } else if (vData.getId() == R.id.img4) {
                            y = vData.getY();
                            x = vData.getX();
                            vData.setY(img2.getY());
                            vData.setX(img2.getX());
                            img2.setY(y);
                            img2.setX(x);

                        }

                    }


            }
            return true;
        }
    };
    //endregion
//region listenering 3
    View.OnDragListener listenerimg3 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent event) {//Quand l'image 3 reçoit une action de drop
            int dragEvent = event.getAction();
            final View vData = (View) event.getLocalState();


            switch (dragEvent) {

                case DragEvent.ACTION_DRAG_ENTERED: // si on entre dans l'image 1 fait un prévisualisation de sa place si on le drop
                    if (boolImg3 == false) {
                        if (vData.getId() == R.id.img1) {
                            x = vData.getX();
                            y = vData.getY();
//
                            vData.setX(img3.getX());
                            vData.setY(img3.getY());
                            img3.setX(x);
                            img3.setY(y);

                        } else if (vData.getId() == R.id.img2) {
                            x = vData.getX();
                            y = vData.getY();
                            vData.setX(img3.getX());
                            vData.setY(img3.getY());
                            img3.setX(x);
                            img3.setY(y);
                        } else if (vData.getId() == R.id.img4) {
                            y = vData.getY();
                            x = vData.getX();
                            vData.setY(img3.getY());
                            vData.setX(img3.getX());
                            img3.setY(y);
                            img3.setX(x);

                        }
                        break;
                    }

                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    break;
                case DragEvent.ACTION_DROP:
                    if (boolImg3 == false) {


                        if (vData.getId() == R.id.img1) {
                            x = vData.getX();
                            y = vData.getY();
//
                            vData.setX(img3.getX());
                            vData.setY(img3.getY());
                            img3.setX(x);
                            img3.setY(y);

                        } else if (vData.getId() == R.id.img2) {
                            x = vData.getX();
                            y = vData.getY();
                            vData.setX(img3.getX());
                            vData.setY(img3.getY());
                            img3.setX(x);
                            img3.setY(y);
                        } else if (vData.getId() == R.id.img3) {
                            x = vData.getX();
                            y = vData.getY();

                            vData.setX(img3.getX());
                            vData.setY(img3.getY());
                            img3.setX(x);
                            img3.setY(y);
                        } else if (vData.getId() == R.id.img4) {
                            y = vData.getY();
                            x = vData.getX();
                            vData.setY(img3.getY());
                            vData.setX(img3.getX());
                            img3.setY(y);
                            img3.setX(x);

                        }


                    }
            }
            return true;
        }
    };
    //endregion
//region listenering 4
    View.OnDragListener listenerimg4 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent event) {//Quand l'image 4 reçoit une action de drop
            int dragEvent = event.getAction();
            final View vData = (View) event.getLocalState();


            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED: // si on entre dans l'image 1 fait un prévisualisation de sa place si on le drop
                    if (boolImg4 == false) {
                        if (vData.getId() == R.id.img1) {
                            x = vData.getX();
                            y = vData.getY();
//
                            vData.setX(img4.getX());
                            vData.setY(img4.getY());
                            img4.setX(x);
                            img4.setY(y);

                        } else if (vData.getId() == R.id.img2) {
                            x = vData.getX();
                            y = vData.getY();
                            vData.setX(img4.getX());
                            vData.setY(img4.getY());
                            img4.setX(x);
                            img4.setY(y);
                        } else if (vData.getId() == R.id.img3) {
                            x = vData.getX();
                            y = vData.getY();

                            vData.setX(img4.getX());
                            vData.setY(img4.getY());
                            img4.setX(x);
                            img4.setY(y);
                        }
                        break;
                    }
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    break;
                case DragEvent.ACTION_DROP:
                    if (boolImg4 == false) {
                        if (vData.getId() == R.id.img1) {
                            x = vData.getX();
                            y = vData.getY();
//
                            vData.setX(img4.getX());
                            vData.setY(img4.getY());
                            img4.setX(x);
                            img4.setY(y);

                        } else if (vData.getId() == R.id.img2) {
                            x = vData.getX();
                            y = vData.getY();
                            vData.setX(img4.getX());
                            vData.setY(img4.getY());
                            img4.setX(x);
                            img4.setY(y);
                        } else if (vData.getId() == R.id.img3) {
                            x = vData.getX();
                            y = vData.getY();

                            vData.setX(img4.getX());
                            vData.setY(img4.getY());
                            img4.setX(x);
                            img4.setY(y);
                        } else if (vData.getId() == R.id.img4) {
                            y = vData.getY();
                            x = vData.getX();
                            vData.setY(img4.getY());
                            vData.setX(img4.getX());
                            img4.setY(y);
                            img4.setX(x);

                        }

                    }
            }
            return true;
        }
    };
    //endregion
//region click Listener
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            xImg1 = img1.getX();
            yImg1 = img1.getY();//prend position de l'image 1 à temps =0
            xImg2 = img2.getX();
            yImg2 = img2.getY();//prend position de l'image 2 à temps =0
            xImg3 = img3.getX();
            yImg3 = img3.getY();//prend position de l'image 3 à temps =0
            xImg4 = img4.getX();
            yImg4 = img4.getY();//prend position de l'image 4 à temps =0
            List<Float> listPosX = new ArrayList<Float>(); //fait une liste de tout les X des images
            listPosX.add(xImg1);
            listPosX.add(xImg2);
            listPosX.add(xImg3);
            listPosX.add(xImg4);

            List<Float> listPosY = new ArrayList<Float>(); // fait une liste de tout les Y des images
            listPosY.add(yImg1);
            listPosY.add(yImg2);
            listPosY.add(yImg3);
            listPosY.add(yImg4);


            List<Integer> spiderman = new ArrayList<Integer>();
            List<Integer> tintin = new ArrayList<Integer>();
            List<Integer> overwatch = new ArrayList<Integer>();
            List<Integer> onepiece = new ArrayList<Integer>();
            List<Integer> dbz = new ArrayList<Integer>();
            List<Integer> luckyluke = new ArrayList<Integer>();
            spiderman.add(R.mipmap.spider0);
            spiderman.add(R.mipmap.spider1);
            spiderman.add(R.mipmap.spider2);
            spiderman.add(R.mipmap.spider3);
            tintin.add(R.mipmap.tintin1);tintin.add(R.mipmap.tintin2);tintin.add(R.mipmap.tintin3);tintin.add(R.mipmap.tintin4);
            overwatch.add(R.mipmap.over1);overwatch.add(R.mipmap.over2);overwatch.add(R.mipmap.over3);overwatch.add(R.mipmap.over4);
            onepiece.add(R.mipmap.onepiece1);onepiece.add(R.mipmap.onepiece2);onepiece.add(R.mipmap.onepiece3);onepiece.add(R.mipmap.onepiece4);
            dbz.add(R.mipmap.dbz1);dbz.add(R.mipmap.dbz2);dbz.add(R.mipmap.dbz3);dbz.add(R.mipmap.dbz4);
            luckyluke.add(R.mipmap.luckyluke1);luckyluke.add(R.mipmap.luckyluke2);luckyluke.add(R.mipmap.luckyluke3);luckyluke.add(R.mipmap.luckyluke4);
            listImg = new ArrayList<List<Integer>>();
            listImg.add(spiderman);listImg.add(tintin);listImg.add(overwatch);listImg.add(onepiece);listImg.add(dbz);listImg.add(luckyluke);





            Random r = new Random();
            int i1 = r.nextInt(4);
            Random rand2 = new Random();
            Random rand3 = new Random();
            Random rand4 = new Random();
            int i2 = rand2.nextInt(4);
            int i3 = rand3.nextInt(4);
            int i4 = rand4.nextInt(4);
            int i1b = 0;
            int i2b = 1;
            int i3b = 2;
            int i4b = 3;


            while (i1 == i2 || i1 == i3 || i1 == i4 || i2 == i3 || i2 == i4 || i3 == i4 || i1 == i1b || i2 == i2b || i3 == i3b || i4 == i4b) { //si les 4 chiffres sont bien différents et que ça ne fait pas 1 2 3 4
                i1 = r.nextInt(4);
                i2 = rand2.nextInt(4);
                i3 = rand3.nextInt(4);
                i4 = rand4.nextInt(4);
            }
            // if(i1!=i2 && i1!=i3 && i1!=i4&&i2 !=i3 && i2!= i4 && i3!=i4 &&i1!=i1b && i2 != i2b && i3!=i3b &&i4!=i4b){

            i1b = i1;
            i2b = i2;
            i3b = i3;
            i4b = i4;
            img1.setY(listPosY.get(i1));
            img1.setX(listPosX.get(i1));//récupére une coordonnée x et y dans la liste de coordonnées
            img2.setY(listPosY.get(i2));
            img2.setX(listPosX.get(i2));
            img3.setY(listPosY.get(i3));
            img3.setX(listPosX.get(i3));
            img4.setY(listPosY.get(i4));
            img4.setX(listPosX.get(i4));
            txtView2.setText(i1 + " " + i2 + " " + i3 + " " + i4);

            img1.setImageResource(listImg.get(score).get(0));
            img2.setImageResource(listImg.get(score).get(1));
            img3.setImageResource(listImg.get(score).get(2));
            img4.setImageResource(listImg.get(score).get(3));

            rect1.setVisibility(View.INVISIBLE);
            rect2.setVisibility(View.INVISIBLE);
            rect3.setVisibility(View.INVISIBLE);
            rect4.setVisibility(View.INVISIBLE);
            boolImg1 = false;
            boolImg2 = false;
            boolImg3 = false;
            boolImg4 = false;
            img1.setLongClickable(true);
            img2.setLongClickable(true);
            img3.setLongClickable(true);
            img4.setLongClickable(true);


        }
        //}

    };
    //endregion
//region clickvalider
    View.OnClickListener clickListenerValider = new View.OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View v) {

            if (img1.getX() == xImg1 && img1.getY() == yImg1) {
                boolImg1 = true;
                img1.setLongClickable(false);

                rect1.setVisibility(View.VISIBLE);
            }

            if (img2.getX() == xImg2 && img2.getY() == yImg2) {

                rect2.setVisibility((View.VISIBLE));
                boolImg2 = true;
                img2.setLongClickable(false);
            }

            if (img3.getX() == xImg3 && img3.getY() == yImg3) {

                rect3.setVisibility((View.VISIBLE));
                boolImg3 = true;
                img3.setLongClickable(false);
            }

            if (img4.getX() == xImg4 && img4.getY() == yImg4) {

                rect4.setVisibility((View.VISIBLE));
                boolImg4 = true;
                img4.setLongClickable(false);
            }

            if (boolImg1 == true && boolImg2 == true && boolImg3 == true && boolImg4 == true) {
                txtView2.setText("Bravo t'as win gg a toi t le besta mon giga bro");
            }


        }
    };
    //endregion
    View.OnClickListener clickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            score=score+1;
        }

    };
private void lol(){

}
}








