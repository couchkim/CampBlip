package com.theironyard.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by graceconnelly on 2/12/17.
 */
@Entity
@Table(name = "inventory")
public class Inventory {
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

    public Inventory() {
    }

    public Inventory(int id, User user, Set set, String invDate, int missingParts) {
        this.id = id;
        this.user = user;
        this.set = set;
        this.invDate = invDate;
        this.missingParts = missingParts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public String getInvDate() {
        return invDate;
    }

    public void setInvDate(String invDate) {
        this.invDate = invDate;
    }

    public int getMissingParts() {
        return missingParts;
    }

    public void setMissingParts(int missingParts) {
        this.missingParts = missingParts;
    }
}
