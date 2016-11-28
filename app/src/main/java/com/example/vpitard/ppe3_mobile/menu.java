package com.example.vpitard.ppe3_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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
                        Intent i = new Intent(getApplicationContext(), nouvelle_visite.class);
                        startActivity(i);
                        break;
                    case R.id.btn_nouveau_produit:
                        Intent y = new Intent(getApplicationContext(), nouveau_produit.class);
                        startActivity(y);
                        break;
                    case R.id.btn_consulter_visite:
                        Intent g = new Intent(getApplicationContext(), nouveau_produit.class);
                        startActivity(g);
                        break;
                    case R.id.btn_nouveau_praticien:
                        Intent f = new Intent(getApplicationContext(), nouveau_produit.class);
                        startActivity(f);
                        break;
                }
                }
            };
}



