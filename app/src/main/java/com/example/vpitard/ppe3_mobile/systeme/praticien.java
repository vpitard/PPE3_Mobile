package com.example.vpitard.ppe3_mobile.systeme;

import java.util.ArrayList;

/**
 * Created by MAEL on 26/11/2016.
 */

public class Praticien {

    private String nomPraticien;
    private String prenomPraticien;
    private String secteur;
    private int codeAct;

    public Praticien(String nom, String prenom, String secteur, int codeAct){

        this.nomPraticien=nom;
        this.prenomPraticien=prenom;
        this.secteur=secteur;
        this.codeAct=codeAct;
    }



    public int getActivite() {
        return codeAct;
    }

    public String getNom() {
        return nomPraticien;
    }

    public String getPrenom() {
        return prenomPraticien;
    }

    public String getSecteur() {
        return secteur;
    }

    public static ArrayList<Praticien> toutLesPraticiens= new ArrayList<>();
    public static void setTousLesPraticiens(ArrayList<Praticien> toutLesPraticiens){
        Praticien.toutLesPraticiens = toutLesPraticiens;
    }
    public static void ajouteUnPracticien(String nomPraticien,String prenomPraticien,String secteur, int codeAct){
        Praticien unPraticien = new Praticien(nomPraticien,prenomPraticien,secteur,codeAct);
        toutLesPraticiens.add(unPraticien);
    }
}
