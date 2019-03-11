package com.app.lesfousdeprog.motstordus;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.PriorityQueue;

public class Quizz extends AppCompatActivity {

    //region propriétés
    //déclarations des propriétés
   private Button btn_manga;
    private Button btn_bd;
    private Button btn_comics;
    private Button btn_retour;
    private EditText editpseudo;
    private boolean pseudoValable=true;
    private RelativeLayout msgErreur;
    private Button btn_ok;
    private final int code_fenetre = 20;
private String pseudo;
    //private UtilisateurBdd m;
   private  UtilisateurBdd m = new UtilisateurBdd(this);
private Utilisateur salut;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);//permet de bloquer l'orientation de la tablette en mode paysage

        //permet de mettre l'application en plein écran pour ne pas avoir de bandeau en haut de l'écran de tablette
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        editpseudo = this.findViewById(R.id.edittxtpseudo);
        msgErreur = this.findViewById(R.id.msgErreurLayout);
        btn_ok = this.findViewById(R.id.btn_ok);


        btn_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                msgErreur.setVisibility(View.INVISIBLE);
            }
        });
        //le bouton btn_manga permet de lancer le quiz de manga
        btn_manga = (Button) this.findViewById(R.id.btn_manga);

        btn_manga.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                if (verifPseudo()==true) {
                    Intent unIntent = new Intent(Quizz.this, QuizzManga.class);
                    unIntent.putExtra("pseudo", pseudo);
                    Quizz.this.startActivityForResult(unIntent, code_fenetre);
                }
                else{
                    messageErreur();
                }

            }
        });

        //le bouton btn_comics permet de lancer le quiz de comics
        btn_comics = (Button) this.findViewById(R.id.btn_comics);
        btn_comics.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                if (verifPseudo()==true) {
                Intent unIntent = new Intent(Quizz.this, QuizzComics.class);
                    unIntent.putExtra("pseudo", pseudo);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);}
                else {messageErreur();}
            }
        });

        //le bouton btn_bd permet de lancer le quiz de bande dessinée
        btn_bd = (Button) this.findViewById(R.id.btn_bd);
        btn_bd.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                if (verifPseudo()==true) {
                Intent unIntent = new Intent(Quizz.this, QuizzBD.class);
                    unIntent.putExtra("pseudo", pseudo);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);}
                else {messageErreur();}
            }
        });

        //le bouton btn_retour permet de revenir à la page d'accueil
        btn_retour = (Button) this.findViewById(R.id.btn_retour2);
        btn_retour.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {

                Intent unIntent = new Intent(Quizz.this, Accueil.class);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);}


        });


    }
private boolean verifPseudo(){
    pseudo="";
        pseudo = editpseudo.getText().toString();

        if(pseudo.matches("")){ // vérifie que l'utilisateur a remplit le formulaire
            pseudoValable=false;
        }

return pseudoValable;
    }
