package com.theironyard.datamodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by graceconnelly on 2/10/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetImport {

    private String set_num;
    private String name;
    private int year;
    private int theme_id;
    private String set_img_url;

    public SetImport() {
    }

    public SetImport(String set_num, String name, int year, int theme_id, String set_img_url) {
        this.set_num = set_num;
        this.name = name;
        this.year = year;
        this.theme_id = theme_id;
        this.set_img_url = set_img_url;
    }

    public String getSet_num() {
        return set_num;
    }

    public void setSet_num(String set_num) {
        this.set_num = set_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTheme_id() {
        return theme_id;
    }

    public void setTheme_id(int theme_id) {
        this.theme_id = theme_id;
    }

    public String getSet_img_url() {
        return set_img_url;
    }

    public void setSet_img_url(String set_img_url) {
        this.set_img_url = set_img_url;
    }

    @Override
    public String toString() {
        return "SetImport{" +
                "set_num='" + set_num + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", theme_id=" + theme_id +
                ", set_img_url='" + set_img_url + '\'' +
                '}';
    }
}
