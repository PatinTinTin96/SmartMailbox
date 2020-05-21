package com.example.smartmailbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class IngresoUsuario extends AppCompatActivity {
TextView txtCrearCuenta;
EditText  edtUsuario,edtContraseña;
Button btnLogin;
ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_usuario);
        txtCrearCuenta= findViewById(R.id.txtCrearCuenta);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtContraseña= findViewById(R.id.edtContraseña);
        btnLogin= findViewById(R.id.btnLogin);
        imgLogo = findViewById(R.id.imgLogo);

        txtCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrearCuenta();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logearse();
            }
        });


    }

    private void logearse() {
        Intent login = new Intent(IngresoUsuario.this,Principal.class);
        startActivity(login);
    }


    private void CrearCuenta() {
        Intent cuenta = new Intent(IngresoUsuario.this,RegistroUsuario.class);
        startActivity(cuenta);
    }


}
