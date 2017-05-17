package com.example.vpitard.ppe3_mobile.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vpitard.ppe3_mobile.R;
import com.example.vpitard.ppe3_mobile.network.Exportation;
import com.example.vpitard.ppe3_mobile.network.ImportationPraticien;
import com.example.vpitard.ppe3_mobile.network.ImportationProduit;
import com.example.vpitard.ppe3_mobile.network.ImportationVisite;
import com.example.vpitard.ppe3_mobile.systeme.Produit;
import com.example.vpitard.ppe3_mobile.systeme.Visite;
import com.example.vpitard.ppe3_mobile.systeme.produitAdapter;
import com.example.vpitard.ppe3_mobile.systeme.visiteAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by MAEL on 18/04/2017.
 */

public class prescrire_visite extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        Bundle b = getIntent().getExtras();
        String log = b.getString("log");
        String pwd = b.getString("pwd");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulter_visite);
        Button btn_ok = (Button) findViewById(R.id.btn_valider);
        btn_ok.setOnClickListener(observateurclic);
        Button btn_annuler = (Button) findViewById(R.id.btn_ok);
        btn_annuler.setOnClickListener(observateurclic);
        ImportationVisite importVisite = new ImportationVisite();
        importVisite.execute("http://172.21.105.4/android/ImportVisite.php",log, pwd);
        //importVisite.execute("http://10.0.3.2:88/ppe/ImportVisite.php", log, pwd);
        ImportationPraticien importPraticien = new ImportationPraticien();
        //importPraticien.execute("http://10.0.3.2:88/ppe/ImportPraticien.php", log, pwd);
        //importPraticien.execute("http://172.21.105.3/android/ImportPraticien.php", log, pwd);
        ImportationProduit importProduit = new ImportationProduit();
        //importProduit.execute("http://10.0.3.2:88/ppe/importProduit.php", log, pwd);
        importProduit.execute("http://172.21.105.4/android/ImportProduit.php", log, pwd);
        try {
            ArrayList<Visite> listeVisite = importVisite.get();
            visiteAdapter adapter = new visiteAdapter(getApplicationContext(), listeVisite);
            ArrayList<Produit> listeProduit = importProduit.get();
            produitAdapter adapter2 = new produitAdapter(getApplicationContext(), listeProduit);


            Spinner SpinnerVisite = (Spinner) findViewById(R.id.spinnerVisite);
            Spinner SpinnerProduit1 = (Spinner) findViewById(R.id.spinnerProduit1);
            Spinner SpinnerProduit2 = (Spinner) findViewById(R.id.spinnerProduit2);
            Spinner SpinnerProduit3 = (Spinner) findViewById(R.id.spinnerProduit3);
            SpinnerVisite.setAdapter(adapter);
            SpinnerProduit1.setAdapter(adapter2);
            SpinnerProduit2.setAdapter(adapter2);
            SpinnerProduit3.setAdapter(adapter2);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

        public View.OnClickListener observateurclic = new View.OnClickListener() {

            // il manque l'activité liste

            public void onClick(View v) {


                Visite uneVisite =(Visite)  ((Spinner) findViewById(R.id.spinnerVisite)).getSelectedItem();
                Produit unmedicament1 = (Produit) ((Spinner)  findViewById(R.id.spinnerProduit1)).getSelectedItem() ;
                Produit unmedicament2 = (Produit) ((Spinner)  findViewById(R.id.spinnerProduit2)).getSelectedItem() ;
                Produit unmedicament3 = (Produit) ((Spinner)  findViewById(R.id.spinnerProduit3)).getSelectedItem() ;

                switch (v.getId()) {
                    case R.id.spinnerVisite:

                        break;


                    case R.id.btn_valider:

                       // final TextView mTextView = (TextView) findViewById(R.id.text_id);
                        String nom = Integer.toString(uneVisite.codePraticien);
                        String medicament1 = unmedicament1.getDesignationProduit();
                        String medicament2 = unmedicament2.getDesignationProduit();
                        String medicament3 = unmedicament3.getDesignationProduit();
                      //  mTextView.setText("code du medcin  " +nom +"  medicament 1: "+medicament1+"   "+ "medicament 2:"+medicament2 +"   " +"medicament 3 :"+"   "+ medicament3);
                        Toast.makeText(getApplicationContext(), " Vous avez selectionner une visite qui se fait :  "+ uneVisite.codePraticien+ "/" + uneVisite.codeVisite +medicament1 +"/"+medicament2 +"/"+medicament3,   Toast.LENGTH_SHORT).show();

                        JSONObject object = new JSONObject();
                        try {
                            object.put("codePraticien", nom);
                            object.put("codeVisite", uneVisite.codeVisite);
                            object.put("codeMedicament1", unmedicament1.getCodeProduit());
                            object.put("codeMedicament2", unmedicament2.getCodeProduit());
                            object.put("codeMedicament3", unmedicament3.getCodeProduit());

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                            Exportation tacheExport = new Exportation();

                            tacheExport.execute("http://172.21.105.4/android/ExportPrescription.php",object.toString());
                            //tacheExport.execute("http://10.0.3.2:88/ppe/ExportPrescription.php",object.toString());
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
                        Intent menu= new Intent(getApplicationContext(), menu.class);
                        Bundle b = getIntent().getExtras();
                        String log = b.getString("log");
                        String pwd = b.getString("pwd");
                        menu.putExtra("log", log);
                        menu.putExtra("pwd", pwd);
                        startActivity(menu);

                        break;
                    case R.id.btn_ok:
                        break;
                }
            }


        };
    }

