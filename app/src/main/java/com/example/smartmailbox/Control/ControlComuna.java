package com.example.smartmailbox.Control;

import android.widget.ArrayAdapter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.smartmailbox.Modelo.Comuna;
import com.example.smartmailbox.Modelo.DbConnection;

import static com.example.smartmailbox.Control.ControlUsuario.conn;

public class ControlComuna {
    public static DbConnection conn = new DbConnection();

    public static List<Comuna> listaComuna(){

        try {
            PreparedStatement stm = conn.conexion().prepareStatement("SELECT nombre_comuna FROM Comuna where id_provincia=25");
            stm.executeUpdate();
            ResultSet rs = stm.executeQuery();
            stm.close();

        } catch (SQLException e) {

        }
        return listaComuna();

    }
}
