package com.example.smartmailbox.Modelo;

import net.sourceforge.jtds.jdbc.DateTime;

public class Entrega {
    private int idEntrega;
    private DateTime Fecha;
    private Repartidor repartidor;
    private Usuario usuario;
    private Estado estado;


    public Entrega(DateTime fecha, Repartidor repartidor, Usuario usuario, Estado estado) {
        Fecha = fecha;
        this.repartidor = repartidor;
        this.usuario = usuario;
        this.estado = estado;
    }

    public Entrega() {

    }

    public DateTime getFecha() {
        return Fecha;
    }

    public void setFecha(DateTime fecha) {
        Fecha = fecha;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
