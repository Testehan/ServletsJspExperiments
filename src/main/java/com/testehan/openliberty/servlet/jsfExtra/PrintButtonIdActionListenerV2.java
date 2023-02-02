package com.testehan.openliberty.servlet.jsfExtra;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.event.ActionEvent;
import jakarta.inject.Named;

@Named
@RequestScoped
public class PrintButtonIdActionListenerV2 {

    public void processAction(ActionEvent event){
        System.out.println("From the V2 listener, this is the ID of the clicked button : " + event.getComponent().getId());
    }
}
