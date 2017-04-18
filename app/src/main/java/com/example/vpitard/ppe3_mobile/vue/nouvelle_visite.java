package com.example.vpitard.ppe3_mobile.vue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vpitard.ppe3_mobile.R;
import com.example.vpitard.ppe3_mobile.network.Exportation;
import com.example.vpitard.ppe3_mobile.network.ImportationPraticien;
import com.example.vpitard.ppe3_mobile.network.ImportationProduit;
import com.example.vpitard.ppe3_mobile.systeme.Praticien;
import com.example.vpitard.ppe3_mobile.systeme.Produit;
import com.example.vpitard.ppe3_mobile.systeme.praticienAdapter;
import com.example.vpitard.ppe3_mobile.systeme.produitAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by MAEL on 26/11/2016.
 */

public class nouvelle_visite extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        Bundle b = getIntent().getExtras();
        String log = b.getString("log");
        String pwd = b.getString("pwd");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.nouvelle_visite);
        Button btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(observateurclic);
        DatePicker datePicker1 = (DatePicker) findViewById(R.id.datePicker2);
        Button btn_annuler = (Button) findViewById(R.id.btn_annuler);
        btn_annuler.setOnClickListener(observateurclic);

        // Create a new instance of DatePickerDialog and return it

        ImportationPraticien importPraticien = new ImportationPraticien();

        importPraticien.execute("http://10.0.3.2:88/ppe/ImportPraticien.php", log, pwd);
        ImportationProduit importProduit = new ImportationProduit();
        importProduit.execute("http://10.0.3.2:88/ppe/importProduit.php", log, pwd);
        try {
            ArrayList<Praticien> listePraticien = importPraticien.get();
            ArrayList<Produit> listeProduit = importProduit.get();

            praticienAdapter adapter = new praticienAdapter(getApplicationContext(), listePraticien);
            produitAdapter adapterProduit = new produitAdapter(getApplicationContext(), listeProduit);
            Spinner SpinnerPraticien = (Spinner) findViewById(R.id.SpinnerPraticien);
            SpinnerPraticien.setAdapter(adapter);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public View.OnClickListener observateurclic = new View.OnClickListener() {

        //checkedtext mystere pour l'instant

        public void onClick(View v) {

                Praticien unPraticien =(Praticien )  ((Spinner) findViewById(R.id.SpinnerPraticien)).getSelectedItem();
                DatePicker datePicker1 = (DatePicker) findViewById(R.id.datePicker2);
                switch (v.getId()) {

                    case R.id.btn_ok:

                        int mois = +datePicker1.getMonth() + 1;
                        String date = datePicker1.getYear()+ "-" + mois + "-" + datePicker1.getDayOfMonth() ;


                        JSONObject object = new JSONObject();
                        try {
                            object.put("codePraticien",unPraticien.getCodePraticien() );
                            object.put("dateVisite", date);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(getApplicationContext(),
                                " Vous avez selectionner " + unPraticien.getCodePraticien() + " la date est :" + date +object.toString(), Toast.LENGTH_SHORT).show();
                        Exportation tacheExport = new Exportation();
                        tacheExport.execute("http://10.0.3.2:88/ppe/ExportVisite.php",object.toString());
                        try {
                            if(tacheExport.get()){
                                Log.i("Parseur","Enregistrement effectué");
                            }
                            else{
                                Log.i("Parseur","Problème lors de la lecture du fichier");
                            }
                        } catch (InterruptedException e) {
                            Log.i("Parseur", "Interruption lecture fichier"+e.getMessage());
                        } catch (ExecutionException e) {
                            Log.i("Parseur", "Erreur execution"+ e.getMessage());
                        }
                        break;



                    case R.id.btn_annuler:
                        break;

                }
        }

        ;
    };
}


