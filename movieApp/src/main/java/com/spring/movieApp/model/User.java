package com.spring.movieApp.model;

public class User {
    private String userName;
    private String password;
    private Role role;

    public User(String userName, String password, Role role) {
        super();
        this.userName = userName;
        this.password = password;
        this.role = role;
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
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public User() {
        super();
    }

}
