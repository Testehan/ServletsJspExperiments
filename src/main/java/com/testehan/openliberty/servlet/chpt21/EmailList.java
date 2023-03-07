package com.testehan.openliberty.servlet.chpt21;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;


@Named
@RequestScoped
public class EmailList implements Serializable {

    private User user;
    private String message;

    public EmailList(){}

    @PostConstruct
    public void init(){
        this.user = new User();
        this.message = "<h3>Hri there !!!!</h3>";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String addToEmailList() {

        if ("dan@yahoo.com".equalsIgnoreCase(user.getEmail())) {
            message = "This email address already exists. Please enter another email address";
            user.setEmail("");
            return "email";
        } else {
            message = "Thanks for registering !";
            return "thanksForRegistering";
        }
    }
}
