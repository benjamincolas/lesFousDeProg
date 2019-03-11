package com.app.lesfousdeprog.motstordus;

import android.content.Intent;
import android.database.MatrixCursor;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Classement extends AppCompatActivity {
    private UtilisateurBdd userbdd;
private TextView txtPseudo,txtClassment,txtQuiz,txtMemo,txtRTBD;
private Button btnQuiz,btnRTBD,btnMemo,btnRetour;
    private String textPseudo,textQuiz,textRTBD,textMemo;
    private final int code_fenetre=28;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final RequestQueue MyRequestQueue = Volley.newRequestQueue(this);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_classement);
        userbdd = new UtilisateurBdd(this);
        btnQuiz = this.findViewById(R.id.btnScoreQuiz);
        btnRTBD = this.findViewById(R.id.btnScoreRTBD);
        btnMemo = this.findViewById(R.id.btnScoreMemo);
        btnRetour = this.findViewById(R.id.btnRetourClassement);
        textPseudo = "";
        textQuiz = "";
        textRTBD = "";
        textMemo = "";
        txtPseudo = this.findViewById(R.id.txt);
        txtClassment = this.findViewById(R.id.txtClassement);
        txtQuiz = this.findViewById(R.id.txtScoreQuiz);
        txtMemo = this.findViewById(R.id.txtScoreMemoRIgolo);
        txtRTBD = this.findViewById(R.id.txtScoreRTBD);
        txtClassment.setPaintFlags(txtClassment.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG); // souligne le texte "Classmeent"
        rempListScoreBd();

        btnRetour.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                resetTxt();
                Intent unIntent = new Intent(Classement.this, Accueil.class);
                Classement.this.startActivityForResult(unIntent, code_fenetre);
            }
        });
        btnQuiz.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                resetTxt();
                rempListScoreBd();
            }
        });
        btnRTBD.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                resetTxt();
                rempListScoreRTBD();
            }
        });
        btnMemo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                resetTxt();
                rempListScoreMemo();

            }

        });
/*

        String url = "http://benjamincolaspro.ddns.net/appAndroid/json.php";
        final StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //This code is executed if the server responds, whether or not the response contains data.
                //The String 'response' contains the server's response.
            }
        }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
            @Override
            public void onErrorResponse(VolleyError error) {
                //This code is executed if there is an error.
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> MyData = new HashMap<String, String>();
                MyData.put("idUser", String.valueOf(4));
                MyData.put("pseudo", "test25");
                MyData.put("scoreQuizBd", String.valueOf(3));
                MyData.put("scoreQuizComics", String.valueOf(2));
                MyData.put("scoreQuizManga", String.valueOf(1));
                MyData.put("scoreRange", String.valueOf(0));
                MyData.put("scoreMemo", String.valueOf(5));
                return MyData;
            }
        };

*/

    }






    private void resetTxt() {textPseudo="";textQuiz="";textRTBD="";textMemo="";}
    private void rempListScoreBd() {
        for (Utilisateur unUtil : userbdd.getUtilScoreBD()) {
            textPseudo = textPseudo + unUtil.getPseudo() + "\n";
            textQuiz = textQuiz + unUtil.getScorequizbd() + "\n";
            textRTBD = textRTBD + unUtil.getScoreRange() + "\n";
            textMemo = textMemo + unUtil.getScoreMemo() + "\n";
        }
        txtPseudo.setText(textPseudo);
        txtQuiz.setText(textQuiz);
        txtRTBD.setText(textRTBD);
        txtMemo.setText(textMemo);
    }
    private void rempListScoreRTBD() {
        for (Utilisateur unUtil : userbdd.getUtilScoreRTBD()) {
            textPseudo = textPseudo + unUtil.getPseudo() + "\n";
            textQuiz = textQuiz + unUtil.getScorequizbd() + "\n";
            textRTBD = textRTBD + unUtil.getScoreRange() + "\n";
            textMemo = textMemo + unUtil.getScoreMemo() + "\n";
        }
        txtPseudo.setText(textPseudo);
        txtQuiz.setText(textQuiz);
        txtRTBD.setText(textRTBD);
        txtMemo.setText(textMemo);
    }
    private void rempListScoreMemo() {
        for (Utilisateur unUtil : userbdd.getUtilScoreMemo()) {
            textPseudo = textPseudo + unUtil.getPseudo() + "\n";
            textQuiz = textQuiz + unUtil.getScorequizbd() + "\n";
            textRTBD = textRTBD + unUtil.getScoreRange() + "\n";
            textMemo = textMemo + unUtil.getScoreMemo() + "\n";
        }
        txtPseudo.setText(textPseudo);
        txtQuiz.setText(textQuiz);
        txtRTBD.setText(textRTBD);
        txtMemo.setText(textMemo);
    }
}
