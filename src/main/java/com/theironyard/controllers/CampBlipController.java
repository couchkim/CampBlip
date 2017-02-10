package com.theironyard.controllers;

import com.theironyard.services.UsersRepository;
import com.theironyard.services.SetRepository;
import com.theironyard.services.PartRepository;
import com.theironyard.viewmodels.SetView;
import com.theironyard.viewmodels.SetViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created by graceconnelly on 2/7/17.
 */
@RestController
public class CampBlipController {
    @Autowired
    UsersRepository users;

    @Autowired
    SetRepository sets;

    @Autowired
    PartRepository parts;


    @PostConstruct
    public void init() {
    }

    @CrossOrigin
    @RequestMapping (path = "/sets", method = RequestMethod.GET)
    public SetViewModel homepage() {

        SetViewModel model = new SetViewModel();
//        String name, String set_num, int year, int num_parts, String set_img_url, String theme, String status, String skill_level, String inv_date, String inv_name, boolean inv_need, String last_checkout, Integer inv_parts, String notes
        SetView set = new SetView("Yellow Submarine", "21306-1" , 2016, 553, "https://m.rebrickable.com/media/sets/21306-1.jpg","LEGO Ideas and CUUSOO", "Checked Out", "Advanced", "2/7/2016", "Grace Connelly", true, "2/8/2016", 553, "these are some notes");
        model.getSets().add(set);


        return model;
    }

}
