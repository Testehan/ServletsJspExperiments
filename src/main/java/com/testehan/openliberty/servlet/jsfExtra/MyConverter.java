package com.testehan.openliberty.servlet.jsfExtra;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import java.util.Objects;

@FacesConverter("myConverter")
public class MyConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s.length() < 5) {
            FacesMessage fm = new FacesMessage();
            fm.setSummary("Less than 5");
//            throw new ValidatorException(fm);
            FacesContext.getCurrentInstance().addMessage("form:firstName",fm);
            return "";

        } else {
            return s.concat(" !!!!!");
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (Objects.nonNull(o)) {
            return o.toString();
        } else {
            return "";
        }
    }
}
