package com.example.smartmailbox.Control;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public Connection conexion(){
        Connection conn = null;
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.0.4;databaseName=SmartMailbox;user=sa;password=90637551lol;");
            //conn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.0.3;databaseName=SmartMailbox;user=sa;password=90687551lol;");
        }catch (Exception e ){

        }
        return conn;
    }

}
