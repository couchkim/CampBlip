package com.theironyard.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by graceconnelly on 2/7/17.
 */
@Entity
@Table(name = "parts")
public class Part {
    @Id
    @GeneratedValue
    @Column(name = "part_id")
    private int id;

    @Column(nullable = false, name = "element_id")
    private int elementId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "part_img_url")
    private String partUrl;

    @Column(nullable = false, name = "part_color")
    private String color;

    @OneToMany(mappedBy = "part")
    private List<SetPart> setParts = new ArrayList<SetPart>();

    public Part() {
    }

    public Part(int elementId, String name, String partUrl, String color) {
        this.elementId = elementId;
        this.name = name;
        this.partUrl = partUrl;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartUrl() {
        return partUrl;
    }

    public void setPartUrl(String partUrl) {
        this.partUrl = partUrl;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<SetPart> getSetParts() {
        return setParts;
    }

    public void setSetParts(List<SetPart> setParts) {
        this.setParts = setParts;
    }
}
