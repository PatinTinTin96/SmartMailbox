package com.example.smartmailbox.Vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.smartmailbox.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Principal extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
       bottomNavigationView=findViewById(R.id.botton_navigation);
       bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.Home);
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Buzon:
                Intent b = new Intent(Principal.this, Wifi_Connection.class);
                startActivity(b);
                overridePendingTransition(0,0);
                return (true);
            case R.id.Home:

                return (true);
            case R.id.PerfilUsuario:
                Intent p = new Intent(Principal.this, PerfilUsuario.class);
                startActivity(p);
                overridePendingTransition(0,0);

                return (true);

        }
        return false;
    }

}
