package com.example.smartmailbox.Control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControlRepartidor {
    public static DbConnection conn = new DbConnection();

    public static String loginRepartidor(String nomRepartidor, String passRepartidor) {
        String estado = null;

        try {
            Statement stm = conn.conexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT nombre_repartidor FROM repartidor where nombre_repartidor='" + nomRepartidor + "' and pass_repartidor='" + passRepartidor + "'");
            rs.next();
            estado = rs.getString(1);

            rs.close();
            return estado;


        } catch (SQLException e) {

            return estado;
        }

    }
}
