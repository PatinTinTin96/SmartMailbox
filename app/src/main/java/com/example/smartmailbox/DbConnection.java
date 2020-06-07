package com.example.smartmailbox;

import android.os.StrictMode;

import java.nio.channels.ScatteringByteChannel;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
public Connection connection(){
   Connection conn = null;
    try{
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.26.1;databaseName=SmartMailbox;user=sa;password=marlyn96");
    }catch (Exception e ){

    }
    return conn;
}

}
