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
    int elementId;

    @Column
    String name;

    @Column
    int quantity;

    public Part() {
    }

    public Part(int elementId, String name, int quantity) {
        this.elementId = elementId;
        this.name = name;
        this.quantity = quantity;
    }
}
