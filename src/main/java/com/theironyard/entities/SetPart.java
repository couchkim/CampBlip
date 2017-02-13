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
@NamedQueries(value = {
        //@NamedQuery(name = "SetPart.findSetParts", query = "select p from SetPart p")
        @NamedQuery(name = "SetPart.getSetParts", query = "select new com.theironyard.viewmodels.PartView(pp.name, pp.color, pp.partUrl, pp.elementId, p.setQty, p.invQty) from SetPart p join p.part pp join q.set where q.id = setid")
       // @NamedQuery(name = "makesetpart", query = "select NEW com.theironyard.entities.SetPart(select p from SetPart p)")
})
public class SetPart {
    @Id
    @GeneratedValue
    @Column(name = "set_part_id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "set_id")
    private Set set;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "part_id")
    private Part part;

    @Column(nullable = false, name = "set_qty")
    private int setQty;

    @Column(nullable = false, name = "inv_qty")
    private int invQty;

    public SetPart() {
    }

    public SetPart(Set set, Part part, int setQty, int invQty) {
        this.set = set;
        this.part = part;
        this.setQty = setQty;
        this.invQty = invQty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getSetQty() {
        return setQty;
    }

    public void setSetQty(int setQty) {
        this.setQty = setQty;
    }

    public int getInvQty() {
        return invQty;
    }

    public void setInvQty(int invQty) {
        this.invQty = invQty;
    }
}
