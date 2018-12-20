package com.app.lesfousdeprog.motstordus;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.StringRes;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RangeTaBd extends AppCompatActivity {

    ImageView img1, img2, img3, img4, imgFond,imglayoutdef,imglayoutvic,imgRegle;
    Button valider, lancer,suivant,btn_layoutvic,btn_layoutdef,btnlayoutdefrecommencer,btn_regles;
    LinearLayout rect1, rect2, rect3, rect4;
    TextView txtviewlayoutvic,txtviewlayoutdef,txtRegles;
    RelativeLayout layoutdef,layoutvic,layoutLancer,layoutRegles;
    ObjectAnimator  ObjectAnimator,ObjectAnimator2,ObjectAnimator3,ObjectAnimator4,ObjectAnimator5,AnimatorRegle1,AnimatorRegle2,AnimatorRegle3,AnimatorRegle4,AnimatorRegle5;
    private int vie=2;
    private int clicsurregles =1;
    private boolean boolImg1 = false;
    private boolean boolImg2 = false;
    private boolean boolImg3 = false;
    private boolean boolImg4 = false;
    ConstraintLayout layout;
    LottieAnimationView etoile1,etoile2,etoile3,trophe,confetti,coeurgauche,coeurdroit;
    Handler handler = new Handler();

    private int nombreFautes=0;
    float y;
    float x;
    private float xImg1, xImg2, xImg3, xImg4;
    private float yImg1, yImg2, yImg3, yImg4;
    private List<Float> listPosX;
    private List<Float> listPosY;
    private List<Integer> spiderman;
    private List<List<Integer>> listImg;
    public int listNum=0;
    private boolean erreurPrecedent;
    @SuppressLint("ClickableViewAccessibility")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_ta_bd);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//mode horizontale
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //met en fullscreen l'app
        layout = (ConstraintLayout) findViewById(R.id.layoutid);
        img1 = (ImageView) findViewById(R.id.img1); // initialise une variable img1 de type imageview et dont l'id dans le fichier xml est img1
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        imgRegle = (ImageView) findViewById(R.id.imgbulle);
        layoutLancer = (RelativeLayout) findViewById(R.id.layoutLancer);
        layoutRegles = (RelativeLayout) findViewById(R.id.regleLayout);
        imglayoutdef = (ImageView) findViewById(R.id.imglayoutdef);
        imglayoutvic = (ImageView) findViewById(R.id.imglayoutvic);
        txtviewlayoutvic= (TextView) findViewById(R.id.txtviewlayoutvic);
        txtviewlayoutdef= (TextView) findViewById(R.id.txtviewlayoutdef);
        txtRegles= (TextView) findViewById(R.id.txtregle);
        imgFond = (ImageView) findViewById(R.id.imgfondblancgris);
        etoile1 = (LottieAnimationView) findViewById(R.id.etoile1);
        etoile2 = (LottieAnimationView) findViewById(R.id.etoile2);
        etoile3 = (LottieAnimationView) findViewById(R.id.etoile3);
        trophe = (LottieAnimationView) findViewById(R.id.trophy);
        confetti = (LottieAnimationView) findViewById(R.id.confetti);
        coeurgauche = (LottieAnimationView) findViewById(R.id.coeur);
        coeurdroit = (LottieAnimationView) findViewById(R.id.coeur2);
        rect1 = (LinearLayout) findViewById(R.id.rect1);
        rect2 = (LinearLayout) findViewById(R.id.rect2);
        rect3 = (LinearLayout) findViewById(R.id.rect3);
        rect4 = (LinearLayout) findViewById(R.id.rect4);
        layoutdef = (RelativeLayout) findViewById(R.id.layoutdef);
        layoutvic = (RelativeLayout) findViewById(R.id.layoutvic);
        valider = (Button) findViewById(R.id.btn_valider);
        lancer = (Button) findViewById(R.id.btn_lancer);
        suivant = (Button) findViewById(R.id.btn_suivant);
        btn_layoutvic = (Button) findViewById(R.id.btnlayoutvic);
        btn_layoutdef = (Button) findViewById(R.id.btnlayoutdef);
        btn_regles = (Button) findViewById(R.id.btn_regles);
        btnlayoutdefrecommencer = (Button) findViewById(R.id.btnlayoutdefrecommencer);
        btn_regles = (Button) findViewById(R.id.btn_regles);
        img1.setOnTouchListener(onTouchListener);
        img2.setOnTouchListener(onTouchListener);
        img3.setOnTouchListener(onTouchListener);
        img4.setOnTouchListener(onTouchListener);
        lancer.setOnClickListener(lancerApp);
        valider.setOnClickListener(clickListenerValider);
        suivant.setOnClickListener(lancerApp);
        btn_regles.setOnClickListener(regles);
        btnlayoutdefrecommencer.setOnClickListener(relancerApp);
        valider.setVisibility(View.INVISIBLE);
        img1.setOnDragListener(listenerimg1);
        img2.setOnDragListener(listenerimg2);
        img3.setOnDragListener(listenerimg3);
        img4.setOnDragListener(listenerimg4);
        suivant.setVisibility(View.INVISIBLE);
        disableLayout(true); // disable la possibilité de bouger les images
        layoutLancer.setEnabled(true); // permet d'activer la possibilité de cliquer sur le bouton
        ObjectAnimator = ObjectAnimator.ofFloat(layout,"x",-50);
        ObjectAnimator2 = ObjectAnimator2.ofFloat(layout,"x",+176);//+126 pour rev
        ObjectAnimator3 = ObjectAnimator3.ofFloat(layout,"x",-50);
        ObjectAnimator4 = ObjectAnimator4.ofFloat(layout,"x",+176);
        ObjectAnimator5 = ObjectAnimator5.ofFloat(layout,"x",-0);//+128
        erreurPrecedent = false;
        txtRegles.setText(R.string.Règles0);
    }

