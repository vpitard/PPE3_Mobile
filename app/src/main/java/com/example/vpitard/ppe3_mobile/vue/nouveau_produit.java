package com.example.vpitard.ppe3_mobile.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vpitard.ppe3_mobile.R;
import com.example.vpitard.ppe3_mobile.network.Exportation;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * Created by MAEL on 26/11/2016.
 */

public class nouveau_produit extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        Bundle b = getIntent().getExtras();
        String log = b.getString("log");
        String pwd = b.getString("pwd");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nouveau_produit);
        Button btn_ok = (Button) findViewById(R.id.btn_valider);
        btn_ok.setOnClickListener(observateurclic);
        Button btn_annuler = (Button) findViewById(R.id.btn_ok);
        btn_annuler.setOnClickListener(observateurclic);




        }

        public View.OnClickListener observateurclic = new View.OnClickListener() {

            //classe pas fini a completer


            public void onClick(View v) {
                String txt_Designation_produit = String.valueOf(((EditText) findViewById(R.id.nomProduit)).getText());

                switch (v.getId()) {
                    case R.id.btn_valider:
                        Toast.makeText(getApplicationContext(), " Un produit a ete ajouter du nom :  "+ txt_Designation_produit ,    Toast.LENGTH_SHORT).show();


                        JSONObject object = new JSONObject();
                        try {
                            object.put("designationProduit", txt_Designation_produit);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Exportation tacheExport = new Exportation();
                        //tacheExport.execute("http://10.0.3.2:88/ppe/ExportProduit.php",object.toString());
                        tacheExport.execute("http://172.21.105.4/android/ExportProduit.php",object.toString());

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
                        Bundle b = getIntent().getExtras();
                        String log = b.getString("log");
                        String pwd = b.getString("pwd");
                        Intent menu= new Intent(getApplicationContext(), menu.class);
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


