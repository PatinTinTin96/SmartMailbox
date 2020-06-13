package com.example.smartmailbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.smartmailbox.Control.ControlComuna;
import com.example.smartmailbox.Control.ControlUsuario;
import com.example.smartmailbox.Modelo.Comuna;
import com.example.smartmailbox.Modelo.DbConnection;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegistroUsuario extends AppCompatActivity {

 Spinner ddlComunas;
 TextInputLayout edtNombreUsuario,edtNickUsuario,edtEmailUsuario,edtTelefonoUsuario,edtDireccionUsuario,edtContraseña,edtConfirmarContraseña;
Button btnRegistrar;
int comuna;
static int mailbox = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registro_usuario);

        edtNombreUsuario = findViewById(R.id.nombreUsuario);
        edtNickUsuario = findViewById(R.id.nickUsuario);
        edtEmailUsuario = findViewById(R.id.correoUsuario);
        edtTelefonoUsuario = findViewById(R.id.telefonoUsuario);
        edtDireccionUsuario = findViewById(R.id.direccionUsuario);
        edtContraseña = findViewById(R.id.contraseñaUsuario);
        edtConfirmarContraseña = findViewById(R.id.confirmarContraseña);
        ddlComunas = findViewById(R.id.ddlComuna);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ControlComuna.listado());
        ddlComunas.setAdapter(arrayAdapter);


        ddlComunas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position!=0){
                    comuna = position;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edtNombreUsuario.getEditText().getText().toString();
                String nick = edtNickUsuario.getEditText().getText().toString();
                String email = edtEmailUsuario.getEditText().getText().toString();
                String tel = edtTelefonoUsuario.getEditText().getText().toString();
                String dir = edtDireccionUsuario.getEditText().getText().toString();
                String pass = edtContraseña.getEditText().getText().toString();

                if (ControlUsuario.agregarUsuario(nombre, nick, email, tel, dir, pass, comuna, mailbox)) {
                    Toast.makeText(getApplicationContext(), "Exito", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }




            }
        });


    }


    private void registrar() {
        Intent r = new Intent(RegistroUsuario.this,IngresoUsuario.class);
        startActivity(r);
    }


}
