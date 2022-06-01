package com.rizky_02736.desemar;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int waktu_loading=6000;
    TextView judul,judul2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        judul = findViewById(R.id.judul);
        judul2 = findViewById(R.id.judul2);
        new Handler().postDelayed(new Runnable() {

            @Override

            public void run() {
                //setelah loading maka akan langsung berpindah ke home activity
                Intent Dashboard=new Intent(MainActivity.this, Dashboard.class);
                startActivity(Dashboard);
                //startAnimation();
                finish();

            }

        },waktu_loading);
    }
}