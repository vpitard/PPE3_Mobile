package com.example.vpitard.ppe3_mobile.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.vpitard.ppe3_mobile.R;
import com.example.vpitard.ppe3_mobile.vue.nouveau_produit;
import com.example.vpitard.ppe3_mobile.vue.nouvelle_visite;

/**
 * Created by MAEL on 26/11/2016.
 */

public class menu  extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        Button btn_nouvelle_viste = (Button) findViewById(R.id.btn_nouvelle_viste);
        btn_nouvelle_viste.setOnClickListener(observateurclic);
        Button btn_nouveau_produit = (Button) findViewById(R.id.btn_nouveau_produit);
        btn_nouveau_produit.setOnClickListener(observateurclic);
        Button btn_consulter_visite = (Button) findViewById(R.id.btn_consulter_visite);
        btn_consulter_visite.setOnClickListener(observateurclic);
        Button btn_nouveau_praticien = (Button) findViewById(R.id.btn_nouveau_praticien);
        btn_nouveau_praticien.setOnClickListener(observateurclic);
    }

    public View.OnClickListener observateurclic = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_nouvelle_viste:
                    Intent nouvelleVisite = new Intent(getApplicationContext(), nouvelle_visite.class);
                    startActivity(nouvelleVisite);
                    break;

                case R.id.btn_nouveau_produit:
                    Intent nouveau_produit = new Intent(getApplicationContext(), com.example.vpitard.ppe3_mobile.vue.nouveau_produit.class);
                    startActivity(nouveau_produit);
                    break;

                case R.id.btn_consulter_visite:
                    Intent consulter_visite = new Intent(getApplicationContext(), nouveau_produit.class);
                    startActivity(consulter_visite);
                    break;

                case R.id.btn_nouveau_praticien:
                    Intent nouveau_praticien = new Intent(getApplicationContext(), com.example.vpitard.ppe3_mobile.vue.nouveau_praticien.class);
                    startActivity(nouveau_praticien);
                    break;

            }


        }
    };
}



