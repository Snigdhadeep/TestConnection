package com.techpenta.testconnectinternet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Snikdha on 2/7/2017.
 */

public class DownloadImage extends AsyncTask<String,Void,Bitmap> {

    Context context;
    public DownloadImage(Context ct){
        context=ct;

    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {

        MainActivity.img.setImageBitmap(bitmap);
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String built=strings[0];
        try {
            URL url=new URL(built);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.connect();
            InputStream is=conn.getInputStream();

            Bitmap imageBit= BitmapFactory.decodeStream(is);
            return imageBit;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
