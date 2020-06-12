package com.example.smartmailbox.Control;

import android.util.Log;
import android.widget.ArrayAdapter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.smartmailbox.Modelo.Comuna;
import com.example.smartmailbox.Modelo.DbConnection;

import androidx.lifecycle.ViewModelStoreOwner;

import static com.example.smartmailbox.Control.ControlUsuario.conn;

public class ControlComuna {
    public static DbConnection conn = new DbConnection();

    public static ArrayList<Comuna> listaComuna() {
        ArrayList<Comuna> comunas = new ArrayList<>();
        Comuna com = null;
        List<Comuna> listado = new ArrayList();
        try {
            Statement stm = conn.conexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT nombre_comuna FROM Comuna where id_provincia=25");
            while (rs.next()) {
                com = new Comuna();
                com.setNombreComuna(rs.getString(1));
                comunas.add(com);


            }
            rs.close();
            stm.close();


        } catch (SQLException e) {

        }


        return comunas;


    }

    public static ArrayList<String> listado() {
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Seleccione");
        for (int i = 0; i < ControlComuna.listaComuna().size(); i++) {
            lista.add(ControlComuna.listaComuna().get(i).getNombreComuna());
        }
   return lista;
    }


}
