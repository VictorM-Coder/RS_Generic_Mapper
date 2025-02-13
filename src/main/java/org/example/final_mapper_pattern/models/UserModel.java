package org.example.final_mapper_pattern.models;

public class UserModel {
    private String name;
    private String lastname;
    private String email;
    private String password;

    public UserModel(String name, String lastname, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }
}
