package com.theironyard.entities;

import com.theironyard.datamodels.Enums.StatusEnum;

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

    StatusEnum statusEnum;
}
