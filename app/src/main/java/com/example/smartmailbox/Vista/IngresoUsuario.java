package com.example.smartmailbox.Vista;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartmailbox.Control.FirebaseService;
import com.example.smartmailbox.Control.RegistrationIntentService;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import com.example.smartmailbox.Control.ControlUsuario;
import com.example.smartmailbox.Control.DbConnection;
import com.example.smartmailbox.R;
import com.google.android.material.textfield.TextInputLayout;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IngresoUsuario extends AppCompatActivity {
    public static IngresoUsuario mainActivity;
    public static Boolean isVisible = false;
    private static final String TAG = "MainActivity";
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
TextView txtCrearCuenta;
TextInputLayout edtUsuario,edtContraseña;

Button btnLogin,btnCrearUsuario,btnQr,btnIngresoRepartidor;


ImageView ImagenLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ingreso_usuario);
        mainActivity = this;
        registerWithNotificationHubs();
        FirebaseService.createChannelAndHandleNotifications(getApplicationContext());
        edtUsuario= findViewById(R.id.IngreseNombre);
        edtContraseña=findViewById(R.id.IngreseContraseña);
        btnCrearUsuario=findViewById(R.id.btnCrearUsuario);
        btnLogin=findViewById(R.id.btnLogin);

        btnQr=findViewById(R.id.btnQR);

        btnIngresoRepartidor=findViewById(R.id.btnIngresoRepartidor);

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
        btnIngresoRepartidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresoRepartidor();
            }
        });

         btnQr.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent qr = new Intent(IngresoUsuario.this, LectorQr.class);
                 startActivity(qr);
             }
         });

    }
    /**
     * Check the device to make sure it has the Google Play Services APK. If
     * it doesn't, display a dialog box that enables  users to download the APK from
     * the Google Play Store or enable it in the device's system settings.
     */

    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST)
                        .show();
            } else {
                Log.i(TAG, "This device is not supported by Google Play Services.");
                ToastNotify("This device is not supported by Google Play Services.");
                finish();
            }
            return false;
        }
        return true;
    }
    public void registerWithNotificationHubs()
    {
        if (checkPlayServices()) {
            // Start IntentService to register this application with FCM.
            Intent intent = new Intent(this, RegistrationIntentService.class);
            startService(intent);
        }
    }

    private void ingresoRepartidor() {
        Intent r = new Intent(IngresoUsuario.this, IngresoRepartidor.class);
        startActivity(r);
    }


    private void logear() {

        String nick = edtUsuario.getEditText().getText().toString();
        String pass = edtContraseña.getEditText().getText().toString();

        if(ControlUsuario.loginUsuario(nick,pass)!=null){
            guardarcredenciales();


            Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_LONG).show();
            Intent l = new Intent(IngresoUsuario.this, Principal.class);
            startActivity(l);
        }else {
           Toast.makeText(getApplicationContext(), "Usuario o Contraseña Incorrectos", Toast.LENGTH_LONG).show();
        }

    }



    private void registrar() {
        Intent r = new Intent(IngresoUsuario.this, RegistroUsuario.class);
        startActivity(r);
    }

    public void guardarcredenciales(){

        SharedPreferences preferences = getSharedPreferences("credenciales", MODE_PRIVATE);
        String nick = edtUsuario.getEditText().getText().toString();
        String pass = edtContraseña.getEditText().getText().toString();
      String nombre=null;
        DbConnection conn = new DbConnection();
        try {
            Statement stm = conn.conexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT nombre_usuario FROM Usuario where alias_usuario='" + nick + "' and contrasena_usuario='" + pass + "'");
            rs.next();
            String result = rs.getString("NOMBRE_USUARIO");
            if (result != null){
                nombre=result;
                rs.close();
                stm.close();
            }else{
                nombre="falló la conexión";
            }


            rs.close();
            stm.close();


        } catch (SQLException e) {

        }


        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("nick",nick);
        editor.putString("pass",pass);
        editor.putString("name",nombre);
        editor.commit();
    }
    @Override
    protected void onStart() {
        super.onStart();
        isVisible = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isVisible = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isVisible = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isVisible = false;
    }

    public void ToastNotify(final String notificationMessage) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(IngresoUsuario.this, notificationMessage, Toast.LENGTH_LONG).show();
                TextView helloText = (TextView) findViewById(R.id.text_hello);
                helloText.setText(notificationMessage);
            }
        });
    }




}
