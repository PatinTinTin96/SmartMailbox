package com.example.smartmailbox.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartmailbox.Control.ControlUsuario;
import com.example.smartmailbox.Control.DbConnection;
import com.example.smartmailbox.R;
import com.google.android.material.textfield.TextInputLayout;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IngresoUsuario extends AppCompatActivity {
TextView txtCrearCuenta;
TextInputLayout edtUsuario,edtContraseña;

Button btnLogin,btnCrearUsuario,btnQr,btnIngresoRepartidor;


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

        btnQr=findViewById(R.id.btnQR);

        btnIngresoRepartidor=findViewById(R.id.btnIngresoRepartidor);

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
        btnIngresoRepartidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresoRepartidor();
            }
        });

         btnQr.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent qr = new Intent(IngresoUsuario.this, LectorQr.class);
                 startActivity(qr);
             }
         });

    }

    private void ingresoRepartidor() {
        Intent r = new Intent(IngresoUsuario.this, IngresoRepartidor.class);
        startActivity(r);
    }


    private void logear() {

        String nick = edtUsuario.getEditText().getText().toString();
        String pass = edtContraseña.getEditText().getText().toString();

        if(ControlUsuario.loginUsuario(nick,pass)!=null){
            guardarcredenciales();


            Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_LONG).show();
            Intent l = new Intent(IngresoUsuario.this, Principal.class);
            startActivity(l);
        }else {
           Toast.makeText(getApplicationContext(), "Usuario o Contraseña Incorrectos", Toast.LENGTH_LONG).show();
        }

    }



    private void registrar() {
        Intent r = new Intent(IngresoUsuario.this, RegistroUsuario.class);
        startActivity(r);
    }

    public void guardarcredenciales(){

        SharedPreferences preferences = getSharedPreferences("credenciales", MODE_PRIVATE);
        String nick = edtUsuario.getEditText().getText().toString();
        String pass = edtContraseña.getEditText().getText().toString();
      String nombre=null;
        DbConnection conn = new DbConnection();
        try {
            Statement stm = conn.conexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT nombre_usuario FROM Usuario where alias_usuario='" + nick + "' and contrasena_usuario='" + pass + "'");
            rs.next();
            String result = rs.getString("NOMBRE_USUARIO");
            if (result != null){
                nombre=result;
                rs.close();
                stm.close();
            }else{
                nombre="falló la conexión";
            }


            rs.close();
            stm.close();


        } catch (SQLException e) {

        }


        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("nick",nick);
        editor.putString("pass",pass);
        editor.putString("name",nombre);
        editor.commit();
    }




}
