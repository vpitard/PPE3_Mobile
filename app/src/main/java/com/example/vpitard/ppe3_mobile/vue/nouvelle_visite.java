package com.example.vpitard.ppe3_mobile.vue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vpitard.ppe3_mobile.R;
import com.example.vpitard.ppe3_mobile.network.ImportationPraticien;
import com.example.vpitard.ppe3_mobile.network.ImportationProduit;
import com.example.vpitard.ppe3_mobile.systeme.Praticien;
import com.example.vpitard.ppe3_mobile.systeme.Produit;
import com.example.vpitard.ppe3_mobile.systeme.praticienAdapter;
import com.example.vpitard.ppe3_mobile.systeme.produitAdapter;

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

        importPraticien.execute("http://10.0.3.2:88/ppe/ImportPraticien.php",log, pwd);
        ImportationProduit importProduit = new ImportationProduit();
        importProduit.execute("http://10.0.3.2:88/ppe/importProduit.php",log, pwd);
        try {
            ArrayList<Praticien> listePraticien = importPraticien.get();
            ArrayList<Produit> listeProduit = importProduit.get();

            praticienAdapter adapter = new praticienAdapter(getApplicationContext(), listePraticien);
            produitAdapter adapterProduit = new produitAdapter(getApplicationContext(),listeProduit);
            Spinner SpinnerPraticien = (Spinner) findViewById(R.id.SpinnerPraticien);
            SpinnerPraticien.setAdapter(adapter);

        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
       // SpinnerPraticien.setOnItemSelectedListener(observateurclic);


      //  List<String> liste = new ArrayList<String>();
        //liste.add("test1");
        //liste.add("test2");
        //liste.add("test3");

        // Create an ArrayAdapter using the string array and a default spinner layout
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, liste);
        // Specify the layout to use when the list of choices appears
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        //spinnerPraticien.setAdapter(adapter);

    }

    public View.OnClickListener observateurclic = new View.OnClickListener() {

        //checkedtext mystere pour l'instant

    public void onClick(View v) {

         Object unPraticien = ((Spinner)findViewById(R.id.SpinnerPraticien)).getSelectedItem();




        DatePicker datePicker1 = (DatePicker) findViewById(R.id.datePicker2);
        switch (v.getId()) {

            case R.id.btn_ok:

                int mois = +datePicker1.getMonth()+1;
                String date = datePicker1.getDayOfMonth()+"/"+mois+"/"+datePicker1.getYear();

                Toast.makeText(getApplicationContext(),
                        " Vous avez selectionner "+ unPraticien.toString()+" la date est :" + date,   Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_annuler:
                break;

        }
    }
    };

}
