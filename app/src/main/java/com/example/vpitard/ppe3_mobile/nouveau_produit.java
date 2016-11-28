package com.example.vpitard.ppe3_mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by MAEL on 26/11/2016.
 */

public class nouveau_produit extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.nouveau_produit);
            Button btn_ok = (Button) findViewById(R.id.btn_ok);
            btn_ok.setOnClickListener(observateurclic);
            Button btn_annuler = (Button) findViewById(R.id.btn_annuler);
            btn_annuler.setOnClickListener(observateurclic);

        }

        public View.OnClickListener observateurclic = new View.OnClickListener() {
            String txt_Designation_produit = String.valueOf(((EditText) findViewById(R.id.txt_nom_praticien)).getText());
            //classe pas fini a completer


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


