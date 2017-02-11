package com.theironyard.controllers;

import com.theironyard.datamodels.PartsImport.PartImport;
import com.theironyard.datamodels.SetImport;
import com.theironyard.datamodels.ThemeImport;
import com.theironyard.services.SetPartRepository;
import com.theironyard.services.UsersRepository;
import com.theironyard.services.SetRepository;
import com.theironyard.services.PartRepository;
import com.theironyard.viewmodels.SetView;
import com.theironyard.viewmodels.SetViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * Created by graceconnelly on 2/7/17.
 */
@RestController
public class CampBlipController {
    @Autowired
    UsersRepository users;

    @Autowired
    SetPartRepository setParts;

    @Autowired
    SetRepository sets;

    @Autowired
    PartRepository parts;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    RestTemplate restTemplate;

    Properties prop = new Properties();



    @PostConstruct
    public void init() {
        InputStream config = null;
        try{
            config = new FileInputStream(".env");
            prop.load(config);
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }finally {
            if (config != null) {
                try {
                    config.close();
                }
                    catch(IOException e) {
                        e.printStackTrace();
                }

            }
        }
    }

    @RequestMapping (path = "/sets", method = RequestMethod.GET)
    public SetViewModel homepage() {

        SetViewModel model = new SetViewModel();
//        String name, String set_num, int year, int num_parts, String set_img_url, String theme, String status, String skill_level, String inv_date, String inv_name, boolean inv_need, String last_checkout, Integer inv_parts, String notes
        SetView set = new SetView("Yellow Submarine", "21306-1" , 2016, 553, "https://m.rebrickable.com/media/sets/21306-1.jpg","LEGO Ideas and CUUSOO", "Checked Out", "Advanced", "2/7/2016", "Grace Connelly", true, "2/8/2016", 553, "these are some notes");
        model.getSets().add(set);

        return model;
    }

    @RequestMapping (path = "/add-set/{set_id}", method = RequestMethod.POST)
    public SetViewModel addset(@PathVariable("set_id") String setId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("set_id", setId);
        urlParams.put("brickKey", prop.getProperty("SECRETBRICK_KEY"));

        SetImport newSet = restTemplate.getForObject(
                "https://rebrickable.com/api/v3/lego/sets/{set_id}/?key={brickKey}", SetImport.class, urlParams);
        urlParams.put("theme_id", Integer.toString(newSet.getTheme_id()));
        ThemeImport theme = restTemplate.getForObject(
                "https://rebrickable.com/api/v3/lego/themes/{theme_id}/?key={brickKey}", ThemeImport.class, urlParams);
        PartImport parts = restTemplate.getForObject(
                "https://rebrickable.com/api/v3/lego/sets/{set_id}/parts/?key={brickKey}", PartImport.class, urlParams);
        System.out.println(newSet.toString());
        System.out.println(theme.toString());
        System.out.println(parts.toString());


        SetViewModel model = new SetViewModel();
        return model;
    }
}
