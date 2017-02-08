package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by graceconnelly on 2/7/17.
 */
@Entity
@Table(name = "offical-sets")
public class OfficialSet {
    @Id
    @GeneratedValue
    int id;

    @Column
    String set_num;

    @Column
    int year;

    @Column
    int theme_id;

    @Column
    int num_parts;

    @Column
    String set_img_url;
}
