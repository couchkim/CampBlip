package com.theironyard.datamodels.PartsImport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by graceconnelly on 2/11/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Part {
    private String name;
    private String part_img_url;
    private int part_cat_id;

    public Part() {
    }

    public Part(String name, String part_img_url, int part_cat_id) {
        this.name = name;
        this.part_img_url = part_img_url;
        this.part_cat_id = part_cat_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPart_img_url() {
        return part_img_url;
    }

    public void setPart_img_url(String part_img_url) {
        this.part_img_url = part_img_url;
    }

    public int getPart_cat_id() {
        return part_cat_id;
    }

    public void setPart_cat_id(int part_cat_id) {
        this.part_cat_id = part_cat_id;
    }

    @Override
    public String toString() {
        return "Part{" +
                "name='" + name + '\'' +
                ", part_img_url='" + part_img_url + '\'' +
                ", part_cat_id=" + part_cat_id +
                '}';
    }
}
