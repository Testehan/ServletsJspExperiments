package com.testehan.openliberty.servlet.primeFaces;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MenuBar {

    public void file(){
        addMessage("File", "File clicked!");
    }

    public void edit(){
        addMessage("Edit", "Edit clicked!");
    }

    public void view(){
        addMessage("View", "View clicked!");
    }

    private void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null,message);
    }
}
