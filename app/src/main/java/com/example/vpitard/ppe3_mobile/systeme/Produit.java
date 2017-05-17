package com.example.vpitard.ppe3_mobile.systeme;

import java.util.ArrayList;

/**
 * Created by vpitard on 29/11/2016.
 */

public class Produit {
    private int id;
    private int codeProduit;
    private String designationProduit;


    public Produit(int id,int codeProduit,String designationProduit) {
        this.id=id;
        this.codeProduit=codeProduit;
        this.designationProduit=designationProduit;
    }

    public int getId() {
        return id;
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
    public static void ajouteUnProduit(int id,int codeProduit,String designationProduit){
        Produit unProduit = new Produit(id,codeProduit, designationProduit);
        toutLesProduit.add(unProduit);
    }
}
