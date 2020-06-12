package com.example.smartmailbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
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
ArrayList<Comuna> listadosComunas;
    ArrayList<String> lista;
static int comuna = 1;
static int mailbox = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registro_usuario);

        edtNombreUsuario=findViewById(R.id.nombreUsuario);
        edtNickUsuario=findViewById(R.id.nickUsuario);
        edtEmailUsuario=findViewById(R.id.correoUsuario);
        edtTelefonoUsuario=findViewById(R.id.telefonoUsuario);
        edtDireccionUsuario=findViewById(R.id.direccionUsuario);
        edtContraseña=findViewById(R.id.contraseñaUsuario);
        edtConfirmarContraseña=findViewById(R.id.confirmarContraseña);
        ddlComunas=findViewById(R.id.ddlComuna);
        btnRegistrar=findViewById(R.id.btnRegistrar);

     
       ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,ControlComuna.listaComuna());
       ddlComunas.setAdapter(arrayAdapter);


        ddlComunas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre =edtNombreUsuario.getEditText().getText().toString();
                String nick =edtNickUsuario.getEditText().getText().toString();
                String email =edtEmailUsuario.getEditText().getText().toString();
                String tel =edtTelefonoUsuario.getEditText().getText().toString();
                String dir = edtDireccionUsuario.getEditText().getText().toString();
                String pass= edtContraseña.getEditText().getText().toString();
              //  agregarUsuario(edtNombreUsuario.getEditText().toString(),edtNickUsuario.getEditText().toString(),edtEmailUsuario.getEditText().toString(),edtTelefonoUsuario.getEditText().toString(),edtDireccionUsuario.getEditText().toString(),pass,Comuna,mailbox);
                if (ControlUsuario.agregarUsuario(nombre,nick,email,tel,dir,pass,comuna,mailbox)){
                    Toast.makeText(getApplicationContext(),"Exito",Toast.LENGTH_LONG).show();
                }else {

                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }

                /*
                if (ControlUsuario.agregarUsuario(nombre,nick,email,tel,dir,pass,Comuna,mailbox)){
                    Toast.makeText(getApplicationContext(),"Exito",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }


                 */




            }
        });



    }/*
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
    */

    private ArrayList obtenerLista() {
     lista = new ArrayList<String>();
     lista.add("Seleccione");
     for (int i =0;i<lista.size();i++){
       lista.add(ControlComuna.listaComuna().get(i).getNombreComuna());
     }
      return lista;
    }
/*
    public  void agregarUsuario(String nombreUsuario, String nickUsuario, String emailUsuario, String telefonoUsuario, String direccionUsuario, String contraseñaUsuario, int comuna,int mailbox){

        try {
            PreparedStatement stm = conexion().prepareStatement("insert into Usuario values (?,?,?,?,?,?,?,?)");
            stm.setInt(1,comuna);
            stm.setInt(2,mailbox);
            stm.setString(3,nombreUsuario);
            stm.setString(4,nickUsuario);
            stm.setString(5,emailUsuario);
            stm.setString(6,telefonoUsuario);
            stm.setString(7,direccionUsuario);
           stm.setString(8,contraseñaUsuario);

            stm.executeUpdate();
            Toast.makeText(getApplicationContext(),"Exito",Toast.LENGTH_LONG).show();
            stm.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
        }

    }


 */

    private void registrar() {
        Intent r = new Intent(RegistroUsuario.this,IngresoUsuario.class);
        startActivity(r);
    }


}
