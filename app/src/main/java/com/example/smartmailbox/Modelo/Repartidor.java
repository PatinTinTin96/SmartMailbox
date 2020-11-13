package com.example.smartmailbox.Modelo;

public class Repartidor {

    private int idRepartidor;
    private String nomRepartidor;
    private String apeRepartidor;
    private String passRepartidor;
    private Courier courier;

    public Repartidor(String nomRepartidor, String apeRepartidor, String passRepartidor, Courier courier) {
        this.nomRepartidor = nomRepartidor;
        this.apeRepartidor = apeRepartidor;
        this.passRepartidor = passRepartidor;
        this.courier = courier;
    }

    public Repartidor() {
        this.nomRepartidor = nomRepartidor;
        this.apeRepartidor = apeRepartidor;
        this.passRepartidor = passRepartidor;
        this.courier = courier;
    }

    public String getNomRepartidor() {
        return nomRepartidor;
    }

    public void setNomRepartidor(String nomRepartidor) {
        this.nomRepartidor = nomRepartidor;
    }

    public String getApeRepartidor() {
        return apeRepartidor;
    }

    public void setApeRepartidor(String apeRepartidor) {
        this.apeRepartidor = apeRepartidor;
    }

    public String getPassRepartidor() {
        return passRepartidor;
    }

    public void setPassRepartidor(String passRepartidor) {
        this.passRepartidor = passRepartidor;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }
}
