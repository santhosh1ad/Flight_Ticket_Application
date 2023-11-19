package com.example.demo.Tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String Role;

    private String Password;

    private String Gender;

    public UserTable() {
    }

    public UserTable(String userName, String password, String gender, String Role) {
        super();
        name = userName;
        this.Role = Role;
        Password = password;
        Gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        name = userName;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

	
}
