package com.theironyard.entities;

import com.theironyard.datamodels.SkillEnum;
import com.theironyard.datamodels.StatusEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by graceconnelly on 2/7/17.
 */
@Entity
@Table(name = "sets")
public class Set {
    @Id
    @GeneratedValue
    @Column(name = "set_id")
    private int id;

    @Column(nullable = false, name = "set_num")
    String setNum;

    @Column(nullable = false, name = "set_name")
    String setName;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int num_parts;

    @Column(nullable = false)
    private String theme;

    @Column(nullable = false, name = "set_img_url")
    private String setImgUrl;

    @Column(nullable = false, name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum statusEnum;

    @Column(nullable = false, name = "skill_level")
    @Enumerated(EnumType.STRING)
    private SkillEnum skillEnum;

    private String notes;

    @OneToMany(mappedBy = "set")
    private List<SetPart> setParts = new ArrayList<SetPart>();

    public Set() {
    }

    public Set(String setNum, String setName, int year, int num_parts, String theme, String setImgUrl, StatusEnum statusEnum, SkillEnum skillEnum, String notes) {
        this.setNum = setNum;
        this.setName = setName;
        this.year = year;
        this.num_parts = num_parts;
        this.theme = theme;
        this.setImgUrl = setImgUrl;
        this.statusEnum = statusEnum;
        this.skillEnum = skillEnum;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSetNum() {
        return setNum;
    }

    public void setSetNum(String setNum) {
        this.setNum = setNum;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
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

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSetImgUrl() {
        return setImgUrl;
    }

    public void setSetImgUrl(String setImgUrl) {
        this.setImgUrl = setImgUrl;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    public SkillEnum getSkillEnum() {
        return skillEnum;
    }

    public void setSkillEnum(SkillEnum skillEnum) {
        this.skillEnum = skillEnum;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<SetPart> getSetParts() {
        return setParts;
    }

    public void setSetParts(List<SetPart> setParts) {
        this.setParts = setParts;
    }

    @Override
    public String toString() {
        return "Set{" +
                "id=" + id +
                ", setNum='" + setNum + '\'' +
                ", setName='" + setName + '\'' +
                ", year=" + year +
                ", num_parts=" + num_parts +
                ", theme='" + theme + '\'' +
                ", setImgUrl='" + setImgUrl + '\'' +
                ", statusEnum=" + statusEnum +
                ", skillEnum=" + skillEnum +
                ", notes='" + notes + '\'' +
                ", setParts=" + setParts +
                '}';
    }
}