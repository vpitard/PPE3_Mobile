package com.example.vpitard.ppe3_mobile.systeme;

/**
 * Created by MAEL on 26/11/2016.
 */

public class Praticien {

    public int codePraticien;
    public String  nomPraticien;
    public String prenomPraticien;
    public String secteur;
    public int codeAct;

    public Praticien(int codePraticien ,String nom, String prenom, String secteur){

        this.codePraticien=codePraticien;
        this.nomPraticien=nom;
        this.prenomPraticien=prenom;
        this.secteur=secteur;
        this.codeAct=codeAct;
    }


    public int getCodePraticien(){return codePraticien;}

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


}
