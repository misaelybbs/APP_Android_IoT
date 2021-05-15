package mx.com.tt.RegisterService.dto.response;

import java.sql.Timestamp;

public class UserResponse {

    private int idUser;
    private String userName;
    private String password;
    private String name;
    private String lastname;
    private int activo;
    private String email;
    private String sex;
    private int rol;
    private boolean registerStatus;
    private String registerMsg;
    Timestamp timestamp;

    public UserResponse() {
    }

    public UserResponse(int idUser, String userName, String password, String name, String lastname, int activo, String email, String sex, int rol, boolean registerStatus, String registerMsg, Timestamp timestamp) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.activo = activo;
        this.email = email;
        this.sex = sex;
        this.rol = rol;
        this.registerStatus = registerStatus;
        this.registerMsg = registerMsg;
        this.timestamp = timestamp;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
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

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public boolean isRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(boolean registerStatus) {
        this.registerStatus = registerStatus;
    }

    public String getRegisterMsg() {
        return registerMsg;
    }

    public void setRegisterMsg(String registerMsg) {
        this.registerMsg = registerMsg;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
