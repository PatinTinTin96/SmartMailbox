package com.example.smartmailbox.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.smartmailbox.Control.ControlRepartidor;
import com.example.smartmailbox.R;
import com.google.android.material.textfield.TextInputLayout;

public class IngresoRepartidor extends AppCompatActivity {

    TextInputLayout edtRepartidor,edtPassRepartidor;
    Button btnLoginRepartidor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_repartidor);
        edtRepartidor=findViewById(R.id.IngreseNombreRepartidor);
        edtPassRepartidor=findViewById(R.id.IngresePassRepartidor);
        btnLoginRepartidor=findViewById(R.id.btnLoginRepartidor);

        btnLoginRepartidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logearRepartidor();
            }
        });
    }

    private void logearRepartidor() {
        String nomRepartidor = edtRepartidor.getEditText().getText().toString();
        String passRepartidor = edtPassRepartidor.getEditText().getText().toString();

        if(ControlRepartidor.loginRepartidor(nomRepartidor,passRepartidor)!=null){

            Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_LONG).show();
            Intent logRepartidor = new Intent(IngresoRepartidor.this, FuncionesRepartidor.class);
            startActivity(logRepartidor);
        }else {
            Toast.makeText(getApplicationContext(), "Usuario o Contraseña Incorrectos", Toast.LENGTH_LONG).show();
        }


    }



}