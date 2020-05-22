package com.example.smartmailbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PerfilUsuario extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        bottomNavigationView=findViewById(R.id.botton_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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
                        Intent p = new Intent(PerfilUsuario.this,PerfilUsuario.class);
                        startActivity(p);
                        overridePendingTransition(0,0);
                        return (true);

                }
                return false;
            }
        });
    }
}
