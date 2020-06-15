package com.example.smartmailbox.Control;

import android.content.Context;
import android.content.SharedPreferences;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.smartmailbox.IngresoUsuario;
import com.example.smartmailbox.Modelo.Comuna;
import com.example.smartmailbox.Modelo.DbConnection;
import com.example.smartmailbox.Modelo.Usuario;

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

    public static String loginUsuario(String nick, String pass) {
        String estado = null;

        try {
            Statement stm = conn.conexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT alias_usuario FROM Usuario where alias_usuario='" + nick + "' and contrasena_usuario='" + pass + "'");
            rs.next();
            estado = rs.getString(1);

            rs.close();
            return estado;


        } catch (SQLException e) {

            return estado;
        }


/*
    public static int loginUsuario(String nick, String pass) {
        int estado = -1;
        try {

            CallableStatement call = conn.conexion().prepareCall("(call dbo.USUARIO(?,?,?,?,?,?,?,?,?)");
            call.setString(2,nick);
            call.setString(3,pass);
            ResultSet rs = call.executeQuery();
            rs.next();
            estado = rs.getInt(1);
            rs.close();
            call.close();
            return estado;

        } catch (SQLException e) {
return estado;
        }





    }


 */
    }
 /*
    public void guardarcredenciales(String nick){

        SharedPreferences preferences =  getSharedPreferences("credenciales", MODE_PRIVATE);

        String contraseña = null;
        String nombrecompleto=null;
        DbConnection conn = new DbConnection();
        try {
            Statement stm = conn.conexion().createStatement();
            ResultSet rs = stm.executeQuery("select NOMBRE_USUARIO,CONTRASENA_USUARIO from usuario where ALIAS_USUARIO='"+nick+"'");
            rs.next();
            if(rs != null){
                String c = rs.getString("CONTRASENA_USUARIO");
                String nc = rs.getString("NOMBRE_USUARIO");
                contraseña=c;
                nombrecompleto=nc;
            }else{
                rs.close();
                stm.close();
            }

            rs.close();
            stm.close();




        } catch (SQLException e) {

        }


        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("nick",nick);
        editor.putString("pass",contraseña);
        editor.putString("name",nombrecompleto);
        editor.commit();
    }
     */
}
