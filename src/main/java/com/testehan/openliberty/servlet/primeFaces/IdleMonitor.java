package com.testehan.openliberty.servlet.primeFaces;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@RequestScoped
public class IdleMonitor {

    public void onIdle(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No activity", "What are you doing over there ?"));
    }

    public void onActive(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Welcome back", " just continue doing something :)"));
    }
}
