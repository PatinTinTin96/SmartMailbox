package com.example.smartmailbox.Modelo;

public class Provincia {
    private int idprovincia;
    private String nombreprovincia;
    private Region region;

    public Provincia(String nombreprovincia, Region region) {
        this.nombreprovincia = nombreprovincia;
        this.region = region;
    }

    public String getNombreprovincia() {
        return nombreprovincia;
    }

    public void setNombreprovincia(String nombreprovincia) {
        this.nombreprovincia = nombreprovincia;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
