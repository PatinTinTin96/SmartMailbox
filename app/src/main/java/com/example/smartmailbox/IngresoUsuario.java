package com.example.smartmailbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.StrictMode;
import android.se.omapi.Session;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartmailbox.Control.ControlUsuario;
import com.example.smartmailbox.Modelo.DbConnection;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.DriverManager;

public class IngresoUsuario extends AppCompatActivity {
TextView txtCrearCuenta;
TextInputLayout edtUsuario,edtContraseña;
Button btnLogin,btnCrearUsuario;
ImageView ImagenLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ingreso_usuario);
        edtUsuario= findViewById(R.id.IngreseNombre);
        edtContraseña=findViewById(R.id.IngreseContraseña);
        btnCrearUsuario=findViewById(R.id.btnCrearUsuario);
        btnLogin=findViewById(R.id.btnLogin);
        btnCrearUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logear();
            }
        });



    }



    private void logear() {
        String nick = edtUsuario.getEditText().getText().toString();
        String pass = edtContraseña.getEditText().getText().toString();
        if(ControlUsuario.loginUsuario(nick,pass)!=null){
            //Bundle us = new Bundle();
            //us.putString("Usuario", nick);
            Toast.makeText(getApplicationContext(), "Exito", Toast.LENGTH_LONG).show();
            Intent l = new Intent(IngresoUsuario.this,Principal.class);
            l.putExtra("Usuario",nick);
            startActivity(l);
        }else {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
        }


    }

    private void registrar() {
        Intent r = new Intent(IngresoUsuario.this,RegistroUsuario.class);
        startActivity(r);
    }


}
