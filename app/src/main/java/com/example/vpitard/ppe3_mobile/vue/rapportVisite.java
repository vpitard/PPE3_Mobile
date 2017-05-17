package com.example.vpitard.ppe3_mobile.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vpitard.ppe3_mobile.R;
import com.example.vpitard.ppe3_mobile.network.Exportation;
import com.example.vpitard.ppe3_mobile.network.ImportationProduitPrescrit;
import com.example.vpitard.ppe3_mobile.network.ImportationVisite;
import com.example.vpitard.ppe3_mobile.systeme.Produit;
import com.example.vpitard.ppe3_mobile.systeme.Visite;
import com.example.vpitard.ppe3_mobile.systeme.visiteAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by MAEL on 19/04/2017.
 */

public class rapportVisite extends AppCompatActivity {
    private ArrayList<Produit> listeProduitPrescritf = new ArrayList<>() ;
    protected void onCreate(Bundle savedInstanceState) {


        Bundle b = getIntent().getExtras();
        String log = b.getString("log");
        String pwd = b.getString("pwd");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.rapport_visite_vue);
        Button btn_valider= (Button) findViewById(R.id.btn_valider);
        btn_valider.setOnClickListener(observateurclic);
        Button btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(observateurclic);

        ImportationVisite importVisite = new ImportationVisite();
       // importVisite.execute("http://10.0.3.2:88/ppe/ImportVisiteRapport.php", log, pwd);
        importVisite.execute("http://172.21.105.4/android/ImportVisiteRapport.php", log, pwd);

        try {
            ArrayList<Visite> listeVisite = importVisite.get();
            visiteAdapter adapter = new visiteAdapter(getApplicationContext(), listeVisite);

            Spinner SpinnerVisite = (Spinner) findViewById(R.id.spinnerVisite);
            SpinnerVisite.setAdapter(adapter);
            Spinner SpinnerConsigne1 = (Spinner) findViewById(R.id.consigne1);
            Spinner SpinnerConsigne2 = (Spinner) findViewById(R.id.consigne2);
            Spinner SpinnerConsigne3 = (Spinner) findViewById(R.id.consigne3);
            String[] consigne = new String[]{"Comprehensible", "Imcomprehensible", "Pas-clair"};
            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, consigne);
            SpinnerConsigne1.setAdapter(adapter2);
            SpinnerConsigne2.setAdapter(adapter2);
            SpinnerConsigne3.setAdapter(adapter2);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public View.OnClickListener observateurclic = new View.OnClickListener() {


        // il manque l'activité liste


        public void onClick(View v) {
            Visite uneVisite = (Visite) ((Spinner) findViewById(R.id.spinnerVisite)).getSelectedItem();
            String consigne1 = ((Spinner) findViewById(R.id.consigne1)).getSelectedItem().toString();
            String consigne2 = ((Spinner) findViewById(R.id.consigne2)).getSelectedItem().toString();
            String consigne3 = ((Spinner) findViewById(R.id.consigne3)).getSelectedItem().toString();

            switch (v.getId()) {

                case R.id.btn_valider:
                    Bundle b = getIntent().getExtras();
                    String log = b.getString("log");
                    String pwd = b.getString("pwd");
                    String code = Integer.toString(uneVisite.getCodeVisite());


                    TextView m1 = (TextView) findViewById(R.id.medicament1);
                    TextView m2 = (TextView) findViewById(R.id.medicament2);
                    TextView m3 = (TextView) findViewById(R.id.medicament3);
                    ImportationProduitPrescrit importationProduitPrescrit = new ImportationProduitPrescrit();
                    //importationProduitPrescrit.execute("http://10.0.3.2:88/ppe/ImportProduitPrescrit.php", log, pwd, code);

                    importationProduitPrescrit.execute("http://172.21.105.4/android/ImportProduitPrescrit.php", log, pwd, code);
                    try {
                        ArrayList<Produit> listeProduitPrescrit = importationProduitPrescrit.get();

                        for (int i = 0; i < listeProduitPrescrit.size(); i++) {
                            Toast.makeText(getApplicationContext(), "medicament" + listeProduitPrescrit.get(i).getDesignationProduit(), Toast.LENGTH_SHORT).show();
                        }

                        m1.setText(listeProduitPrescrit.get(0).getDesignationProduit());
                        listeProduitPrescritf.add(listeProduitPrescrit.get(0));
                        m1.setText(listeProduitPrescritf.get(0).getDesignationProduit());
                        m2.setText(listeProduitPrescrit.get(1).getDesignationProduit());
                        listeProduitPrescritf.add(listeProduitPrescrit.get(1));
                        m3.setText(listeProduitPrescrit.get(2).getDesignationProduit());
                        listeProduitPrescritf.add(listeProduitPrescrit.get(2));
                        //m3.setText(String.valueOf(listeProduitPrescritf.size()));
                        //importProduit.execute("http://172.21.105.3/android/ImportProduitPrescrit.php", log, pwd);
                        Toast.makeText(getApplicationContext(), " Vous avez selectionner une visite qui se fait :  " + uneVisite.getCodeVisite(), Toast.LENGTH_SHORT).show();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    break;

                case R.id.btn_ok:
                    Bundle c = getIntent().getExtras();
                    String log1 = c.getString("log");
                    String pwd1 = c.getString("pwd");

                    SeekBar noteMedic1 = null;
                    SeekBar noteMedic2 = null;
                    SeekBar noteMedic3 = null;
                    noteMedic1 = (SeekBar) findViewById(R.id.noteM1);
                    noteMedic2 = (SeekBar) findViewById(R.id.noteM2);
                    noteMedic3 = (SeekBar) findViewById(R.id.noteM3);
                    int codeM1 = listeProduitPrescritf.get(0).getCodeProduit();
                    int codeM2 = listeProduitPrescritf.get(1).getCodeProduit();
                    int codeM3 = listeProduitPrescritf.get(2).getCodeProduit();

                    JSONObject object = new JSONObject();

                    try {
                        object.put("codePraticien",uneVisite.getCodePraticien());
                        object.put("codeVisite",uneVisite.getCodeVisite() );
                        object.put("codeMed1",codeM1);
                        object.put("noteM1",noteMedic1.getProgress());
                        object.put("consigne1",consigne1);
                        object.put("codeMed2",codeM2);
                        object.put("consigne2",consigne2);
                        object.put("noteM2",noteMedic2.getProgress());
                        object.put("codeMed3",codeM3);
                        object.put("consigne3",consigne3);
                        object.put("noteM3",noteMedic3.getProgress());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getApplicationContext(), "cela fonctionnne  " +   object, Toast.LENGTH_SHORT).show();
                    Exportation tacheExport = new Exportation();

                    tacheExport.execute("http://172.21.105.4/android/ExportResultat.php",object.toString());
                    //tacheExport.execute("http://10.0.3.2:88/ppe/ExportResultat.php",object.toString());
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
                    menu.putExtra("log", log1);
                    menu.putExtra("pwd", pwd1);
                    startActivity(menu);
                    break;
            }


        }

        ;
    };
}