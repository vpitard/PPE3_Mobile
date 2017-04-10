package com.example.vpitard.ppe3_mobile.systeme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vpitard.ppe3_mobile.R;

import java.util.List;

/**
 * Created by MAEL on 15/12/2016.
 */

public class produitAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Produit> listProduit;

    public produitAdapter(Context context, List<Produit> listP) {
        this.inflater = LayoutInflater.from(context);
        this.listProduit = listP;
    }
        @Override
        public int getCount () {
            return this.listProduit.size();
        }

    public Produit getItem(int position) {
        return this.listProduit.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        TextView nomProduit;
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.produit_vue, parent, false);
            nomProduit = (TextView) convertView.findViewById(R.id.nom_produit);
            convertView.setTag(R.id.nom_produit, nomProduit);


        } else {
            nomProduit = (TextView) convertView.getTag(R.id.nom_produit);
        }
        Produit produit = this.getItem(position);
        nomProduit.setText(produit.getDesignationProduit());
        return convertView;

    }
}



