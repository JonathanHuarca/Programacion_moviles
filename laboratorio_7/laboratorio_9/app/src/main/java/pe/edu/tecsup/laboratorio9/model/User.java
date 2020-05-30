package pe.edu.tecsup.laboratorio9.model;

import com.orm.dsl.Table;

//Le dise que esta entidad corresponde  auna entidad de base de datos
@Table
public class User {

    private Long id;
    private String fullname;
    private String email;
    private String password;

    public User() {
    }

    public User(String fullname, String email, String password) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Retorna un valor String:
    //Lo que hace este es concatenar
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

