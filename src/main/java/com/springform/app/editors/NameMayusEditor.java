package com.springform.app.editors;

import java.beans.PropertyEditorSupport;

public class NameMayusEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.toUpperCase().trim());
    }
}
