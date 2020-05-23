package com.example.smartmailbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Principal extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
       bottomNavigationView=findViewById(R.id.botton_navigation);
       bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Buzon:
                Intent b = new Intent(Principal.this,Buzon.class);
                startActivity(b);
                overridePendingTransition(0,0);
                return (true);
            case R.id.Home:
                Intent i = new Intent(Principal.this,Principal.class);
                startActivity(i);
                overridePendingTransition(0,0);
                return (true);
            case R.id.PerfilUsuario:
                Intent p = new Intent(Principal.this,PerfilUsuario.class);
                startActivity(p);
                overridePendingTransition(0,0);
                return (true);

        }
        return false;
    }
}
