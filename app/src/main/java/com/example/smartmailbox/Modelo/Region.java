package com.example.smartmailbox.Modelo;

public class Region {
    private int idRegion;
    private String nombreRegion;

    public Region(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }
}
