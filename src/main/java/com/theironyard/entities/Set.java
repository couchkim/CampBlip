package com.theironyard.entities;

import com.theironyard.models.SkillEnum;
import com.theironyard.models.Status;

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

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private String theme;

    @Column(nullable = false, name = "set_img_url")
    private String setImgUrl;

    @Column(nullable = false, name = "status")
    @Enumerated(EnumType.STRING)
    private  Status status;

    @Column(nullable = false , name = "skill_level")
    @Enumerated(EnumType.STRING)
    private SkillEnum skillEnum;

    private String notes;

    @OneToMany(mappedBy = "set")
    private List<SetPart> setParts = new ArrayList<SetPart>();

    public Set() {
    }

    public Set(String setNum, int year, String theme, String setImgUrl, Status status, SkillEnum skillEnum, String notes, List<SetPart> setParts) {
        this.setNum = setNum;
        this.year = year;
        this.theme = theme;
        this.setImgUrl = setImgUrl;
        this.status = status;
        this.skillEnum = skillEnum;
        this.notes = notes;
        this.setParts = setParts;
    }

    public void addPiece (SetPart part) {
        this.setParts.add(part);
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
