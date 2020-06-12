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

import androidx.lifecycle.ViewModelStoreOwner;

import static com.example.smartmailbox.Control.ControlUsuario.conn;

public class ControlComuna {
    public static DbConnection conn = new DbConnection();

    public static ArrayList<Comuna> listaComuna(){
        ArrayList<Comuna> comunas = new ArrayList<>();
        Comuna com = new Comuna();
        List<Comuna> listado = new ArrayList();
        try {
            Statement stm = conn.conexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT nombre_comuna FROM Comuna where id_provincia=25");
            if(rs.next()){
              com= new Comuna();
              com.getNombreComuna();
              comunas.add(com);
            }
                rs.close();
                stm.close();



        } catch (SQLException e) {

        }
        return comunas;

    }
}
