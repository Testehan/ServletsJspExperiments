package com.testehan.openliberty.servlet.jsfExtra;

import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.faces.event.ValueChangeListener;

public class ValueChangeListenerExample implements ValueChangeListener {
    @Override
    public void processValueChange(ValueChangeEvent valueChangeEvent) throws AbortProcessingException {
        System.out.println("The old value is :" +valueChangeEvent.getOldValue() + " while the new value is " + valueChangeEvent.getNewValue());
    }
}
