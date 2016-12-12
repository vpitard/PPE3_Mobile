package com.example.vpitard.ppe3_mobile.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vpitard.ppe3_mobile.R;
import com.example.vpitard.ppe3_mobile.network.Connexion;
import com.example.vpitard.ppe3_mobile.network.Importation;
import com.example.vpitard.ppe3_mobile.systeme.Visiteur;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //* test push mael*//
        Button btnConnexion = (Button) findViewById(R.id.btnConnexion);
        btnConnexion.setOnClickListener(observateurclic);
    }

    public View.OnClickListener observateurclic = new View.OnClickListener() {
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btnConnexion:

                    String log = String.valueOf(((EditText) findViewById(R.id.LoginTxt)).getText());
                    String pwd = String.valueOf(((EditText) findViewById(R.id.PwdTxt)).getText());
                    Connexion cnx = new Connexion();

                    System.out.println(log);
                    System.out.println(pwd);


                    cnx.execute("http://10.0.3.2:88//ppe/auth.php", log, pwd);

                    System.out.println(cnx);
                    try {
                        System.out.println(cnx);
                            //connexion base de données
                        if (cnx.get()) {
                            //importe les données
                            Importation importVisiteur = new Importation();
                            importVisiteur.execute("http://10.0.3.2:88/ppe/import.php",log, pwd);
                           ArrayList<Visiteur> listeVisiteur = importVisiteur.get();
                            if (listeVisiteur!=null) {
                                System.out.println(listeVisiteur.size());
                                System.out.println(listeVisiteur.get(1).getPrenom());
                                //System.out.println(listeVisiteur.get(0).getIdentifiant());
                                int nb;
                                for  (nb=0;nb<listeVisiteur.size();nb++){
                                //for(Visiteur visiteur:listeVisiteur){
                                    System.out.println("test prénom  :   "+ listeVisiteur.get(nb).getPrenom());
                                    if(log.equals(listeVisiteur.get(nb).getIdentifiant())&&(pwd.equals(listeVisiteur.get(nb).getMdp()))){
                                        String nomUtilisateur =listeVisiteur.get(nb).getNom();

                                        String prenomUtilisateur = listeVisiteur.get(nb).getPrenom();
                                        Intent i = new Intent(getApplicationContext(), menu.class);
                                        i.putExtra("log", log);
                                        i.putExtra("pwd", pwd);
                                        startActivity(i);
                                        Toast.makeText(getApplicationContext(),
                                                " Bonjour "+ nomUtilisateur+ " " +prenomUtilisateur , Toast.LENGTH_SHORT).show();
                                    }
                                }

                            }
                        } else {//Sinon
                            Toast.makeText(getApplicationContext(), "Echec de la connexion", Toast.LENGTH_LONG).show();
                        }
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }

    };
    }









