package com.example.my_application;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Thread splashThread  = new Thread(new Runnable() {
            @Override
            public void run() {


                try{


                    sleep(3000);
                    Intent i = new Intent(SplashScreen.this, DashBoardActivity.class);
                    startActivity(i);

                }
                catch(InterruptedException e)
                {
                     e.printStackTrace();
                }

            }
        });

        splashThread.start();
    }
}
