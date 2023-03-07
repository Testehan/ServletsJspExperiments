package com.testehan.openliberty.servlet.primeFaces;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.primefaces.event.SelectEvent;

import java.time.LocalDate;

@Named
@RequestScoped
public class DatePicker {

    private LocalDate selectedDate;

    public LocalDate getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(LocalDate selectedDate) {
        this.selectedDate = selectedDate;
    }

    public void onDateSelect(SelectEvent<LocalDate> event){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Date is " + event.getObject().toString()));
    }
}
