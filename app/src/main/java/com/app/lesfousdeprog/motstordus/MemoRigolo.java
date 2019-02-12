package com.app.lesfousdeprog.motstordus;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.Objects;

public class MemoRigolo extends AppCompatActivity {

    //region propriétées
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
    private int tempscore;
    private int score;
    private ImageView imgFinPartie;
    private TextView txtFinPartie;
    private Button btnAgain;
    private Button btnHome;
    private int nextDif;
    private int code_fenetre = 54;
    private ArrayList<Integer> imgClicker;
    private LottieAnimationView trophy;
    private int compteClick;
    private UtilisateurBdd userbdd;
    private Utilisateur utilisateur;
    //endregion



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_rigolo);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE); //autorise seulement la rotation horizontal
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //met l'application en plein écran

        //region initialisation de certaines propriétées
        imgClicker = new ArrayList<>();
        imageViews = new ArrayList<>();
        idImageView = new ArrayList<>();
        gridImage = this.findViewById(R.id.gridView);
        trophy = this.findViewById(R.id.stars);
        imgFinPartie = this.findViewById(R.id.finpartie);
        txtFinPartie = this.findViewById(R.id.txtfinpartie);
        btnAgain = this.findViewById(R.id.btn_suiv);
        btnHome = this.findViewById(R.id.btn_acc);
        //endregion

        userbdd = new UtilisateurBdd(this);
        final Utilisateur utilisateur = (Utilisateur) this.getIntent().getExtras().getSerializable("user");
        compteClick = 8; //met le compteur de click à 0
        utilisateur.setScoreMemo(compteClick); //met a jour le score de l'utilisateur dans la base
        userbdd.updateUser(utilisateur); //met a jour le score de l'utilisateur dans la base

        btnAgain.setOnClickListener(new View.OnClickListener(){ //au click sur le bouton niveau suivant
            public void onClick(View v) {
                MemoRigolo.this.finish(); //ferme l'instance actuelle
                Intent unIntent = new Intent(MemoRigolo.this, MemoRigolo.class); //prépare une nouvelle instance du jeu mémo
                unIntent.putExtra("dif", nextDif); //ajoute un paramètre
                startActivity(unIntent); //démarre la nouvelle instance
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener(){ //au click sur le bouton menu
            public void onClick(View v) {
                Intent unIntent = new Intent(MemoRigolo.this, Accueil.class); //prépare une nouvelle instance de l'application
                MemoRigolo.this.startActivityForResult(unIntent, code_fenetre); //démarre la nouvelle instance
            }
        });

        setImage(); //permet la gestion des images du jeu mémo
    }

    public void setImage(){
        difficulte = Objects.requireNonNull(this.getIntent().getExtras()).getInt("dif"); //change la difficultée du jeu
        score =0; //met le score à 0
        tempscore = difficulte; //tempscore prend la valeur de difficulté
        tempDifficulte = (difficulte/2)-1; //tempdifficulté prend la valeur de difficulté / 2 et enlève 1
        ArrayList<Integer> nbAlea = new ArrayList<>(); //initialise une arraylist de type Integer

        final Integer[] listImage = new Integer[]{ //liste des images du jeu
                R.mipmap.batman,
                R.mipmap.captain_america,
                R.mipmap.captain_marvel,
                R.mipmap.naruto,
                R.mipmap.schtroumpf,
                R.mipmap.son_goku,
                R.mipmap.tintin,
                R.mipmap.wonder_woman
        };

        if(difficulte == 8){ //si la difficulté est de 8
            GridView dataGrid = findViewById(R.id.gridView);
            dataGrid.setColumnWidth(450); //change la largeur du datagrid à 450
            dataGrid.requestLayout();
        }
        else if(difficulte == 12){ //si la difficulté est de 12
            GridView dataGrid = findViewById(R.id.gridView);
            dataGrid.setColumnWidth(325); //change la largeur du datagrid à 325
            dataGrid.requestLayout();
        }
        else if(difficulte == 14){ //si la difficulté est de 14
            GridView dataGrid = findViewById(R.id.gridView);
            dataGrid.setColumnWidth(300); //change la largeur du datagrid à 300
            dataGrid.requestLayout();
        }

        while(tempDifficulte > -1){ //tant que tempdifficulte est égale à 0 ou plus
            //ajoute le numéro de la difficulté à la liste nbAlea
            nbAlea.add(tempDifficulte);
            nbAlea.add(tempDifficulte);
            tempDifficulte --; //enlève 1 à tempdifficulté
        }

        difficulte-=1; //enlève 1 à la difficulté

        while (difficulte > -1){ //tant que la difficulté est égale à 0 ou plus
            int alea = (int) (nbAlea.size() * Math.random()); //alea prend une valeur au hasard suivant la taille de la liste nbAlea
            ImageView iv = new ImageView(this); //initialise une imageView temporaire
            iv.setImageResource(listImage[nbAlea.get(alea)]); //affecte une image à iv de la liste d'image à la position alea de la liste nbAlea
            iv.setId(difficulte); //affecte une id à l'image (difficulté)
            iv.setTag(listImage[nbAlea.get(alea)]); //affecte un tag à l'image (le nombre à la position alea de la liste nbAlea

            imageViews.add(iv); //ajoute à la liste imageViews l'image iv
            idImageView.add(listImage[nbAlea.get(alea)]); //ajoute à la liste idImageViews l'id de l'image de la liste listeImage à la position alea de la liste nbAlea
            difficulte --; //enleve 1 à la difficulté
            nbAlea.remove(alea); // supprime le nombre de la liste nbAlea à la position alea
        }

        GridAdapter adapter = new GridAdapter(MemoRigolo.this, idImageView); //initialise un GridAdapter
        gridImage.setAdapter(adapter); //affecte à gridImage un adapter (adapter)
        gridImage.setOnItemClickListener(new AdapterView.OnItemClickListener() { //au click sur une image du gridAdapter
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, long id) {
                boolean etat = false; //initialise une variable local etat à la valeur false
                compteClick++; //incrémente le compteur de click +1

                if(imgClicker.size() == 0){ //si la liste imgClicker est vide
                    etat = true; //etat prend la valeur true
                }
                else { //sinon
                    for (Integer inte : imgClicker) //pour chaque nombre présent dans la liste imgClicker
                     {
                        if(position == inte) { //si la position de l'image clicker est égale au nombre de la liste imgClicker
                            etat = false; //etat prend la valeur false
                            break; //sort de la boucle
                        }
                        else {etat = true;} //sinon etat prend la valeur true
                     }
                }

                if(etat){ //si etat est à la valeur true
                    view.setBackgroundResource(idImageView.get(position)); //change l'image de l'image clicker par l'image de la liste idImageView à la position de l'image clicker
                    click ++; //incrémente le click de 1
                    if(click ==1){ //si le click est égale à 1
                        choiceImage1 = idImageView.get(position); //affecte à choiceimage1 l'id de l'image clicker
                        view1 = view; //Affecte à view1 la view clicker
                        position1 = position; //affecte à position1 la position de l'image clicker
                    }else if(click == 2){ //si le click est égale à 2
                        choiceImage2 = idImageView.get(position); //affecte à choiceimage2 l'id de l'image clicker
                        view2 = view; //Affecte à view2 la view clicker
                        position2 = position; //affecte à position2 la position de l'image clicker
                    }

                    if(click == 2){ //si le click est égale à 2
                        handler.postDelayed(new Runnable() { //lance un délai
                            @SuppressLint("SetTextI18n")
                            public void run() {
                                if(choiceImage1 != choiceImage2){ //si l'image 1 est l'image 2 sont différentes
                                    gridImage.getAdapter().getView(position1, view1, parent).setBackgroundResource(R.mipmap.pow); //remet l'image par défaut
                                    gridImage.getAdapter().getView(position2, view2, parent).setBackgroundResource(R.mipmap.pow); //remet l'image par défaut
                                }
                                else{ //sinon
                                    imgClicker.add(position1); //ajoute à la liste imgClicker l'image à la position1
                                    imgClicker.add(position2); //ajoute à la liste imgClicker l'image à la position2
                                    score++; //incrémente le score de 1
                                    if(tempscore/2 == score){ //si tempscore/2 est égale à score (si le joueur a gagné)
                                        txtFinPartie.setText("Gagné en "+ compteClick + " coups ! "); //modifie le text de victoire avec le score
                                        imgFinPartie.setVisibility(View.VISIBLE); //affiche l'image de victoire
                                        txtFinPartie.setVisibility(View.VISIBLE); //affiche le text de victoire
                                        trophy.setVisibility(View.VISIBLE); //affiche le trophé
                                        trophy.playAnimation(); //lance l'animation du trophé
                                        trophy.loop(true); //lance l'animation du trophé en boucle

                                        utilisateur.setScoreMemo(compteClick); //met a jour le score de l'utilisateur dans la base
                                        userbdd.updateUser(utilisateur); //met a jour le score de l'utilisateur dans la base

                                        if(tempscore == 8){ //si tempscore est égale à 8
                                            btnAgain.setVisibility(View.VISIBLE); //affiche le bouton niveau suivant
                                            nextDif = 12; //affecte à nextDiff la valeur 12 pour la prochaine difficulté
                                        }
                                        else if(tempscore == 12){ //si tempscore est égale à 12
                                            //btnAgain.setVisibility(View.VISIBLE); //affiche le bouton niveau suivant
                                            nextDif = 14; //affecte à nextDiff la valeur 14 pour la prochaine difficulté
                                        }

                                        btnHome.setVisibility(View.VISIBLE); //affiche le bouton menu
                                    }
                                }
                                click = 0; //click prend la valeur 0
                            }}, 500);
                    }
                }
            }
        });
    }
}
