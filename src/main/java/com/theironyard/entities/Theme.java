package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by graceconnelly on 2/7/17.
 */
@Entity
@Table(name = "themes")
public class Theme {
    @Id
    @GeneratedValue
    int local_id;

    @Column
    int official_id;

    @Column
    Integer official_parent_id;

    @Column
    String name;
}
