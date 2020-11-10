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
            String url = String.format("jdbc:jtds:sqlserver://smartmailbox.database.windows.net:1433/SmartMailboxCL;user=Huruz;password=90637551LoL;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
            conn = DriverManager.getConnection(url);
            //conn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.0.4;databaseName=SmartMailbox;user=sa;password=90637551lol;");
            //conn = DriverManager.getConnection("jdbc:sqlserver://smartmailbox.database.windows.net:1433;databaseName=SmartMailboxCL;user=Huruz@smartmailbox;password=90637551LoL;");
            //conn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.0.3;databaseName=SmartMailbox;user=sa;password=90687551lol;");
            //jdbc:sqlserver://smartmailbox.database.windows.net:1433;database=SmartMailboxCL;user=Huruz@smartmailbox;password=90637551LoL;
        }catch (Exception e ){

        }
        return conn;
    }

}
