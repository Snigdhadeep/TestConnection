package com.techpenta.testconnectinternet;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static  TextView tv;
    static Button button;
    static ImageView img;
    MyAsynctask myAsynctask;
    DownloadImage downloadImage;

    //for checking internet connection

    ConnectivityManager cm;
    NetworkInfo ni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       tv =(TextView)findViewById(R.id.txt);
        button=(Button)findViewById(R.id.btn);
        img=(ImageView)findViewById(R.id.imagebit);

        myAsynctask=new MyAsynctask(this);
        downloadImage=new DownloadImage(this);
        myAsynctask.execute("https://www.google.co.in");

        //for checking internet connection
        cm=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        ni=cm.getActiveNetworkInfo();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           if(ni!=null&&ni.isConnected()){
               downloadImage.execute("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQyh6Sh0zjhllB5AL1mDAi89qrExQfBlkj_iq0wVWTUKK5o4CP9");

           }
                else{

               Toast.makeText(MainActivity.this, "Connection is not available", Toast.LENGTH_SHORT).show();
           }
            }
        });


    }


}
