package com.example.vpitard.ppe3_mobile.systeme;

/**
 * Created by lrouger on 29/11/2016.
 */

public class Activite {
    private String libelle;

    public Activite (String unLibelle){
        this.libelle=unLibelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
