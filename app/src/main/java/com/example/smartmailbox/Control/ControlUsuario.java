package com.example.smartmailbox.Control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControlUsuario {
    public static DbConnection conn = new DbConnection();

    /**
     *
     * @param nombreUsuario
     * @param nickUsuario
     * @param emailUsuario
     * @param telefonoUsuario
     * @param direccionUsuario
     * @param contraseñaUsuario
     * @param comuna
     * @return
     */
    public static boolean agregarUsuario(String nombreUsuario, String nickUsuario, String emailUsuario, String telefonoUsuario, String direccionUsuario, String contraseñaUsuario, int comuna){

        try {
            PreparedStatement stm = conn.conexion().prepareStatement("insert into Usuario values (?,?,?,?,?,?,?)");
            stm.setInt(1,comuna);
            stm.setString(2,nombreUsuario);
            stm.setString(3,nickUsuario);
            stm.setString(4,emailUsuario);
            stm.setString(5,telefonoUsuario);
            stm.setString(6,direccionUsuario);
            stm.setString(7,contraseñaUsuario);

            stm.executeUpdate();
            stm.close();

            return true;
        }catch (Exception e){
            return false;
        }

    }

    /**
     * Para el metodo de login de tomaran de entrada el nick y la contraseña del usuario
     * los cuales seran comparados dentro de la base de datos en la cual retornara el nick en caso
     * @param nick
     * @param pass
     * @return
     */
    public static String loginUsuario(String nick, String pass) {
        String estado = null;

        try {
            Statement stm = conn.conexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT alias_usuario FROM Usuario where alias_usuario='" + nick + "' and pass_usuario='" + pass + "'");
            rs.next();
            estado = rs.getString(1);

            rs.close();
            return estado;


        } catch (SQLException e) {

            return estado;
        }

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
