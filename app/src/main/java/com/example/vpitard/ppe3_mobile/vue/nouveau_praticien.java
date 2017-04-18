package com.example.vpitard.ppe3_mobile.vue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vpitard.ppe3_mobile.R;
import com.example.vpitard.ppe3_mobile.network.ImportationActivite;
import com.example.vpitard.ppe3_mobile.systeme.Activite;
import com.example.vpitard.ppe3_mobile.systeme.activiterAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by MAEL on 21/11/2016.
 */

public class nouveau_praticien extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        Bundle b = getIntent().getExtras();
        String log = b.getString("log");
        String pwd = b.getString("pwd");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nouveau_praticien);
        //* test push mael*//
        Button btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(observateurclic);
        Button btn_annuler = (Button) findViewById(R.id.btn_annuler);
        btn_annuler.setOnClickListener(observateurclic);

        ImportationActivite importationActivite = new ImportationActivite();
        importationActivite.execute("http://10.0.3.2:88/ppe/ImportActivite.php",log, pwd);
        try {
            ArrayList<Activite> listeActivite = importationActivite.get();

            activiterAdapter adapter = new activiterAdapter(getApplicationContext(), listeActivite);

            Spinner SpinnerActivite = (Spinner) findViewById(R.id.spinnerActivite);
            SpinnerActivite.setAdapter(adapter);

        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }

    public View.OnClickListener observateurclic = new View.OnClickListener() {

        // il manque l'activité liste


            public void onClick(View v) {
                String txt_nom_praticien = String.valueOf(((EditText) findViewById(R.id.txt_nom_praticien)).getText());
                String txt_prenom_praticien = String.valueOf(((EditText) findViewById(R.id.txt_prenom_praticien)).getText());

                Activite uneActivite =(Activite )((Spinner)findViewById(R.id.spinnerActivite)).getSelectedItem();
                switch (v.getId()) {
                    case R.id.btn_ok:


                        Toast.makeText(getApplicationContext(),
                                " Un praticien a ete ajouter au non de :  "+txt_nom_praticien+  " et au prenom de :  "+ txt_prenom_praticien +"sa profession est "+ uneActivite.getLibelle(),   Toast.LENGTH_SHORT).show();


                        JSONObject object = new JSONObject();
                        try {
                            object.put("prenomPraticien", txt_prenom_praticien);
                            object.put("nomPraticien",txt_nom_praticien );
                            object.put("codeAct",uneActivite.getcode() );

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                        break;
                    case R.id.btn_annuler:
                        break;
                }
        }


    };
}

