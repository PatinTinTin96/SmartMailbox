package com.example.smartmailbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    Animation topAnim,bottomAnim;
    ImageView imgLogo;
    TextView txtLogo;
    private static int splash = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_amimation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        imgLogo = findViewById(R.id.imgLogo);
        txtLogo = findViewById(R.id.txtLogo);

        imgLogo.setAnimation(topAnim);
        txtLogo.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               // if (ontouch == false) {
                    Intent inicio = new Intent(SplashScreen.this, IngresoUsuario.class);
                    startActivity(inicio);
                    finish();
                //}
            }
        }, splash);
    }
/*
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction()==MotionEvent.ACTION_UP){
            ontouch = true;
            startActivity(new Intent(SplashScreen.this,IngresoUsuario.class));
            finish();
            return true;
        }
        return false;
    }

 */
}
