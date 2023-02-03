package com.testehan.openliberty.servlet.primeFaces;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ContextMenu {

    public void back(){
        addMessage("Back","Back clicked");
    }

    public void forward(){
        addMessage("Forward","Forward clicked");
    }

    public void reload(){
        addMessage("Reload","Reload clicked");
    }

    public void saveas(){
        addMessage("SaveAs","SaveAs clicked");
    }

    public void addMessage(String summary, String detail){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,summary,detail));
    }
}
