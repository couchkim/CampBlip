package com.theironyard.entities;

import com.theironyard.models.Status;

import javax.persistence.*;

/**
 * Created by graceconnelly on 2/7/17.
 */
@Entity
@Table(name = "items")
public class InventoryItems {
    @Id
    @GeneratedValue
    int id;

    @Enumerated(EnumType.STRING)
    public Status status;

    public InventoryItems() {
    }

    public InventoryItems(Status status) {
        this.status = status;
    }
}
