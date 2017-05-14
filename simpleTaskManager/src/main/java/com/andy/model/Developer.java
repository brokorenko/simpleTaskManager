package com.andy.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "developer")
public class Developer implements Serializable {
    @Id
    @Column(name = "developer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*Анноации для переменных сделаны для проверки валидации при вводе*/
    private int developer_id;

    @Column(name = "developer_full_name")
    @Size(min = 3, max = 50, message = "Your full name must be between 3 and 50 characters long.")
    private String developer_full_Name;

    @Column(name = "developer_login")
    @Size(min = 3, max = 30, message = "Login must be between 3 and 30 characters long.")
    private String developer_login;

    @Column(name = "developer_password")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters long.")
    private String developer_password;

    //@Pattern(regexp="^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(?:\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@(?:[a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*", message="Invalid email address.")
    @Column(name = "developer_email")
    @Size(min = 3, max = 20, message = "Email must be between 3 and 20 characters long.")
    private String developer_email;

    @Column(name = "developer_role")
    @Size(min = 3, max = 20, message = "Email must be between 3 and 20 characters long.")
    private String developer_role;

    public int getDeveloper_id() {
        return developer_id;
    }

    public void setDeveloper_id(int developer_id) {
        this.developer_id = developer_id;
    }

    public String getDeveloper_full_Name() {
        return developer_full_Name;
    }

    public void setDeveloper_full_Name(String developer_full_Name) {
        this.developer_full_Name = developer_full_Name;
    }

    public String getDeveloper_login() {
        return developer_login;
    }

    public void setDeveloper_login(String developer_login) {
        this.developer_login = developer_login;
    }

    public String getDeveloper_password() {
        return developer_password;
    }

    public void setDeveloper_password(String developer_password) {
        this.developer_password = developer_password;
    }

    public String getDeveloper_email() {
        return developer_email;
    }

    public void setDeveloper_email(String developer_email) {
        this.developer_email = developer_email;
    }

    public String getDeveloper_role() {
        return developer_role;
    }

    public void setDeveloper_role(String developer_role) {
        this.developer_role = developer_role;
    }
}
