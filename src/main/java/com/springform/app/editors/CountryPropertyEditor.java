package com.springform.app.editors;

import com.springform.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class CountryPropertyEditor extends PropertyEditorSupport {
    @Autowired
    private CountryService service;

    @Override
    public void setAsText(String id) throws IllegalArgumentException {
        try {
            this.setValue(service.getForId(Integer.parseInt(id)));
        }catch (NumberFormatException ex){
            setValue(null);
        }
    }
}
