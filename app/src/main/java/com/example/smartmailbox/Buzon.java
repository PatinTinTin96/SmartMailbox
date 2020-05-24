package com.example.smartmailbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Buzon extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzon);

        bottomNavigationView=findViewById(R.id.botton_navigation);
        bottomNavigationView.setSelectedItemId(R.id.Buzon);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Buzon:
                return (true);
            case R.id.Home:
                Intent i = new Intent(Buzon.this,Principal.class);
                startActivity(i);
                overridePendingTransition(0,0);
                return (true);
            case R.id.PerfilUsuario:
                Intent p = new Intent(Buzon.this,PerfilUsuario.class);
                startActivity(p);
                overridePendingTransition(0,0);
                return (true);

        }
        return false;
    }
}
