package com.andy.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrew on 16.03.2017.
 */
@Entity
@Table(name = "manager")
public class Manager implements Serializable{
    @Id
    @Column(name = "manager_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*Анноации для переменных сделаны для проверки валидации при вводе*/
    private int manager_id;

    @Column(name = "manager_full_name")
    @Size(min = 3, max = 50, message = "Your full name must be between 3 and 50 characters long.")
    private String manager_full_Name;

    @Column(name = "manager_login")
    @Size(min = 3, max = 30, message = "Login must be between 3 and 30 characters long.")
    private String manager_login;

    @Column(name = "manager_password")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters long.")
    private String manager_password;

    //@Pattern(regexp="^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(?:\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@(?:[a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*", message="Invalid email address.")
    @Column(name = "manager_email")
    @Size(min = 3, max = 20, message = "Email must be between 3 and 20 characters long.")
    private String manager_email;

    @Column(name = "manager_role")
    @Size(min = 3, max = 20, message = "Email must be between 3 and 20 characters long.")
    private String manager_role;

   // @JsonIgnore
    @OneToMany(mappedBy = "manager", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Project> projects = new HashSet<Project>();

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_full_Name() {
        return manager_full_Name;
    }

    public void setManager_full_Name(String manager_full_Name) {
        this.manager_full_Name = manager_full_Name;
    }

    public String getManager_login() {
        return manager_login;
    }

    public void setManager_login(String manager_login) {
        this.manager_login = manager_login;
    }

    public String getManager_password() {
        return manager_password;
    }

    public void setManager_password(String manager_password) {
        this.manager_password = manager_password;
    }

    public String getManager_email() {
        return manager_email;
    }

    public void setManager_email(String manager_email) {
        this.manager_email = manager_email;
    }

    public String getManager_role() {
        return manager_role;
    }

    public void setManager_role(String manager_role) {
        this.manager_role = manager_role;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Manager[id = " + manager_id + "full name = " + manager_full_Name + "login = " + manager_login
                + "email = " + manager_email + "count of projects:" + projects.size() + "]";
    }
}
