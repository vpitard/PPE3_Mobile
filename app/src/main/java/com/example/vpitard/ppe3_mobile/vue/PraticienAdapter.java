package com.example.vpitard.ppe3_mobile.vue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vpitard.ppe3_mobile.R;
import com.example.vpitard.ppe3_mobile.systeme.Praticien;

import java.util.List;

/**
 * Created by MAEL on 13/12/2016.
 */

public class praticienAdapter extends BaseAdapter {
    private List<Praticien> listPraticien;
    private LayoutInflater inflater;

    public praticienAdapter(Context context, List<Praticien> listP){
        this.inflater=LayoutInflater.from(context);
        this.listPraticien = listP;
    }
    @Override
    public int getCount(){return this.listPraticien.size();}
    public Praticien getItem(int position) { return this.listPraticien.get(position);}
    public long getItemId (int position) {return position;}
    public View getView(int position, View convertView, ViewGroup parent){
        TextView nomPraticien;
        if (convertView==null){
        convertView = this.inflater.inflate(R.layout.praticien_vue,parent,false);
        nomPraticien = (TextView) convertView.findViewById(R.id.nom_praticien);
        convertView.setTag(R.id.nom_praticien,nomPraticien);


    }
    else{
        nomPraticien = (TextView) convertView.getTag(R.id.nom_praticien);
    }
    Praticien praticien = this.getItem(position);
    nomPraticien.setText(praticien.getPrenom());
    return convertView;

}
}
