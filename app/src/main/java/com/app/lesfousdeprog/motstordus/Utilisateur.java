package com.app.lesfousdeprog.motstordus;

public class Utilisateur {

    public int getScorequizbd() {
        return scorequizbd;
    }

    public void setScorequizbd(int scorequizbd) {
        this.scorequizbd = scorequizbd;
    }

    private int scorequizbd;

    public int getScorequizmanga() {
        return scorequizmanga;
    }

    public void setScorequizmanga(int scorequizmanga) {
        this.scorequizmanga = scorequizmanga;
    }

    private int scorequizmanga;

    public int getScorequizcomics() {
        return scorequizcomics;
    }

    public void setScorequizcomics(int scorequizcomics) {
        this.scorequizcomics = scorequizcomics;
    }

    private int scorequizcomics;


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    private int idUser;

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    private String pseudo;

    public int getScoreMemo() {
        return scoreMemo;
    }

    public void setScoreMemo(int scoreMemo) {
        this.scoreMemo = scoreMemo;
    }

    private int scoreMemo;

    public int getScoreQuiz() {
        return scoreQuiz;
    }

    public void setScoreQuiz(int scoreQuiz) {
        this.scoreQuiz = scoreQuiz;
    }

    private int scoreQuiz;

    public int getScoreRange() {
        return ScoreRange;
    }

    public void setScoreRange(int scoreRange) {
        ScoreRange = scoreRange;
    }

    private int ScoreRange;


    public Utilisateur(int unid,String unPseudo){
idUser = unid;
        pseudo = unPseudo;

    }





}
