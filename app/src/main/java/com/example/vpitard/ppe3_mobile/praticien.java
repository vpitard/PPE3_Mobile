package com.example.vpitard.ppe3_mobile;

import java.util.ArrayList;

/**
 * Created by MAEL on 26/11/2016.
 */

public class praticien {
    private String nom;
    private String prenom;
    private String secteur;
    private String activite;

    public praticien(String nom,String prenom,String secteur,String activite){
        this.nom=nom;
        this.prenom=prenom;
        this.secteur=secteur;
        this.activite=activite;
    }

    public String getActivite() {
        return activite;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSecteur() {
        return secteur;
    }

    public static ArrayList<praticien> toutLesPraticiens= new ArrayList<>();
    public static void setTousLesPraticiens(ArrayList<praticien> toutLesPraticiens){
        praticien.toutLesPraticiens = toutLesPraticiens;
    }
    public static void ajouteUnPracticien(String nom,String prenom,String secteur,String activite){
        praticien unPraticien = new praticien(nom,prenom,activite,secteur);
        toutLesPraticiens.add(unPraticien);
    }
}