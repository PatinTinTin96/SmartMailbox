package com.example.smartmailbox.Modelo;

public class Estado {

    private int idEstado;
    private String descEstado;


    public Estado(String descEstado) {
        this.descEstado = descEstado;
    }

    public Estado() {

    }

    public String getDescEstado() {
        return descEstado;
    }

    public void setDescEstado(String descEstado) {
        this.descEstado = descEstado;
    }
}
