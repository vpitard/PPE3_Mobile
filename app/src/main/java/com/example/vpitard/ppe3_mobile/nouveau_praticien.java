package com.example.vpitard.ppe3_mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by MAEL on 21/11/2016.
 */

public class nouveau_praticien extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nouveau_praticien);
        //* test push mael*//
        Button btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(observateurclic);
        Button btn_annuler = (Button) findViewById(R.id.btn_annuler);
        btn_annuler.setOnClickListener(observateurclic);


    }

    public View.OnClickListener observateurclic = new View.OnClickListener() {
        String txt_nom_praticien = String.valueOf(((EditText) findViewById(R.id.txt_nom_praticien)).getText());
        String txt_prenom_praticien = String.valueOf(((EditText) findViewById(R.id.txt_prenom_praticien)).getText());
        String txt_secteur= String.valueOf(((EditText) findViewById(R.id.txt_secteur)).getText());
        // il manque l'activité liste


            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_ok:
                        break;
                    case R.id.btn_annuler:
                        break;
                }
        }


    };
}