//region onclicklistener

  View.OnTouchListener onTouchListener = new View.OnTouchListener(){

      @Override
      public boolean onTouch(View view, MotionEvent motionEvent) {
          ClipData data = ClipData.newPlainText("", "");
          View.DragShadowBuilder myShadow = new View.DragShadowBuilder(view);
          view.startDragAndDrop(data, myShadow, view, 0); // crée l'ombre de l'image quand click
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
                    if (boolImg1 == false) { // si il n'est pas validé
                        if (vData.getId() == R.id.img2) { // si c'est l'img 2 qui entre dans la 1
                            if (boolImg2==false) {

                                x = vData.getX();
                                y = vData.getY();
                                vData.setX(img1.getX());
                                vData.setY(img1.getY());
                                img1.setX(x);
                                img1.setY(y);
                            }
                        }
                        else if (vData.getId() == R.id.img3) {
                            if (boolImg3==false){
                                x = vData.getX();
                                y = vData.getY();

                                vData.setX(img1.getX());
                                vData.setY(img1.getY());
                                img1.setX(x);
                                img1.setY(y);}

                        }
                        else if (vData.getId() == R.id.img4) {
                            if (boolImg4==false) {
                                y = vData.getY();
                                x = vData.getX();
                                vData.setY(img1.getY());
                                vData.setX(img1.getX());
                                img1.setY(y);
                                img1.setX(x);
                            }

                        }
                        else if (vData.getId() == R.id.img1) {

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
                        /*if (vData.getId() == R.id.img1) { // si l'image drag est l'img 1
                            x = vData.getX(); // prend le x de l'image drag
                            y = vData.getY(); // prend le y
//
                            vData.setX(img1.getX());
                            vData.setY(img1.getY()); // envoie l'image drag dans la pos de l'img1
                            img1.setX(x);
                            img1.setY(y); // envoie l'img 1 sur la pos de l'img drop

                        }*/
                        if (vData.getId() == R.id.img2) {
                            if (boolImg3==false) {
                                x = vData.getX();
                                y = vData.getY();
                                vData.setX(img1.getX());
                                vData.setY(img1.getY());
                                img1.setX(x);
                                img1.setY(y);
                            }

                        } else if (vData.getId() == R.id.img3) {
                            if (boolImg3==false) {

                                x = vData.getX();
                                y = vData.getY();

                                vData.setX(img1.getX());
                                vData.setY(img1.getY());
                                img1.setX(x);
                                img1.setY(y);
                            }
                        } else if (vData.getId() == R.id.img4) {
                            if (boolImg4==false) {

                                y = vData.getY();
                                x = vData.getX();
                                vData.setY(img1.getY());
                                vData.setX(img1.getX());
                                img1.setY(y);
                                img1.setX(x);
                            }
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
                                if(boolImg1==false){
                            x = vData.getX();
                            y = vData.getY();

                            vData.setX(img2.getX());
                            vData.setY(img2.getY());
                            img2.setX(x);
                            img2.setY(y);}


                        } else if (vData.getId() == R.id.img3) {
                                if (boolImg3==false) {
                                    x = vData.getX();
                                    y = vData.getY();

                                    vData.setX(img2.getX());
                                    vData.setY(img2.getY());
                                    img2.setX(x);
                                    img2.setY(y);
                                }
                        } else if (vData.getId() == R.id.img4) {
                                if (boolImg4==false) {
                                    y = vData.getY();
                                    x = vData.getX();
                                    vData.setY(img2.getY());
                                    vData.setX(img2.getX());
                                    img2.setY(y);
                                    img2.setX(x);
                                }
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
                            if(boolImg1==false) {
                                x = vData.getX();
                                y = vData.getY();
//
                                vData.setX(img2.getX());
                                vData.setY(img2.getY());
                                img2.setX(x);
                                img2.setY(y);
                            }
                        } else if (vData.getId() == R.id.img2) {
                            if (boolImg2==false) {
                                x = vData.getX();
                                y = vData.getY();
                                vData.setX(img2.getX());
                                vData.setY(img2.getY());
                                img2.setX(x);
                                img2.setY(y);
                            }
                        } else if (vData.getId() == R.id.img3) {
                            if (boolImg3==false) {

                                x = vData.getX();
                                y = vData.getY();

                                vData.setX(img2.getX());
                                vData.setY(img2.getY());
                                img2.setX(x);
                                img2.setY(y);
                            }

                        } else if (vData.getId() == R.id.img4) {
                            if (boolImg4==false){
                               y = vData.getY();
                               x = vData.getX();
                               vData.setY(img2.getY());
                               vData.setX(img2.getX());
                               img2.setY(y);
                               img2.setX(x);}

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
                            if (boolImg1==false){
                            x = vData.getX();
                            y = vData.getY();
//
                            vData.setX(img3.getX());
                            vData.setY(img3.getY());
                            img3.setX(x);
                            img3.setY(y);}

                        } else if (vData.getId() == R.id.img2) {
                            if (boolImg2==false){
                                x = vData.getX();
                                y = vData.getY();
                                vData.setX(img3.getX());
                                vData.setY(img3.getY());
                                img3.setX(x);
                                img3.setY(y);}

                        } else if (vData.getId() == R.id.img4) {
                                if (boolImg4==false) {
                                    y = vData.getY();
                                    x = vData.getX();
                                    vData.setY(img3.getY());
                                    vData.setX(img3.getX());
                                    img3.setY(y);
                                    img3.setX(x);
                                }
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
                            if (boolImg1==false){
                                x = vData.getX();
                                y = vData.getY();
//
                                vData.setX(img3.getX());
                                vData.setY(img3.getY());
                                img3.setX(x);
                                img3.setY(y);}

                        } else if (vData.getId() == R.id.img2) {
                            if (boolImg2==false) {
                                x = vData.getX();
                                y = vData.getY();
                                vData.setX(img3.getX());
                                vData.setY(img3.getY());
                                img3.setX(x);
                                img3.setY(y);
                            }
                        } else if (vData.getId() == R.id.img3) {
                            if (boolImg3==false) {
                                x = vData.getX();
                                y = vData.getY();

                                vData.setX(img3.getX());
                                vData.setY(img3.getY());
                                img3.setX(x);
                                img3.setY(y);
                            }
                        } else if (vData.getId() == R.id.img4) {
                            if (boolImg4==false) {
                                y = vData.getY();
                                x = vData.getX();
                                vData.setY(img3.getY());
                                vData.setX(img3.getX());
                                img3.setY(y);
                                img3.setX(x);
                            }
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
                            if (boolImg1==false) {
                                x = vData.getX();
                                y = vData.getY();
//
                                vData.setX(img4.getX());
                                vData.setY(img4.getY());
                                img4.setX(x);
                                img4.setY(y);
                            }
                        } else if (vData.getId() == R.id.img2) {
                            if (boolImg2==false) {
                                x = vData.getX();
                                y = vData.getY();
                                vData.setX(img4.getX());
                                vData.setY(img4.getY());
                                img4.setX(x);
                                img4.setY(y);
                            }
                        } else if (vData.getId() == R.id.img3) {
                            if (boolImg3==false){
                            x = vData.getX();
                            y = vData.getY();

                            vData.setX(img4.getX());
                            vData.setY(img4.getY());
                            img4.setX(x);
                            img4.setY(y);
                        }}
                        break;
                    }
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    break;
                case DragEvent.ACTION_DROP:
                    if (boolImg4 == false) {
                        if (vData.getId() == R.id.img1) {
                            if (boolImg1==false) {
                                x = vData.getX();
                                y = vData.getY();
//
                                vData.setX(img4.getX());
                                vData.setY(img4.getY());
                                img4.setX(x);
                                img4.setY(y);
                            }
                        } else if (vData.getId() == R.id.img2) {
                            if (boolImg2==false) {
                                x = vData.getX();
                                y = vData.getY();
                                vData.setX(img4.getX());
                                vData.setY(img4.getY());
                                img4.setX(x);
                                img4.setY(y);
                            }
                        } else if (vData.getId() == R.id.img3) {
                            if (boolImg3==false) {
                                x = vData.getX();
                                y = vData.getY();

                                vData.setX(img4.getX());
                                vData.setY(img4.getY());
                                img4.setX(x);
                                img4.setY(y);
                            }
                        } else if (vData.getId() == R.id.img4) {
                            if (boolImg4==false) {
                                y = vData.getY();
                                x = vData.getX();
                                vData.setY(img4.getY());
                                vData.setX(img4.getX());
                                img4.setY(y);
                                img4.setX(x);
                            }
                        }

                    }
            }
            return true;
        }
    };
    //endregion
