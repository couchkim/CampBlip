package com.theironyard.viewmodels;

/**
 * Created by graceconnelly on 2/12/17.
 */
public class PartView {
    Integer setId;
    String name;
    String color;
    String partUrl;
    Integer elementId;
    Integer setQty;
    Integer invQty;
    Integer currInvQty;
    Integer setPartId;

    public PartView() {
    }

    public PartView(Integer setId, String name, String color, String partUrl, Integer elementId, Integer setQty, Integer invQty, Integer currInvQty, Integer setPartId) {
        this.setId = setId;
        this.name = name;
        this.color = color;
        this.partUrl = partUrl;
        this.elementId = elementId;
        this.setQty = setQty;
        this.invQty = invQty;
        this.currInvQty = currInvQty;
        this.setPartId = setPartId;
    }

    public Integer getSetId() {
        return setId;
    }

    public void setSetId(Integer setId) {
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

    public Integer getElementId() {
        return elementId;
    }

    public void setElementId(Integer elementId) {
        this.elementId = elementId;
    }

    public Integer getSetQty() {
        return setQty;
    }

    public void setSetQty(Integer setQty) {
        this.setQty = setQty;
    }

    public Integer getInvQty() {
        return invQty;
    }

    public void setInvQty(Integer invQty) {
        this.invQty = invQty;
    }

    public Integer getCurrInvQty() {
        return currInvQty;
    }

    public void setCurrInvQty(Integer currInvQty) {
        this.currInvQty = currInvQty;
    }

    public Integer getSetPartId() {
        return setPartId;
    }

    public void setSetPartId(Integer setPartId) {
        this.setPartId = setPartId;
    }
}