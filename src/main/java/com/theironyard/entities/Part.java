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
    @Column (name = "part_id")
    private int id;

    @Column(nullable = false, name = "element_id")
    private int elementId;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "part")
    private List<SetPart> setParts = new ArrayList<SetPart>();

    public Part() {
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

    public List<SetPart> getSetParts() {
        return setParts;
    }

    public void setSetParts(List<SetPart> setParts) {
        this.setParts = setParts;
    }
}
