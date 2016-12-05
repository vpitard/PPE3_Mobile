package com.example.vpitard.ppe3_mobile.network;

/**
 * Created by MAEL on 21/11/2016.
 */

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *document qui provient du ds blizzcon a modifier
 */
public class Connexion extends AsyncTask<String,Void,Boolean> {
    @Override
    protected Boolean doInBackground(String... params) {
        try {
            URL url=new URL(params[0]);
            HttpURLConnection cnx = (HttpURLConnection)url.openConnection();
            cnx.setRequestMethod("POST");
            cnx.setDoOutput(true);
            OutputStreamWriter osw = new OutputStreamWriter(cnx.getOutputStream());
            osw.write("login="+params[1]+"&passwd="+params[2]);
            osw.flush();
            osw.close();
            int httpResult=cnx.getResponseCode();
            if(httpResult==HttpURLConnection.HTTP_OK){
                InputStreamReader isr = new InputStreamReader(cnx.getInputStream());
                BufferedReader buff = new BufferedReader(isr);
                String ligne=buff.readLine();
                return ligne.equals("connect");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
