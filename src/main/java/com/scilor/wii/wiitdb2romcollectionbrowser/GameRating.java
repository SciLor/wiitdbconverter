package com.scilor.wii.wiitdb2romcollectionbrowser;

import java.util.List;

/**
 * Created by SciLor on 30.01.2017.
 */
public class GameRating {
    private String type; //ESRB
    private String value; //E10+
    private List<String> descriptors; //cartoon violence  //mild suggestive themes

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(List<String> descriptors) {
        this.descriptors = descriptors;
    }
}
