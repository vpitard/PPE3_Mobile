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
 * Created by MAEL on 13/12/2016.
 */

public class visiteAdapter extends BaseAdapter {
    private List<Visite> listVisite;
    private LayoutInflater inflater;

    public visiteAdapter(Context context, List<Visite> listV){
        this.inflater=LayoutInflater.from(context);
        this.listVisite = listV;
    }
    @Override
    public int getCount(){return this.listVisite.size();}

    public Visite getItem(int position) { return this.listVisite.get(position);}

    public long getItemId (int position) {return position;}

    public View getView(int position, View convertView, ViewGroup parent){
        TextView nom_visite;
        if (convertView==null){
        convertView = this.inflater.inflate(R.layout.visite_vue,parent,false);
            nom_visite = (TextView) convertView.findViewById(R.id.nom_visite);
        convertView.setTag(R.id.nom_visite,nom_visite);


    }
    else{
            nom_visite = (TextView) convertView.getTag(R.id.nom_visite);
    }
    Visite visite= this.getItem(position);
        nom_visite.setText(visite.getDateVisite());
    return convertView;

}
}
