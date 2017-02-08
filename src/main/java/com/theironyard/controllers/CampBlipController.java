package com.theironyard.controllers;

import com.theironyard.services.InventoryItemsRepository;
import com.theironyard.services.OfficialSetRepository;
import com.theironyard.services.PartRepository;
import com.theironyard.services.ThemeRepository;
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
    InventoryItemsRepository items;

    @Autowired
    OfficialSetRepository sets;

    @Autowired
    PartRepository parts;

    @Autowired
    ThemeRepository themes;


    @PostConstruct
    public void init() {
    }

    @CrossOrigin
    @RequestMapping (path = "/sets", method = RequestMethod.GET)
    public SetViewModel homepage() {

        SetViewModel model = new SetViewModel();
//        String name, String set_num, int year, int num_parts, String set_img_url, String theme, String status, String skill_level, String inv_date, String inv_name, boolean inv_need, String last_checkout, Integer inv_parts, List<Part> missing_pieces, String notes
        SetView set = new SetView("Yellow Submarine", 2016, );



        return model;
    }

}
