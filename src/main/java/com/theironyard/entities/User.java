package com.theironyard.entities;

import com.theironyard.models.Status;

import javax.persistence.*;
import java.util.HashSet;

/**
 * Created by graceconnelly on 2/7/17.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    private String email;
}
