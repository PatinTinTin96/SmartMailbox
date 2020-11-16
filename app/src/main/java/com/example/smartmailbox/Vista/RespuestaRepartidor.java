package com.example.smartmailbox.Vista;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.smartmailbox.Control.ControlBuzon;
import com.example.smartmailbox.R;

public class RespuestaRepartidor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta_repartidor);
        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            String datos = parametros.getString("serie");
            cargarpreferencias();
            alert(datos);

        }


    }


    private void alert(final String datos) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Operar Buzón");
        alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
        alertDialog.setMessage("¿Desea operar el buzón?");

        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Sí", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                SharedPreferences preferences = getSharedPreferences("credenciales", MODE_PRIVATE);
                String nick = preferences.getString("nick","No data");
                String pass = preferences.getString("pass","No data");
                String name = preferences.getString("name","No data");
                String id = preferences.getString("id","No data");

                if (ControlBuzon.buscarBuzon(datos)!=null){
                    //if(ControlBuzon.asociarUsuario(Integer.parseInt(id),datos)==true){
                    //  Toast.makeText(getApplicationContext(), " Asociación exitosa", Toast.LENGTH_LONG).show();
                    //  Intent buzon = new Intent(Respuesta.this, Wifi_Connection.class);
                    //  startActivity(buzon);
                    // }
                    // Toast.makeText(getApplicationContext(), "Asociación fallida", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), " El buzon existe", Toast.LENGTH_LONG).show();
                    Intent buzon = new Intent(RespuestaRepartidor.this, Control_Mailbox.class);
                    startActivity(buzon);
                }else{
                    Toast.makeText(getApplicationContext(), " El buzon no existe", Toast.LENGTH_LONG).show();
                }

            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                Intent buzon = new Intent(RespuestaRepartidor.this, Wifi_Connection.class);
                startActivity(buzon);
            }
        });
        alertDialog.show();
    }


    public void cargarpreferencias(){
        SharedPreferences preferences = getSharedPreferences("credenciales", MODE_PRIVATE);
        String nick = preferences.getString("nick","No data");
        String pass = preferences.getString("pass","No data");
        String name = preferences.getString("name","No data");
       // String id = preferences.getString("id","No data");






    }
}