private void messageErreur(){

    msgErreur.setVisibility(View.VISIBLE);
}


    //stocke les questions du quiz de bande dessinée
        private String bdquestions[] = {
                "Dans la bande dessinée Boule et Bill, qui est Boule ?",
                "Dans quel album Tintin fait-il la connaissance du Capitaine Haddock ?",
                "Peyo est connu pour Les Schtroumpfs, mais il est aussi le créateur de...",
                "Quel est le prénom du druide dans les albums Astérix ?",
                "Quel personnage de bande dessinée aime particulièrement les lasagnes ?",
                "Gaston Lagaffe est un fervent défenseur de la cause animale. Qui sont ses 2 plus fidèles compagnons ?",
                "Comment s'appelle l'amoureuse de Titeuf ?",
                "Dans la bande dessinée Pif et Hercule, qui est Pif ?",
                "Comment s'intitule le dernier album d'Astérix ?",
                "Qu'est-ce que le gaffophone ?",

        };


    //stocke les questions du quiz de manga
    private String mquestions[] = {
            "Dans quel manga les personnages sont coincés sur une île ?",
            "Comment s'appelle le personnage principal de Fairy Tail ?",
            "Comment s'appelle le Pokémon de Sacha ?",
            "Combien y a-t-il de boules de cristal dans Dragon Ball ?",
            "Quel est le nom de ce personnage ?",
            "Quel est le nom de ce personnage ?",
            "Quel objet sert à capturer les Pokémon ?",
            "Inazuma Eleven est un manga ayant comme thème principal :",
            "One Piece est un manga ayant comme thème principal :",
            "Comment s'appelle le personnage principal de Dragon Ball ? ",

    };


    //stocke les questions du quiz de comics
    private String cquestions[] = {
            "Par quoi a été mordu Spiderman ?",
            "Quel est le vrai nom de Superman ?",
            "Dans quelle ville fictive vit Batman ?",
            "Comment s'appelle l'acolyte de Batman ?",
            "Quel est l'arme de Captain America ?",
            "Quel est le super-pouvoir de Flash ?",
            "Dans quoi vit Aquaman ?",
            "Qui est la version maléfique de Spiderman ?",
            "De quel royaume vient Thor ?",
            "De quelle couleur est Hulk ?",

    };




    //stocke les réponses du quiz de bande dessinée
        private String bdChoices[][] = {
                {"Le gamin", "Le chien", "Le père", "La tortue"},
                {"Le Secret de la licorne", "Le Crabe aux pinces d'or", "Le Trésor de Rackham le Rouge", "Le Sceptre d'Ottokar"},
                {"Bob et Bobette", "Johan et Pirlouit", "Tif et Tondu", "Blake et Mortimer"},
                {"Panoramix", "Abraracourcix", "Homéopatix", "Assurancetourix"},
                {"Milou", "Fantasio", "Garfield", "Rantanplan"},
                {"Un chat et un canari", "Une mouette et un chat", "Un chat et un chien", "Un canari et une mouette"},
                {"Nadia", "Paula", "Célia", "Laura"},
                {"Le chat", "Le chien", "La souris", "Le hérisson"},
                {"Astérix le Gaulois", "Le Ciel lui tombe sur la tête", "Le papyrus de César", "Astérix et la Transitalique"},
                {"Un téléphone", "Un instrument de musique", "Une fourgonnette", "Un animal"},

        };

    //stocke les réponses du quiz de manga
    private String mChoices[][] = {
            {"Naruto", "One Piece", "Dragon Ball", "Fairy Tail"},
            {"Lucy", "Cana", "Natsu", "Grey"},
            {"Sourichu", "Pikaro", "Souriclair", "Pikachu"},
            {"5", "6", "7", "8"},
            {"Franky", "Nami", "Luffy", "Baggy"},
            {"Shino", "Naruto", "Kakashi", "Sasuke"},
            {"Une Pokéboule", "Une Pokéboîte", "Une Pokéball", "Une Pokétupperware"},
            {"Le Football", "Le Basket", "Le Rugby", "La Pétanque"},
            {"Les animaux", "Les pirates", "Les fées", "Les robots"},
            {"Vegeta", "Freezer", "Son Goku", "Piccolo"},

    };

    //stocke les réponses du quiz de comics
    private String cChoices[][] = {
            {"Un castor", "Un cheval", "Un chien", "Une araignée"},
            {"Clark Kent", "Klark Cent", "Klarc Kainte", "Clarque Kent"},
            {"Metropolis", "Gotham City", "Heliopoils", "Comicpolis"},
            {"Martin", "Benjamin", "Antonin", "Robin"},
            {"Une épée", "Un marteau", "Un bouclier", "Une massue"},
            {"Il a une grande force", "Il lit dans les pensées", "Il court très vite", "Il fait léviter des objets"},
            {"Dans l'air", "Dans l'eau", "Dans le feu", "Dans la terre"},
            {"Venom", "SpiderTom", "Octopus", "Spiderbad"},
            {"Asgrad", "Asgard", "Agsard", "Arsgad"},
            {"Bleu", "Rouge", "Vert", "Orange"},

    };

    //stocke les bonnes réponses du quiz de bande dessinée
        private String bdCorrectAnswers[] = {"Le gamin", "Le Crabe aux pinces d'or", "Johan et Pirlouit", "Panoramix", "Garfield", "Une mouette et un chat", "Nadia", "Le chien", "Astérix et la Transitalique", "Un instrument de musique"};

    //stocke les bonnes réponses du quiz de manga
        private String mCorrectAnswers[] = {"Fairy Tail", "Natsu", "Pikachu", "7", "Luffy", "Naruto", "Une Pokéball", "Le Football", "Les pirates", "Son Goku"};

    //stocke les bonnes réponses du quiz de comics
        private String cCorrectAnswers[] = {"Une araignée", "Clark Kent", "Gotham City", "Robin", "Un bouclier", "Il court très vite", "Dans l'eau", "Venom", "Asgard", "Vert"};


        //region accesseurs
        public String getQuestionsbd ( int a){
            String question = bdquestions[a];
            return question;
        }

    public String getQuestionsm ( int a){
        String question = mquestions[a];
        return question;
    }

    public String getQuestionsc ( int a){
        String question = cquestions[a];
        return question;
    }

        public String getChoicesbd ( int a){
            String choices0 = bdChoices[a][0];
            return choices0;
        }

        public String getChoices2bd ( int a){
            String choice1 = bdChoices[a][1];
            return choice1;
        }


        public String getChoices3bd ( int a){
            String choice2 = bdChoices[a][2];
            return choice2;
        }

        public String getChoices4bd ( int a){
            String choice3 = bdChoices[a][3];
            return choice3;
        }

        public String getCorrectAnwerbd ( int a){
            String answer = bdCorrectAnswers[a];
            return answer;
        }
    public String getChoicesm ( int a){
        String choices0 = mChoices[a][0];
        return choices0;
    }

    public String getChoices2m ( int a){
        String choice1 = mChoices[a][1];
        return choice1;
    }


    public String getChoices3m ( int a){
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getChoices4m ( int a){
        String choice3 = mChoices[a][3];
        return choice3;
    }

    public String getCorrectAnwerm ( int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
    public String getChoicesc ( int a){
        String choices0 = cChoices[a][0];
        return choices0;
    }

    public String getChoices2c ( int a){
        String choice1 = cChoices[a][1];
        return choice1;
    }


    public String getChoices3c ( int a){
        String choice2 = cChoices[a][2];
        return choice2;
    }

    public String getChoices4c ( int a){
        String choice3 = cChoices[a][3];
        return choice3;
    }

    public String getCorrectAnwerc ( int a){
        String answer = cCorrectAnswers[a];
        return answer;
    }
    //endregion


}
