package com.testehan.openliberty.servlet.jsfExtra;

import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.event.ActionListener;

public class PrintButtonIdActionListener implements ActionListener {
    @Override
    public void processAction(ActionEvent actionEvent) throws AbortProcessingException {
        System.out.println("Button id is " + actionEvent.getComponent().getId());
    }
}
