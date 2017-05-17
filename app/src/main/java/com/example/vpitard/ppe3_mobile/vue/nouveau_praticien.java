package com.example.vpitard.ppe3_mobile.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vpitard.ppe3_mobile.R;
import com.example.vpitard.ppe3_mobile.network.Exportation;
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
        Button btn_ok = (Button) findViewById(R.id.btn_valider);
        btn_ok.setOnClickListener(observateurclic);
        Button btn_annuler = (Button) findViewById(R.id.btn_ok);
        btn_annuler.setOnClickListener(observateurclic);
        ImportationActivite importationActivite = new ImportationActivite();
        //importationActivite.execute("http://10.0.3.2:88/ppe/ImportActivite.php",log, pwd);
        importationActivite.execute("http://172.21.105.4/android/ImportActivite.php",log,pwd);
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
                String txt_secteur_praticien = String.valueOf(((EditText) findViewById(R.id.txt_secteur)).getText());


                Activite uneActivite =(Activite )((Spinner)findViewById(R.id.spinnerActivite)).getSelectedItem();
                switch (v.getId()) {
                    case R.id.btn_valider:
                        Toast.makeText(getApplicationContext(),
                                " Un praticien a ete ajouter au non de :  "+txt_nom_praticien+  " et au prenom de :  "+ txt_prenom_praticien +"sa profession est "+ uneActivite.getLibelle(),   Toast.LENGTH_SHORT).show();
                        JSONObject object = new JSONObject();
                        try {
                            object.put("prenomPraticien", txt_prenom_praticien);
                            object.put("nomPraticien",txt_nom_praticien );
                            object.put("secteurPraticien",txt_secteur_praticien);
                            object.put("codeAct",uneActivite.getcode() );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Exportation tacheExport = new Exportation();
                        //tacheExport.execute("http://10.0.3.2:88/ppe/ExportVisite.php",object.toString());
                        tacheExport.execute("http://172.21.105.4/android/ExportPraticien.php",object.toString());
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

