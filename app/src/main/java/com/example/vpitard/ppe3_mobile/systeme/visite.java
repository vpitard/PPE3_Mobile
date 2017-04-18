package com.example.vpitard.ppe3_mobile.systeme;

import java.util.ArrayList;

/**
 * Created by MAEL on 26/11/2016.
 */

public class Visite {
    public String dateVisite;
    public int codePraticien;
    public int codeVisite;
    public Praticien praticien;
    public Visiteur visiteur;

    public void visite(int codeVisite ,String uneDateVisite,int codePraticien, Praticien unPraticien, Visiteur unVisiteur){
        this.codeVisite = codeVisite;
        this.codePraticien = codePraticien;
        this.dateVisite = uneDateVisite;
        this.praticien = unPraticien;
        this.visiteur = unVisiteur;
    }

    public int getCodeVisite(){return codeVisite;}
    public int getCodePraticien(){
        return codePraticien;
    }
    public void setDateVisite(String dateVisite) {
        this.dateVisite = dateVisite;
    }

    public void setPraticien(Praticien praticien) {
        this.praticien = praticien;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public String getDateVisite() {

        return dateVisite;
    }

    public Praticien getPraticien() {
        return praticien;
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public static ArrayList<Visite> toutelesvisites= new ArrayList<>();
    public static void settoutelesvisites(ArrayList<Visite> toutelesvisites){
        Visite.toutelesvisites = toutelesvisites;
    }


}
