package com.example.vpitard.ppe3_mobile;

/**
 * Created by lrouger on 29/11/2016.
 */

public class Visiteur {
    private String nom;
    private String prenom;
    private String identifiant;
    private String mdp;

    public Visiteur (String unNom, String unPrenom, String unIdentifiant, String unMdp){
        this.nom=unNom;
        this.prenom=unPrenom;
        this.identifiant=unIdentifiant;
        this.mdp=unMdp;
    }

    public String getPrenom(){return prenom;}
    public String getNom(){return nom;}
    public String getIdentifiant(){return identifiant;}
    public String getMdp(){return mdp;}

    public void setPrenom(String unPrenom){this.prenom=unPrenom;}
    public void setNom(String unNom){this.nom=unNom;}
    public void setIdentifiant(String unId){this.identifiant=unId;}
    public void setMdp(String unMdp){this.mdp=unMdp;}

}