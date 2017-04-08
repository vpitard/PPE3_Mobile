package com.example.vpitard.ppe3_mobile.systeme;

/**
 * Created by MAEL on 26/11/2016.
 */

public class Visite {
    private String dateVisite;
    private Praticien praticien;
    private Visiteur visiteur;

    public void visite(String uneDateVisite, Praticien unPraticien, Visiteur unVisiteur){
        this.dateVisite = uneDateVisite;
        this.praticien = unPraticien;
        this.visiteur = unVisiteur;
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

}
