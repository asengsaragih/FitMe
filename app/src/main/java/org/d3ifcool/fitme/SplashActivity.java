package org.d3ifcool.fitme;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(2000);
                } catch (InterruptedException e) {

                }finally {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}
