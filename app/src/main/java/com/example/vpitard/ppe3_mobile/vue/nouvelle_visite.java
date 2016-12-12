package com.example.vpitard.ppe3_mobile.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.vpitard.ppe3_mobile.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAEL on 26/11/2016.
 */

public class nouvelle_visite extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nouvelle_visite);
        Button btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(observateurclic);
        Button btn_annuler = (Button) findViewById(R.id.btn_annuler);
        btn_annuler.setOnClickListener(observateurclic);
        Button btn_ajouter_praticien = (Button) findViewById(R.id.btn_ajouter_praticien);
        btn_ajouter_praticien.setOnClickListener(observateurclic);

        //Spinner spinnerPraticien = (Spinner) findViewById(R.id.spinnerPraticien);
        List<String> liste = new ArrayList<String>();
        liste.add("test1");
        liste.add("test2");
        liste.add("test3");

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, liste);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
       // spinnerPraticien.setAdapter(adapter);

    }
    public View.OnClickListener observateurclic = new View.OnClickListener() {

        //checkedtext mystere pour l'instant

    public void onClick(View v) {
        String date = String.valueOf(((EditText) findViewById(R.id.date)).getText());
        switch (v.getId()) {
            case R.id.btn_ok:
                break;
            case R.id.btn_annuler:
                break;
            case R.id.btn_ajouter_praticien:
                Intent i = new Intent(getApplicationContext(), nouveau_praticien.class);
                startActivity(i);
                break;
        }
    }
    };

}
