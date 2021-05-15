package mx.com.tt.RegisterService.model;

import javax.persistence.*;

@Entity
@Table(name="User", schema="TT2019-B087")
public class User {

    @Id
    @Column(name="iduser")
    private int idUser;

    @Column(name="username", length=45, nullable=false)
    private String userName;

    @Column(name="password", length=45, nullable=false)
    private String password;

    @Column(name="name", length=45, nullable=false)
    private String name;

    @Column(name="lastname", length=45, nullable=false)
    private String lastname;

    @Column(name="activo", length=1, nullable=false)
    private int activo;

    @Column(name="email", length=100, nullable=false)
    private String email;

    @Column(name="sex", length=1, nullable=false)
    private String sex;

    @Column(name="rol_idrol")
    private int rol;

    public User() {
    }

    public User(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }

    public User(int idUser, String userName, String password, String name, String lastname, int activo, String email, String sex, int rol) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.activo = activo;
        this.email = email;
        this.sex = sex;
        this.rol = rol;
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

    public int isActivo() {
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

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", activo=" + activo +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", rol=" + rol +
                '}';
    }
}