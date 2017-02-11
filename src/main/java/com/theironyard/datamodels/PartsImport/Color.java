package com.theironyard.datamodels.PartsImport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by graceconnelly on 2/11/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Color {
    private int id;
    private String name;
    private String rgb;

    public Color() {
    }

    public Color(int id, String name, String rgb) {
        this.id = id;
        this.name = name;
        this.rgb = rgb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rgb='" + rgb + '\'' +
                '}';
    }
}
