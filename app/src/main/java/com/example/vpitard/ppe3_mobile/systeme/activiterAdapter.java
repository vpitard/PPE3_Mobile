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

public class activiterAdapter extends BaseAdapter {
    private List<Activite> listActivite;
    private LayoutInflater inflater;

    public activiterAdapter(Context context, List<Activite> listA){
        this.inflater=LayoutInflater.from(context);
        this.listActivite = listA;
    }
    @Override
    public int getCount(){return this.listActivite.size();}
    public Activite getItem(int position) { return this.listActivite.get(position);}
    public long getItemId (int position) {return position;}
    public View getView(int position, View convertView, ViewGroup parent){
        TextView nom_activite;
        if (convertView==null){
        convertView = this.inflater.inflate(R.layout.activite_vue,parent,false);
            nom_activite = (TextView) convertView.findViewById(R.id.nom_activite);
        convertView.setTag(R.id.nom_activite,nom_activite);


    }
    else{
            nom_activite = (TextView) convertView.getTag(R.id.nom_activite);
    }
    Activite activite = this.getItem(position);
        nom_activite.setText(activite.getLibelle());
    return convertView;

}
}
