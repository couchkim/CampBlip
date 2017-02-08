package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by graceconnelly on 2/7/17.
 */
@Entity
@Table(name = "parts")
public class Part {
    @Id
    @GeneratedValue
    int id;

    @Column
    int element_id;

    @Column
    String name;

    @Column
    int quantity;
}
