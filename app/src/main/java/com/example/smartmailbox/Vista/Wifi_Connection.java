package com.example.smartmailbox.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.smartmailbox.R;

public class Wifi_Connection extends AppCompatActivity {
Button btnVincular,btnAccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi__connection);
        btnVincular=findViewById(R.id.btnVincular);
        btnAccion=findViewById(R.id.btnAccion);

        btnAccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acc();
            }
        });
        btnVincular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connect();
            }
        });

    }

    private void acc() {
        Intent mb = new Intent(this, Control_Mailbox.class);
        startActivity(mb);
    }

    private void connect() {
        Intent led = new Intent(this, LectorQrUsuario.class);
        startActivity(led);
    }


}