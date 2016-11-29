package com.example.vpitard.ppe3_mobile;

import static com.example.vpitard.ppe3_mobile.R.id.Praticien;

/**
 * Created by MAEL on 26/11/2016.
 */

public class visite {
    private String dateVisite;
    private praticien praticien;
    private Visiteur visiteur;

    public void visite(String uneDateVisite, praticien unPraticien, Visiteur unVisiteur){
        this.dateVisite = uneDateVisite;
        this.praticien = unPraticien;
        this.visiteur = unVisiteur;
    }

    public void setDateVisite(String dateVisite) {
        this.dateVisite = dateVisite;
    }

    public void setPraticien(com.example.vpitard.ppe3_mobile.praticien praticien) {
        this.praticien = praticien;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public String getDateVisite() {

        return dateVisite;
    }

    public praticien getPraticien() {
        return praticien;
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

}
