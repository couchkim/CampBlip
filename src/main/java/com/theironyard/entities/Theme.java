package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by graceconnelly on 2/7/17.
 */
@Entity
@Table(name = "themes")
public class Theme {
    @Id
    @GeneratedValue
    int localId;

    @Column
    int officialId;

    @Column
    Integer officialParentId;

    @Column
    String name;

    public Theme() {
    }

    public Theme(int officialId, Integer officialParentId, String name) {
        this.officialId = officialId;
        this.officialParentId = officialParentId;
        this.name = name;
    }
}
