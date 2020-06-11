package com.example.smartmailbox.Control;

import java.sql.PreparedStatement;

import com.example.smartmailbox.Modelo.DbConnection;

public class ControlUsuario {
    public static DbConnection conn = new DbConnection();


    public static boolean agregarUsuario(String nombreUsuario, String nickUsuario, String emailUsuario, String telefonoUsuario, String direccionUsuario, String contraseñaUsuario, int comuna, int mailbox){

        try {
            PreparedStatement stm = conn.conexion().prepareStatement("insert into Usuario values (?,?,?,?,?,?,?,?)");
            stm.setInt(1,comuna);
            stm.setInt(2,mailbox);
            stm.setString(3,nombreUsuario);
            stm.setString(4,nickUsuario);
            stm.setString(5,emailUsuario);
            stm.setString(6,telefonoUsuario);
            stm.setString(7,direccionUsuario);
            stm.setString(8,contraseñaUsuario);

            stm.executeUpdate();
            stm.close();

            return true;
        }catch (Exception e){
            return false;
        }

    }



}
