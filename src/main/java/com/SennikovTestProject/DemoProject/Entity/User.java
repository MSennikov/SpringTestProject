package com.SennikovTestProject.DemoProject.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long id;
    @NotEmpty
    @Column(name = "FirstName")
    private String firstName;
    @NotEmpty
    @Column(name = "SecondName")
    private String secondName;
    @NotEmpty
    @Column(name = "Password")
    private String password;
    @Column(name = "Role")
    private Roles role = Roles.GUEST;

    public User() {
    }

    public User(String firstName, String secondName, String password, Roles role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, Name='%s', Password='%s', Role='%s']",
                id, firstName+" "+secondName, password, role);
    }
}
