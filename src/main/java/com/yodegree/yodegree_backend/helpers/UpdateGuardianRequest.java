package com.yodegree.yodegree_backend.helpers;

public class UpdateGuardianRequest {

    private String email;
    private String username;
    private String phone;
    private String password;


    public UpdateGuardianRequest(
            String email, String username,
            String phone, String password) {
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
