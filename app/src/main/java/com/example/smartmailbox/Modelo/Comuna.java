package com.example.smartmailbox.Modelo;

public class Comuna {
    private int idcomuna;
    private String nombreComuna;
    private Provincia provincia;

    public Comuna(String nombreComuna, Provincia provincia) {
        this.nombreComuna = nombreComuna;
        this.provincia = provincia;
    }

    public String getNombreComuna() {
        return nombreComuna;
    }

    public void setNombreComuna(String nombreComuna) {
        this.nombreComuna = nombreComuna;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}
