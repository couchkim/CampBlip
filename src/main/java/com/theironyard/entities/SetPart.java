package com.theironyard.entities;

import org.hibernate.annotations.*;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by graceconnelly on 2/9/17.
 */

//Creates a joins tables between sets and parts so that many parts and belong to many sets.
@Entity
@Table(name = "sets_parts")
public class SetPart {
    @Id
    @GeneratedValue
    @Column(name = "set_part_id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "set_id")
    private Set set;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "part_id")
    private Part part;

    @Column(nullable = false, name = "set_qty")
    private Integer setQty;

    @Column(nullable = false, name = "inv_qty")
    private Integer invQty;

    @Column(nullable = true, name = "curr_inv")
    private Integer currInv;

    private boolean active;

    public SetPart() {
    }

    public SetPart(Set set, Part part, Integer setQty, Integer invQty, Integer currInv, boolean active) {
        this.set = set;
        this.part = part;
        this.setQty = setQty;
        this.invQty = invQty;
        this.currInv = currInv;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public Integer getSetQty() {
        return setQty;
    }

    public void setSetQty(Integer setQty) {
        this.setQty = setQty;
    }

    public Integer getInvQty() {
        return invQty;
    }

    public void setInvQty(Integer invQty) {
        this.invQty = invQty;
    }

    public Integer getCurrInv() {
        return currInv;
    }

    public void setCurrInv(Integer currInv) {
        this.currInv = currInv;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}