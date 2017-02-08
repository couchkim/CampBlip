package com.theironyard.controllers;

import com.theironyard.viewmodels.SetViewModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by graceconnelly on 2/7/17.
 */
@RestController
public class CampBlipController {

    @CrossOrigin
    @RequestMapping (path = "/sets", method = RequestMethod.GET)
    public SetViewModel homepage() {
        SetViewModel m  qodel = new SetViewModel();


        return model;
    }

}
