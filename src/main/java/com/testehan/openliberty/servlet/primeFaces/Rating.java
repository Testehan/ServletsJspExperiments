package com.testehan.openliberty.servlet.primeFaces;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.primefaces.event.RateEvent;

@Named
@RequestScoped
public class Rating {

    private int basicRating;
    private int ajaxRating;

    public int getBasicRating() {
        return basicRating;
    }

    public void setBasicRating(int basicRating) {
        this.basicRating = basicRating;
    }

    public int getAjaxRating() {
        return ajaxRating;
    }

    public void setAjaxRating(int ajaxRating) {
        this.ajaxRating = ajaxRating;
    }

    public void onrate(RateEvent<Integer> event){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rating is " + event.getRating()));

    }
}
