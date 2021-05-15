package com.amse.tt_2019_b087.iot.dto;

import java.io.Serializable;

public class Permisos implements Serializable {
    private int id;
    private String nombre;
    private boolean status;

    public Permisos() {
    }

    public Permisos(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
