package com.example.vpitard.ppe3_mobile.systeme;

import java.util.ArrayList;

/**
 * Created by lrouger on 29/11/2016.
 */

public class Activite {
    private int codeAct;
    private String libelleAct;

    public Activite (int uncode, String unLibelle){
        this.codeAct=uncode;
        this.libelleAct=unLibelle;
    }

    public int getcode() {
        return codeAct;
    }

    public  void setCode(int code){this.codeAct = code; }

    public String getLibelle() {
        return libelleAct;
    }

    public void setLibelle(String libelle) {
        this.libelleAct = libelle;
    }


    public static ArrayList<Activite> toutelesactivites = new ArrayList<>();

    public static void setToutLesProduit(ArrayList<Produit> toutLesProduit){
        Produit.toutLesProduit = toutLesProduit;
    }
    public static void ajouteUneActivite(int codeAct ,String libelleAct){
        Activite uneActvite = new Activite(codeAct, libelleAct);
        toutelesactivites.add(uneActvite);
    }


    }


