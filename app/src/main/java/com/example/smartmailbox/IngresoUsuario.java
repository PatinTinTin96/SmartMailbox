package com.example.smartmailbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class IngresoUsuario extends AppCompatActivity {
TextView txtCrearCuenta;
EditText  edtUsuario,edtContraseña;
Button btnLogin,btnCrearUsuario;
ImageView ImagenLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ingreso_usuario);
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
        Intent l = new Intent(IngresoUsuario.this,Principal.class);
        startActivity(l);
    }

    private void registrar() {
        Intent r = new Intent(IngresoUsuario.this,RegistroUsuario.class);
        startActivity(r);
    }


}
