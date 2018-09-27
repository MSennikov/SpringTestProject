package com.SennikovTestProject.DemoProject.DTO;

import com.SennikovTestProject.DemoProject.Entity.Roles;
import com.SennikovTestProject.DemoProject.Entity.User;

public class UserDTO {
    private Long id;
    private String firstName;
    private String secondName;
    private String password;
    private Roles roles;

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName=user.getFirstName();
        this.secondName=user.getSecondName();
        this.password=user.getPassword();
        this.roles=user.getRole();
    }

    public UserDTO(Long id, String firstName, String secondName, String password, Roles roles) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
