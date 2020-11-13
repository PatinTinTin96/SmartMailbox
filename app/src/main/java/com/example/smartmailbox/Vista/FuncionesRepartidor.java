package com.example.smartmailbox.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartmailbox.R;

public class FuncionesRepartidor extends AppCompatActivity {
Button btnQr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_repartidor);
        btnQr=findViewById(R.id.btnQr);

        btnQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qr();
            }
        });
    }

    private void qr() {
        Intent qr = new Intent(FuncionesRepartidor.this, LectorQr.class);
        startActivity(qr);
    }
}