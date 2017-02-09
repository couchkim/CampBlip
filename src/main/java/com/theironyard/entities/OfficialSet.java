package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by graceconnelly on 2/7/17.
 */
@Entity
@Table(name = "sets")
public class OfficialSet {
    @Id
    @GeneratedValue
    int id;

    @Column
    String setNum;

    @Column
    int year;

    @Column
    int themeId;

    @Column
    int numParts;

    @Column
    String setImgUrl;

    public OfficialSet() {
    }

    public OfficialSet(String setNum, int year, int themeId, int numParts, String setImgUrl) {
        this.setNum = setNum;
        this.year = year;
        this.themeId = themeId;
        this.numParts = numParts;
        this.setImgUrl = setImgUrl;
    }
}