//region click Listener

    View.OnClickListener lancerApp = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            vie=2;
            vie();

            suivant.setClickable(true);
            rect1.setBackgroundColor(Color.parseColor("#008000"));
            rect3.setBackgroundColor(Color.parseColor("#008000"));
            layoutRegles.setVisibility(View.INVISIBLE);
            valider.setClickable(true);
            disableLayout(false);
            valider.setVisibility(View.VISIBLE);
            lancer.setVisibility(View.INVISIBLE);
            suivant.setVisibility(View.INVISIBLE);
            btn_regles.setVisibility(View.INVISIBLE);

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

            img1.setImageResource(listImg.get(listNum).get(0));
            img2.setImageResource(listImg.get(listNum).get(1));
            img3.setImageResource(listImg.get(listNum).get(2));
            img4.setImageResource(listImg.get(listNum).get(3));

            rect1.setVisibility(View.INVISIBLE);
            rect2.setVisibility(View.INVISIBLE);
            rect3.setVisibility(View.INVISIBLE);
            rect4.setVisibility(View.INVISIBLE);
            boolImg1 = false;
            boolImg2 = false;
            boolImg3 = false;
            boolImg4 = false;
            img1.setFocusable(true);
            img2.setClickable(false);
            img3.setClickable(true);
            img4.setClickable(true);


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
                rect1.setVisibility(View.VISIBLE);
            }

            if (img2.getX() == xImg2 && img2.getY() == yImg2) {

                rect2.setVisibility((View.VISIBLE));
                boolImg2 = true;

            }

            if (img3.getX() == xImg3 && img3.getY() == yImg3) {

                rect3.setVisibility((View.VISIBLE));


                boolImg3 = true;

            }

            if (img4.getX() == xImg4 && img4.getY() == yImg4) {

                rect4.setVisibility((View.VISIBLE));
                boolImg4 = true;


            }

            if (boolImg1 && boolImg2 && boolImg3 && boolImg4) {
                suivant.setVisibility(View.VISIBLE);
                vie=2;
                vie();
                if (listNum<6) {
                    ajouterNumListe();
                }
                if(listNum==6){
                    suivant.setVisibility(View.INVISIBLE);

                    Runnable runnable = new Runnable() {
                        public void run() {
                            layoutvic.setVisibility(View.VISIBLE);
                            confetti.playAnimation();
                            confetti.loop(true);
                            nbEtoile();
                        }
                    };
                    handler.postDelayed(runnable, 1000);
                    disableLayout(true);




                }

            }
            else{
                vie=vie-1;
                nombreFautes=nombreFautes+1;
                vie();




            }


        }
    };
    //endregion
