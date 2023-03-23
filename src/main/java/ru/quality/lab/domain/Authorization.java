package ru.quality.lab.domain;

public class Authorization {

    private final String username;
    private final String password;

    public Authorization() {
        this.username = System.getenv("username");
        this.password = System.getenv("pwd");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}