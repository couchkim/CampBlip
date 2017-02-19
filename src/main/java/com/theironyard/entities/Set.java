package com.theironyard.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.theironyard.datamodels.Enums.InvEnum;
import com.theironyard.datamodels.Enums.SkillEnum;
import com.theironyard.datamodels.Enums.StatusEnum;

import javax.persistence.*;
import java.util.List;

/**
 * Created by graceconnelly on 2/7/17.
 */
@Entity
@Table(name = "sets")
public class Set {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    String setNum;

    @Column(nullable = false)
    String setName;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer numParts;

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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InvEnum invStatus;

    private String notes;

    private Boolean active;

    @JsonBackReference
    @OneToMany(mappedBy = "set")
    private List<SetPart> setParts;

    public Set() {
    }

    public Set(String setNum, String setName, Integer year, Integer numParts, String theme, String setImgUrl, String setBuildUrl, StatusEnum statusEnum, SkillEnum skillEnum, InvEnum invStatus, String notes, Boolean active) {
        this.setNum = setNum;
        this.setName = setName;
        this.year = year;
        this.numParts = numParts;
        this.theme = theme;
        this.setImgUrl = setImgUrl;
        this.setBuildUrl = setBuildUrl;
        this.statusEnum = statusEnum;
        this.skillEnum = skillEnum;
        this.invStatus = invStatus;
        this.notes = notes;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getNumParts() {
        return numParts;
    }

    public void setNumParts(Integer numParts) {
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

    public InvEnum getInvStatus() {
        return invStatus;
    }

    public void setInvStatus(InvEnum invStatus) {
        this.invStatus = invStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
                ", numParts=" + numParts +
                ", theme='" + theme + '\'' +
                ", setImgUrl='" + setImgUrl + '\'' +
                ", setBuildUrl='" + setBuildUrl + '\'' +
                ", statusEnum=" + statusEnum +
                ", skillEnum=" + skillEnum +
                ", invStatus=" + invStatus +
                ", notes='" + notes + '\'' +
                ", active=" + active +
                '}';
    }
}