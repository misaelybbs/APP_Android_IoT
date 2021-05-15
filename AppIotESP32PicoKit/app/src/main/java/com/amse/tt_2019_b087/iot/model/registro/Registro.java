package com.amse.tt_2019_b087.iot.model.registro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Registro {

    @SerializedName("sub")
    @Expose
    private String sub;

    @SerializedName("iat")
    @Expose
    private String iat;

    @SerializedName("exp")
    @Expose
    private String exp;

    @SerializedName("idUser")
    @Expose
    private String idUser;

    @SerializedName("userName")
    @Expose
    private String userName;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("lastname")
    @Expose
    private String lastName;

    @SerializedName("activo")
    @Expose
    private String activo;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("sex")
    @Expose
    private String sex;

    @SerializedName("rol")
    @Expose
    private String rolIdRol;

    @SerializedName("registerStatus")
    @Expose
    private String registerStatus;

    @SerializedName("registerMsg")
    @Expose
    private String registerMsg;

    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getIat() {
        return iat;
    }

    public void setIat(String iat) {
        this.iat = iat;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRolIdRol() {
        return rolIdRol;
    }

    public void setRolIdRol(String rolIdRol) {
        this.rolIdRol = rolIdRol;
    }

    public String getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(String registerStatus) {
        this.registerStatus = registerStatus;
    }

    public String getRegisterMsg() {
        return registerMsg;
    }

    public void setRegisterMsg(String registerMsg) {
        this.registerMsg = registerMsg;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
