package com.theironyard.controllers;

import com.theironyard.services.InventoryItemsRepository;
import com.theironyard.services.OfficialSetRepository;
import com.theironyard.services.PartRepository;
import com.theironyard.services.ThemeRepository;
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
        model.setHello("Hello, world!");
        return model;
    }

}
