package com.example.vpitard.ppe3_mobile.systeme;

import java.util.ArrayList;

/**
 * Created by lrouger on 29/11/2016.
 */

public class Visiteur {
    private int codeVisiteur;
    private String nomVisiteur;
    private String prenomVisiteur;
    private String identifiantVisiteur;
    private String motDePasseVisiteur;

    public Visiteur(int unCode, String unNom, String unPrenom, String unIdentifiant, String unMdp) {
        this.codeVisiteur=unCode;
        this.nomVisiteur = unNom;
        this.prenomVisiteur = unPrenom;
        this.identifiantVisiteur = unIdentifiant;
        this.motDePasseVisiteur = unMdp;
    }

    public int getCode() {
        return codeVisiteur;
    }

    public String getPrenom() {
        return prenomVisiteur;
    }

    public String getNom() {
        return nomVisiteur;
    }

    public String getIdentifiant() {
        return identifiantVisiteur;
    }

    public String getMdp() {
        return motDePasseVisiteur;
    }



    public void setCode(int unCode){this.codeVisiteur = unCode; }

    public void setPrenom(String unPrenom) {
        this.prenomVisiteur = unPrenom;
    }

    public void setNom(String unNom) {
        this.nomVisiteur = unNom;
    }

    public void setIdentifiant(String unId) {
        this.identifiantVisiteur = unId;
    }

    public void setMdp(String unMdp) {
        this.motDePasseVisiteur = unMdp;
    }

    public static ArrayList<Visiteur> LesVisiteurs = new ArrayList<>();

    public static void ajouteUnVisiteur(int code,String nom, String prenom, String identifiant, String mdp) {
        Visiteur visiteur = new Visiteur(code,nom, prenom, identifiant, mdp);
        LesVisiteurs.add(visiteur);
    }

    public static void setLesVisiteurs(ArrayList<Visiteur> LesVisiteurs) {
        Visiteur.LesVisiteurs = LesVisiteurs;

    }
}