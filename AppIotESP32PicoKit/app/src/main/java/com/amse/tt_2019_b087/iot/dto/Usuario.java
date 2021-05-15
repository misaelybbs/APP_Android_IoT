package com.amse.tt_2019_b087.iot.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {

    private String user;
    private String password;
    private List<Permisos> permisos;

    public Usuario() {
    }

    public Usuario(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Permisos> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permisos> permisos) {
        this.permisos = permisos;
    }

    public void addPermisos(Permisos permisos){
        if(this.permisos == null){
            this.permisos =new ArrayList<>();
        }

        this.permisos.add(permisos);
    }
}
