package com.conexion_sql;

public class Provincias {
    private int provincia;
    private String nombreProvincia;

    public Provincias(int provincia, String nombreProvincia) {
        this.provincia = provincia;
        this.nombreProvincia = nombreProvincia;
    }

    public int getProvincia() {
        return provincia;
    }

    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }
    
}
