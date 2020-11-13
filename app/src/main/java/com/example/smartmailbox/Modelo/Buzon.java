package com.example.smartmailbox.Modelo;

public class Buzon {

    private int idBuzon;
    private String serialBuzon;
    private Usuario usuario;


    public Buzon(String serialBuzon, Usuario usuario) {
        this.serialBuzon = serialBuzon;
        this.usuario = usuario;
    }

    public Buzon() {
    }

    public String getSerialBuzon() {
        return serialBuzon;
    }

    public void setSerialBuzon(String serialBuzon) {
        this.serialBuzon = serialBuzon;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
