package com.testehan.openliberty.servlet.jsfExtra;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class UserLogin {

    private String username;
    private String password;

    public UserLogin(){
        this.username = "";
        this.password = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String checkLogin(){
        // this is not a real login...the point here is to demonstrate the rule based navigation
        if (username.equals("dan") && (password.equals("1234"))){
            // and so, i can do the redirect from here :
            return "welcome?faces-redirect=true";
        } else {
            return "failure?faces-redirect=true";
        }
    }

}