//region clicRecommencer quand on a perdu
    View.OnClickListener relancerApp = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(RangeTaBd.this, RangeTaBd.class));
        }};

//endregion
    public void ajouterNumListe(){
        listNum=listNum+1;

    }
    public void vie(){
        if (vie==2){
if (erreurPrecedent==true) {
    coeurgauche.resumeReverseAnimation(); // inverse l'animation
    erreurPrecedent=false;
}
        }
        if(vie==1) {
            erreurPrecedent=true;
    coeurgauche.playAnimation();
   mauvaiserep();
        }
        if(vie==0) {

            txtviewlayoutdef.setText("Tocard");
            coeurdroit.playAnimation();
            Runnable runnable = new Runnable() {
                public void run() {

                    layoutdef.setVisibility(View.VISIBLE);
                    Animation animation=AnimationUtils.loadAnimation(layoutdef.getContext(),R.anim.fadein);
                    layoutdef.startAnimation(animation);


                }
            };
            handler.postDelayed(runnable, 0);
            disableLayout(true);

        }}
    public void nbEtoile(){
        if (nombreFautes<=1) {
            Runnable apresAfficheFenetre = new Runnable() {
                public void run() {
                    txtviewlayoutvic.setText("T'es le boss enfaite");
                }
            };
            handler.postDelayed(apresAfficheFenetre, 1500);
            Runnable apconfetti = new Runnable() {
                public void run() {
                    etoile1.playAnimation();
                }};
            handler.postDelayed(apconfetti, confetti.getDuration()+1500);

            Runnable apetoile1 = new Runnable() {
                public void run() {
                    etoile2.playAnimation();
                }};
            handler.postDelayed(apetoile1, etoile1.getDuration()+confetti.getDuration()+1500);
            Runnable apetoile2 = new Runnable() {
                public void run() {
                    etoile3.playAnimation();
                }};
            handler.postDelayed(apetoile2, etoile2.getDuration()+etoile1.getDuration()+confetti.getDuration()+1500);
            Runnable apetoile3 = new Runnable() {
                public void run() {
                    trophe.playAnimation();
                }};
            handler.postDelayed(apetoile3, etoile2.getDuration()+etoile1.getDuration()+confetti.getDuration()+1500+etoile3.getDuration());
        }

        if (nombreFautes==2 || nombreFautes==3){
            Runnable apresAfficheFenetre = new Runnable() {
                public void run() {
            etoile1.playAnimation();

            txtviewlayoutvic.setText("T'es moyen enfaite");}};
            handler.postDelayed(apresAfficheFenetre, 1500);

            Runnable apetoile1 = new Runnable() {
                public void run() {
                    etoile2.playAnimation();
                }};
            handler.postDelayed(apetoile1, etoile1.getDuration()+1500);
            }

         if (nombreFautes>3){
             Runnable runnable = new Runnable() {
                 public void run() {
             etoile1.playAnimation();}};
             handler.postDelayed(runnable, 1500);
             txtviewlayoutvic.setText("T'es naze enfaite");
            }
        }
    private void disableLayout(boolean lay){// permet de "désactiver" ou non la possibilité d'utiliser le layout de jeu

        if (lay){
            for (int i = 0; i < layout.getChildCount(); i++) {
                View child = layout.getChildAt(i);
                child.setEnabled(false);}}
        else{for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            child.setEnabled(true);}}

        }
