package com.theironyard.viewmodels;

import com.theironyard.datamodels.Enums.InvEnum;
import com.theironyard.datamodels.Enums.SkillEnum;
import com.theironyard.datamodels.Enums.StatusEnum;

/**
 * Created by graceconnelly on 2/7/17.
 */
public class SetView {

    String name;
    int set_id;
    String set_num;
    int year;
    int num_parts;
    String set_img_url;
    String set_build_url;
    String theme;
    StatusEnum status;
    SkillEnum skill_level;
    String inv_date;
    String inv_name;
    InvEnum inv_stat;
    String last_checkout;
    Integer inv_parts;
    String notes;

    public SetView() {
    }

    public SetView(String name, int set_id, String set_num, int year, int num_parts, String set_img_url, String set_build_url, String theme, StatusEnum status, SkillEnum skill_level, String inv_date, String inv_name, InvEnum inv_stat, String last_checkout, Integer inv_parts, String notes) {
        this.name = name;
        this.set_id = set_id;
        this.set_num = set_num;
        this.year = year;
        this.num_parts = num_parts;
        this.set_img_url = set_img_url;
        this.set_build_url = set_build_url;
        this.theme = theme;
        this.status = status;
        this.skill_level = skill_level;
        this.inv_date = inv_date;
        this.inv_name = inv_name;
        this.inv_stat = inv_stat;
        this.last_checkout = last_checkout;
        this.inv_parts = inv_parts;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSet_id() {
        return set_id;
    }

    public void setSet_id(int set_id) {
        this.set_id = set_id;
    }

    public String getSet_num() {
        return set_num;
    }

    public void setSet_num(String set_num) {
        this.set_num = set_num;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNum_parts() {
        return num_parts;
    }

    public void setNum_parts(int num_parts) {
        this.num_parts = num_parts;
    }

    public String getSet_img_url() {
        return set_img_url;
    }

    public void setSet_img_url(String set_img_url) {
        this.set_img_url = set_img_url;
    }

    public String getSet_build_url() {
        return set_build_url;
    }

    public void setSet_build_url(String set_build_url) {
        this.set_build_url = set_build_url;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public SkillEnum getSkill_level() {
        return skill_level;
    }

    public void setSkill_level(SkillEnum skill_level) {
        this.skill_level = skill_level;
    }

    public String getInv_date() {
        return inv_date;
    }

    public void setInv_date(String inv_date) {
        this.inv_date = inv_date;
    }

    public String getInv_name() {
        return inv_name;
    }

    public void setInv_name(String inv_name) {
        this.inv_name = inv_name;
    }

    public InvEnum getInv_stat() {
        return inv_stat;
    }

    public void setInv_stat(InvEnum inv_stat) {
        this.inv_stat = inv_stat;
    }

    public String getLast_checkout() {
        return last_checkout;
    }

    public void setLast_checkout(String last_checkout) {
        this.last_checkout = last_checkout;
    }

    public Integer getInv_parts() {
        return inv_parts;
    }

    public void setInv_parts(Integer inv_parts) {
        this.inv_parts = inv_parts;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}