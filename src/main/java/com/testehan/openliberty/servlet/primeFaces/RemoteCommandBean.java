package com.testehan.openliberty.servlet.primeFaces;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@RequestScoped
public class RemoteCommandBean {

    public void display(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Called using remote command"));
    }
}