//region régles
        View.OnClickListener regles = new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                layoutRegles.setVisibility(View.VISIBLE);
                lancer.setVisibility(View.INVISIBLE);
                btn_regles.setText("RÉGLE SUIVANTE");
                    if(clicsurregles==0) {
                        txtRegles.setText(R.string.Règles0);
                        btn_regles.setTextSize(25);

                    }
                    if (clicsurregles==1){
                        txtRegles.setText(R.string.Règles1);
                        AnimatorRegle1 = AnimatorRegle1.ofFloat(layoutRegles,"x",+rect1.getWidth());
                        AnimatorRegle1.setDuration(500);
                        rect1.setBackgroundColor(Color.parseColor("#ff9933"));
                        rect1.setVisibility(View.VISIBLE);
                        AnimatorRegle1.start();
                    }
                    if (clicsurregles==2){
                        txtRegles.setText(R.string.Règles2);
                        AnimatorRegle1 = AnimatorRegle1.ofFloat(layoutRegles,"x",-0);
                        AnimatorRegle2 = AnimatorRegle2.ofFloat(layoutRegles,"y",+150);
                        AnimatorRegle1.setDuration(500);
                        rect2.setBackgroundColor(Color.parseColor("#ff9933"));
                        rect2.setVisibility(View.VISIBLE);
                        rect1.setVisibility(View.INVISIBLE);
                        AnimatorRegle1.start();
                        AnimatorRegle2.start();
                    }
                    if (clicsurregles==3){
                        txtRegles.setText(R.string.Règles3);
                        AnimatorRegle1 = AnimatorRegle1.ofFloat(layoutRegles,"x",+800);
                        rect2.setVisibility(View.INVISIBLE);
                        rect3.setBackgroundColor(Color.parseColor("#ff9933"));
                        rect3.setVisibility(View.VISIBLE);
                        AnimatorRegle1.start();
                    }
                    if (clicsurregles==4){
                        txtRegles.setText(R.string.Règles4);
                        AnimatorRegle1 = AnimatorRegle1.ofFloat(layoutRegles,"x",-0);
                        rect3.setVisibility(View.INVISIBLE);
                        rect4.setBackgroundColor(Color.parseColor("#ff9933"));
                        rect4.setVisibility(View.VISIBLE);
                        AnimatorRegle1.start();
                    }
                    if(clicsurregles==5){
                        txtRegles.setText(R.string.Règles5);
                        rect4.setVisibility(View.INVISIBLE);
                        AnimatorRegle1 = AnimatorRegle1.ofFloat(layoutRegles,"x",+500);
                        AnimatorRegle2 = AnimatorRegle2.ofFloat(layoutRegles,"y",+300);
                        AnimatorRegle1.start();
                       AnimatorRegle2.start();
                       valider.setVisibility(View.VISIBLE);
                       valider.setEnabled(true);
                       valider.setClickable(false);
                        blinkAnim(valider);


                    }
                if(clicsurregles==6){
                    txtRegles.setText(R.string.Règles6);
            valider.clearAnimation();
             blinkAnim(coeurgauche);
             blinkAnim(coeurdroit);


                }
                if(clicsurregles==7){
                    txtRegles.setText(R.string.Règles7);
                   coeurgauche.playAnimation();

                }
                if(clicsurregles==9){
                    txtRegles.setText(R.string.Règles8);
                    coeurdroit.clearAnimation();
                    coeurgauche.clearAnimation();
                   mauvaiserep();

                }
                if(clicsurregles==8){
                    txtRegles.setText(R.string.Règles9);
                    AnimatorRegle1 = AnimatorRegle1.ofFloat(layoutRegles,"x",-0);
                    AnimatorRegle1.start();
                    rect2.setBackgroundColor(Color.parseColor("#008000"));
                    rect4.setBackgroundColor(Color.parseColor("#008000"));
                    rect2.setVisibility(View.VISIBLE);
                    rect4.setVisibility(View.VISIBLE);

                }
                if(clicsurregles==10){
                    txtRegles.setText(R.string.Règles10);
                    AnimatorRegle1 = AnimatorRegle1.ofFloat(layoutRegles,"x",+500);
                    AnimatorRegle2 = AnimatorRegle2.ofFloat(layoutRegles,"y",+300);
                    AnimatorRegle1.start();
                    AnimatorRegle2.start();
                    rect2.setVisibility(View.INVISIBLE);
                    rect4.setVisibility(View.INVISIBLE);
                    suivant.setVisibility(View.VISIBLE);
                    suivant.setEnabled(true);
                    suivant.setClickable(false);
                    blinkAnim(suivant);
                    valider.setVisibility(View.INVISIBLE);
                }
                if(clicsurregles>=11){
                    txtRegles.setText(R.string.Règles11);
                  suivant.clearAnimation();
                  suivant.setVisibility(View.INVISIBLE);
                  btn_regles.setVisibility(View.INVISIBLE);
                  lancer.setText("JOUER");
                  lancer.setVisibility(View.VISIBLE);
                    coeurgauche.reverseAnimation();
                    coeurdroit.reverseAnimation();

                }
                    clicsurregles=clicsurregles+1;
                }
//endregion

            };
    private void blinkAnim(View element){
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(400); //You can manage the time of the blink with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        element.startAnimation(anim);
    }
private void mauvaiserep(){
    ObjectAnimator.setDuration(150);
    ObjectAnimator2.setDuration(150);
    ObjectAnimator3.setDuration(150);
    ObjectAnimator4.setDuration(150);
    ObjectAnimator5.setDuration(150);
    ObjectAnimator.start();

    Runnable lol = new Runnable() {
        public void run() {
            ObjectAnimator2.start();}

    };
    handler.postDelayed(lol, 150);

    Runnable lol2 = new Runnable() {
        public void run() {
            ObjectAnimator3.start();}

    };
    handler.postDelayed(lol2, 300);
    Runnable lol3 = new Runnable() {
        public void run() {
            ObjectAnimator4.start();}

    };
    handler.postDelayed(lol3, 450);
    Runnable lol4 = new Runnable() {
        public void run() {
            ObjectAnimator5.start();
        }

    };
    handler.postDelayed(lol4, 600);

}
    }











