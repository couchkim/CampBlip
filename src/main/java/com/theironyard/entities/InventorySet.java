package com.theironyard.entities;

import com.theironyard.models.Status;

import javax.persistence.*;

/**
 * Created by graceconnelly on 2/7/17.
 */
@Entity
@Table(name = "inventory-sets")
public class InventorySet {
    @Id
    @GeneratedValue
    int id;

    @Enumerated(EnumType.STRING)
    public Status status;






}
