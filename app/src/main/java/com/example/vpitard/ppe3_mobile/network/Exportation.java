package com.example.vpitard.ppe3_mobile.network;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Exportation extends AsyncTask<String,Void,Boolean> {
    @Override
    protected Boolean doInBackground(String... urls) {
        try {
            URL url = new URL(urls[0]);
            HttpURLConnection cnx = (HttpURLConnection) url.openConnection();
            cnx.setDoOutput(true);
            OutputStreamWriter osw = new OutputStreamWriter(cnx.getOutputStream());
            osw.write(urls[1]);
            osw.flush();
            osw.close();
//retour de la part du serveur
            int httpResult = cnx.getResponseCode();
            if (httpResult == HttpURLConnection.HTTP_OK) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}