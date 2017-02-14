package com.theironyard.viewmodels;

/**
 * Created by graceconnelly on 2/12/17.
 */
public class PartView {
    int setId;
    String name;
    String color;
    String partUrl;
    int elementId;
    int setQty;
    int invQty;

    public PartView() {
    }

    public PartView(int setId,String name, String color, String partUrl, int elementId, int setQty, int invQty) {
        this.setId = setId;
        this.name = name;
        this.color = color;
        this.partUrl = partUrl;
        this.elementId = elementId;
        this.setQty = setQty;
        this.invQty = invQty;
    }

    public int getSetId() {
        return setId;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPartUrl() {
        return partUrl;
    }

    public void setPartUrl(String partUrl) {
        this.partUrl = partUrl;
    }

    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public int getSetQty() {
        return setQty;
    }

    public void setSetQty(int setQty) {
        this.setQty = setQty;
    }

    public int getInvQty() {
        return invQty;
    }

    public void setInvQty(int invQty) {
        this.invQty = invQty;
    }
}
