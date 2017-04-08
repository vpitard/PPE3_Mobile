package com.example.vpitard.ppe3_mobile.systeme;

import java.util.ArrayList;

/**
 * Created by vpitard on 29/11/2016.
 */

public class Produit {
    private int codeProduit;
    private String designationProduit;


    public Produit(int codeProduit,String designationProduit) {
        this.codeProduit=codeProduit;
        this.designationProduit=designationProduit;
    }

    public int getCodeProduit() {
        return codeProduit;
    }

    public String getDesignationProduit(){
        return designationProduit;
    }

    public void setCodeProduit(int codeProduit) {
        this.codeProduit = codeProduit;
    }

    public void setDesignationProduit(String designationProduit){
        this.designationProduit= designationProduit;
    }
    public static ArrayList<Produit> toutLesProduit= new ArrayList<>();
    public static void setToutLesProduit(ArrayList<Produit> toutLesProduit){
        Produit.toutLesProduit = toutLesProduit;
    }
    public static void ajouteUnProduit(int codeProduit,String designationProduit){
        Produit unProduit = new Produit(codeProduit, designationProduit);
        toutLesProduit.add(unProduit);
    }
}
