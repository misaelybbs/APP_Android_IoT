package com.amse.tt_2019_b087.iot.enums;

public enum Roles{
    ADMIN(1, "admin"), HOGAR(2, "hogar"), AGRICULTOR(3, "agricultor");

    private int codigo;
    private String nombre;

    private Roles(int codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;

    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
}
