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
    private int id;

    @Column(nullable = false)
    String setNum;

    @Column(nullable = false)
    String setName;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int numParts;

    @Column(nullable = false)
    private String theme;

    @Column(nullable = true)
    private String setImgUrl;

    @Column
    private String setBuildUrl;

    @Column(nullable = false, name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum statusEnum;

    @Column(nullable = false, name = "skill_level")
    @Enumerated(EnumType.STRING)
    private SkillEnum skillEnum;

    private String notes;

    @OneToMany(mappedBy = "set")
    private List<SetPart> setParts;

    public Set() {
    }

    public Set(String setNum, String setName, int year, int numParts, String theme, String setImgUrl, String setBuildUrl, StatusEnum statusEnum, SkillEnum skillEnum, String notes) {
        this.setNum = setNum;
        this.setName = setName;
        this.year = year;
        this.numParts = numParts;
        this.theme = theme;
        this.setImgUrl = setImgUrl;
        this.setBuildUrl = setBuildUrl;
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

    public int getNumParts() {
        return numParts;
    }

    public void setNumParts(int numParts) {
        this.numParts = numParts;
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

    public String getSetBuildUrl() {
        return setBuildUrl;
    }

    public void setSetBuildUrl(String setBuildUrl) {
        this.setBuildUrl = setBuildUrl;
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
}