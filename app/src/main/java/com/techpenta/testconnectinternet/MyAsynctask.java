package com.techpenta.testconnectinternet;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Snikdha on 2/7/2017.
 */

public class MyAsynctask extends AsyncTask<String,Void,String> {

    Context context;
    public MyAsynctask(Context ct){

        context=ct;
    }



    @Override
    protected String doInBackground(String... strings) {

        String built=strings[0];
        try {
            URL requestUrl=new URL(built);
            HttpURLConnection conn=(HttpURLConnection)requestUrl.openConnection();
            conn.setConnectTimeout(10000);
            conn.connect();

            InputStream is=conn.getInputStream();
            BufferedReader bf=new BufferedReader(new InputStreamReader(is));
            StringBuilder sb=new StringBuilder();
            String line;

            while((line=bf.readLine())!=null){

                sb.append(line+"/n");
            }

            bf.close();
            is.close();
            return sb.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
       MainActivity.tv.setText(s);
    }
}
