package com.scilor.wii.wiitdb2romcollectionbrowser;

/**
 * Created by SciLor on 30.01.2017.
 */
public class GameControl {
    private String type; //wiimote
    private boolean required;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
