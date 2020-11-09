package com.example.smartmailbox.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartmailbox.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class prueba extends AppCompatActivity {
Button btnRegion;
EditText edtRegion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);
        edtRegion= findViewById(R.id.edtRegion);
        btnRegion= findViewById(R.id.btnRegion);
        btnRegion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarUsuario();
            }
        });
    }

    public Connection conexion(){
        Connection conn = null;
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.0.14;databaseName=SmartMailbox;user=sa;password=marlyn96;");
        }catch (Exception e ){

        }
        return conn;
    }

    public  void agregarUsuario(){
        try {
            PreparedStatement stm = conexion().prepareStatement("insert into REGION values (?)");
            stm.setString(1,edtRegion.getText().toString());
            stm.executeUpdate();

            Toast.makeText(getApplicationContext(),"Exito",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
        }

    }



}