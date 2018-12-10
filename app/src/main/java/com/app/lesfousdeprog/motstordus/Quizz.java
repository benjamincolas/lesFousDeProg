package com.app.lesfousdeprog.motstordus;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Quizz extends AppCompatActivity {
   private Button btn_manga;
    private Button btn_bd;
    private Button btn_comics;
    private Button btn_retour;
    private int num;
    private final int code_fenetre = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);


        btn_manga = (Button) this.findViewById(R.id.btn_manga);
        btn_manga.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                Intent unIntent = new Intent(Quizz.this, QuizzManga.class);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);
            }
        });

        btn_comics = (Button) this.findViewById(R.id.btn_comics);
        btn_comics.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                Intent unIntent = new Intent(Quizz.this, QuizzComics.class);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);
            }
        });

        btn_bd = (Button) this.findViewById(R.id.btn_bd);
        btn_bd.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                Intent unIntent = new Intent(Quizz.this, QuizzBD.class);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);
            }
        });

        /*btn_retour = (Button) this.findViewById(R.id.btn_retour);
        btn_retour.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                Intent unIntent = new Intent(Quizz.this, Accueil.class);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);
            }
        }); */


    }



    /*    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        btn_bd = (Button) this.findViewById(R.id.btn_bd);
        btn_bd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent unIntent = new Intent(Quizz.this, QuizzBD.class);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);
            }
        });

        btn_comics = (Button) this.findViewById(R.id.btn_comics);
        btn_comics.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent unIntent = new Intent(Quizz.this, QuizzComics.class);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);
            }
        });

        btn_manga = (Button) this.findViewById(R.id.btn_manga);
        btn_manga.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent unIntent = new Intent(Quizz.this, QuizzManga.class);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);
            }
        });


        btn_retour = (Button) this.findViewById(R.id.btn_retour2);
        btn_retour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent unIntent = new Intent(Quizz.this, Accueil.class);
                Quizz.this.startActivityForResult(unIntent, code_fenetre);
            }
        });
    }

    private void jouerBD(int unNumQ){
        Intent unIntent = new Intent(this, QuizzBD.class);
        unIntent.putExtra("Numero", unNumQ);
        this.startActivityForResult(unIntent,code_fenetre); }

    private void jouerComics(int unNumQ){
        Intent unIntent = new Intent(this, QuizzComics.class);
        unIntent.putExtra("Numero", unNumQ);
        this.startActivityForResult(unIntent,code_fenetre); }

    private void jouerManga(int unNumQ){
        Intent unIntent = new Intent(this, QuizzManga.class);
        unIntent.putExtra("Numero", unNumQ);
        this.startActivityForResult(unIntent,code_fenetre); }



    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {     //super.onActivityResult(requestCode, resultCode, data);     //on gère l’activité concernée
        if(requestCode==code_fenetre){
            //si l’activité a retourner ok
            if(resultCode==RESULT_OK){
                //on vérifie la présence d’un ‘numéro’ (celui de la question traitée)
                if(data.hasExtra(("Numero"))){
                    //récupère e numéro de la dernière question
                    num = data.getExtras().getInt("Numero");
                    //incrémente pour lancer la question suivante
                    num++;
                    jouerBD(num);
                }
            }
            else{
                Toast.makeText(this, "Fin du jeu", Toast.LENGTH_SHORT);
                num = 0;         }     } }*/


        private String bdquestions[] = {
                "Dans la bande dessinée BOULE ET BILL, qui est Boule ?",
                "Dans quel album Tintin fait-il la connaissance du Capitaine Haddock ?",
                "Peyo est connu pour Les Schtroumpfs, mails il est aussi le créateur de...",
                "Quel est le prénom du druide dans les albums Astérix ?",
                "Quel personnage de bande dessinée aime particulièrement les lasagnes ?",
                "Gaston Lagaffe est un fervent défenseur de la cause animale. Qui sont ses 2 plus fidèles compagnons ?",
                "Comment s'appelle l'amoureuse de Titeuf ?",
                "Dans la bande dessinée Pif et Hercule, qui est Pif ?",
                "Comment s'intitule le dernier album d'Astérix ?",
                "Qu'est-ce que le gaffophone ?",

        };

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

        private String bdCorrectAnswers[] = {"Le gamin", "Le Crabe aux pinces d'or", "Johan et Pirlouit", "Panoramix", "Garfield", "Une mouette et un chat", "Nadia", "Le chien", "Astérix et la Transitalique", "Un instrument de musique"};

        private String mCorrectAnswers[] = {"Fairy Tail", "Natsu", "Pikachu", "7", "Luffy", "Naruto", "Une Pokéball", "Le Football", "Les pirates", "Son Goku"};

        private String cCorrectAnswers[] = {"Une araignée", "Clark Kent", "Gotham City", "Robin", "Un bouclier", "Il court très vite", "Dans l'eau", "Venom", "Asgard", "Vert"};


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

}
