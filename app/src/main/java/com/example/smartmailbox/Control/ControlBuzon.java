package com.example.smartmailbox.Control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControlBuzon {
    public static DbConnection conn = new DbConnection();

    public static String buscarBuzon(String nrSerie) {
        String estado = null;

        try {
            Statement stm = conn.conexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT nr_serie FROM buzon where nr_serie ='" +nrSerie  + "'");
            rs.next();
            estado = rs.getString(1);

            rs.close();
            return estado;


        } catch (SQLException e) {

            return estado;
        }

    }

    public static boolean asociarUsuario( int idUsuario, String nrSerie){

        try {
       
            PreparedStatement stm = conn.conexion().prepareStatement("update buzon set id_usuario ='" +idUsuario  + "' where nr_serie = '"+nrSerie+"' ");

            stm.executeUpdate();
            stm.close();

            return true;
        }catch (Exception e){
            return false;
        }

    }


}
