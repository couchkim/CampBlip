package com.theironyard.viewmodels;

import java.util.List;

/**
 * Created by graceconnelly on 2/12/17.
 */
public class PartViewModel {
    String set_name;
    List<PartView> parts;

    public PartViewModel() {
    }

    public PartViewModel(String set_name, List<PartView> parts) {
        this.set_name = set_name;
        this.parts = parts;
    }

    public String getSet_name() {
        return set_name;
    }

    public void setSet_name(String set_name) {
        this.set_name = set_name;
    }

    public List<PartView> getParts() {
        return parts;
    }

    public void setParts(List<PartView> parts) {
        this.parts = parts;
    }
}
