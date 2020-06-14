package com.example.smartmailbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;

public class PerfilUsuario extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    TextInputLayout edtnombre,edtNick,edtPass;

    Button btnActualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        bottomNavigationView=findViewById(R.id.botton_navigation);
        bottomNavigationView.setSelectedItemId(R.id.PerfilUsuario);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        edtnombre=findViewById(R.id.edtNombre);
        edtNick=findViewById(R.id.edtNick);
        edtPass=findViewById(R.id.edtPass);
        btnActualizar=findViewById(R.id.btnActualizar);

        Bundle extra = getIntent().getExtras();
        if(extra!=null){
            String us = extra.getString("Usuario");
            edtNick.getEditText().setText(us);
        }


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Buzon:
                Intent b = new Intent(PerfilUsuario.this,Buzon.class);
                startActivity(b);
                overridePendingTransition(0,0);
                return (true);
            case R.id.Home:
                Intent i = new Intent(PerfilUsuario.this,Principal.class);
                startActivity(i);
                overridePendingTransition(0,0);
                return (true);
            case R.id.PerfilUsuario:

                return (true);

        }
        return false;
    }
}
