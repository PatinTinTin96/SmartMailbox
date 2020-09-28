package com.example.smartmailbox.Control;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class InteractionOn extends AsyncTask<Void,Void,String>  {
    public static String texr ="192.168.0.12";
    @Override
    protected String doInBackground(Void... voids) {

        try {

            URL url = new URL("http://192.168.0.12/led1on");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }
        catch (MalformedURLException e){

        }

        catch (IOException e){
            e.printStackTrace();
        }


        return null;
    }
    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
    }



}

