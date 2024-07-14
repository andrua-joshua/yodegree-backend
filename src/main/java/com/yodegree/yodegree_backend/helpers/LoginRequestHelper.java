package com.yodegree.yodegree_backend.helpers;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginRequestHelper {

    private String userName;
    private String password;

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
}
