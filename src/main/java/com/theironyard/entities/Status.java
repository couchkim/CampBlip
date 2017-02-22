package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by graceconnelly on 2/20/17.
 */
@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue
    int id;

    @ManyToOne
    User user;

    @ManyToOne
    Set set;

    @Column
    String invDate;

    @Column
    int missingParts;


}
