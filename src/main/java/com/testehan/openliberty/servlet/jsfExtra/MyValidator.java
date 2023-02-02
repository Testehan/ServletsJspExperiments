package com.testehan.openliberty.servlet.jsfExtra;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("myValidator")
public class MyValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String value = (String) o;
        Integer grade = Integer.parseInt(value);
        if ((grade< 1) || (grade>10)){
            FacesMessage fm = new FacesMessage();
            fm.setSummary("Grade is not between 1 and 10");
            throw new ValidatorException(fm);
        }
    }
}
