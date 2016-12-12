package com.example.vpitard.ppe3_mobile.network;

import android.os.AsyncTask;
import android.util.Log;

import com.example.vpitard.ppe3_mobile.systeme.Visiteur;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by MAEL on 05/12/2016.
 */

public class Importation extends  AsyncTask<String,Void,ArrayList<Visiteur>> {
    @Override
    protected ArrayList<Visiteur> doInBackground(String... params) {


        try {

           URL url = new URL(params[0]);
            ArrayList<Visiteur> listeVisiteur;
            HttpURLConnection cnx = (HttpURLConnection)url.openConnection();
            cnx.setRequestMethod("POST");
            cnx.setDoOutput(true);
            System.out.println("test connexion premier");
            OutputStreamWriter osw = new OutputStreamWriter(cnx.getOutputStream());
            osw.write("login="+params[1]+"&passwd="+params[2]);

            osw.flush();
            osw.close();

            int httpResult=cnx.getResponseCode();
            if(httpResult== HttpURLConnection.HTTP_OK){
                System.out.println("test connexion" +httpResult);
                InputStreamReader isr = new InputStreamReader(cnx.getInputStream());
                BufferedReader buff = new BufferedReader(isr);

                String ligne=buff.readLine();
                System.out.println(ligne);
                Gson gson=new Gson();
                listeVisiteur =
                        gson.fromJson(ligne,new TypeToken<ArrayList<Visiteur>>(){}.getType());
                return listeVisiteur;


            }

        } catch (IOException e) {
            Log.i("Parseur", "Problème I/O " + e.getMessage());
        }
        return null;
    }
}

