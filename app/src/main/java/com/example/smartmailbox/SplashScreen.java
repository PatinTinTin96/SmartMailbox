package com.example.smartmailbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;

public class SplashScreen extends AppCompatActivity {
    boolean ontouch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(ontouch==false) {
                    Intent inicio = new Intent(SplashScreen.this, IngresoUsuario.class);
                    startActivity(inicio);
                    finish();
                }
            }
        },5000);
    }

    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction()==MotionEvent.ACTION_UP){
            ontouch = true;
            startActivity(new Intent(SplashScreen.this,IngresoUsuario.class));
            finish();
            return true;
        }
        return false;
    }
}
