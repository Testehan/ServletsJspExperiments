package com.testehan.openliberty.servlet.primeFaces;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MyListener {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void handleEvent(){
        this.name = this.name.toUpperCase();
    }
}
