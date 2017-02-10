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
    private int id;

    @Column(nullable = false)
    private int elementId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

}
