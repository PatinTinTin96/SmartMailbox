package com.example.smartmailbox.Modelo;

public class Courier {


    private int idCourier;
    private String nombreCourier;

    public Courier(String nombreCourier) {
        this.idCourier = idCourier;
        this.nombreCourier = nombreCourier;
    }


    public Courier() {

    }


    public String getNombreCourier() {
        return nombreCourier;
    }

    public void setNombreCourier(String nombreCourier) {
        this.nombreCourier = nombreCourier;
    }






}
