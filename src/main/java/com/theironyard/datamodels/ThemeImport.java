package com.theironyard.datamodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by graceconnelly on 2/10/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThemeImport {
    private int id;
    private String parent_id;
    private String name;

    public ThemeImport() {
    }

    public ThemeImport(int id, String parent_id, String name) {
        this.id = id;
        this.parent_id = parent_id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ThemeImport{" +
                "id=" + id +
                ", parent_id='" + parent_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
