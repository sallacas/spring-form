package com.springform.app.editors;

import com.springform.app.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class RolesEditor extends PropertyEditorSupport {
    @Autowired
    private RoleService roleService;

    @Override
    public void setAsText(String id) throws IllegalArgumentException {
        try {
            setValue(roleService.getForId(Integer.parseInt(id)));
        } catch (NumberFormatException ex) {
            setValue(null);
        }
    }
}
