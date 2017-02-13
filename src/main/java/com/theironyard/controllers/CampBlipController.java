package com.theironyard.controllers;

import com.theironyard.datamodels.PartsImport.Color;
import com.theironyard.datamodels.PartsImport.PartImport;
import com.theironyard.datamodels.PartsImport.PartPiece;
import com.theironyard.datamodels.PartsImport.Result;
import com.theironyard.datamodels.SetImport;
import com.theironyard.datamodels.ThemeImport;
import com.theironyard.entities.Part;
import com.theironyard.entities.Set;
import com.theironyard.entities.SetPart;
import com.theironyard.helpers.SetHelper;
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
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static com.theironyard.datamodels.StatusEnum.AVAILABLE;

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

    @PostConstruct
    public void init() {
    }

    @RequestMapping (path = "/sets", method = RequestMethod.GET)
    public SetViewModel homepage() {

        SetViewModel model = new SetViewModel();
//        String name, String set_num, int year, int num_parts, String set_img_url, String theme, String status, String skill_level, String inv_date, String inv_name, boolean inv_need, String last_checkout, Integer inv_parts, String notes
        //SetView set = new SetView("Yellow Submarine", "21306-1" , 2016, 553, "https://m.rebrickable.com/media/sets/21306-1.jpg","LEGO Ideas and CUUSOO", "Checked Out", "Advanced", "2/7/2016", "Grace Connelly", true, "2/8/2016", 553, "these are some notes");
        //builds a viewmodel for each set
        for ( Set viewSet : sets.findAll()) {
            SetView setView = new SetView(
                    viewSet.getSetName(),
                    viewSet.getSetNum(),
                    viewSet.getYear(),
                    viewSet.getNum_parts(),
                    viewSet.getSetImgUrl(),
                    viewSet.getTheme(),
                    viewSet.getStatusEnum(),
                    viewSet.getSkillEnum(),
                    "inv_date Currently Unavailable",
                    "inv_name Currently unavailable",
                    false,
                    "last_checkout Currently Unavailable",
                    42,
                    viewSet.getNotes());
            model.getSets().add(setView);
        }
        return model;
    }

    @RequestMapping (path = "/add-set/{set_id}", method = RequestMethod.POST)
    public SetViewModel addset(@PathVariable("set_id") String setId) {
        Map<String,String> apiSetIds = SetHelper.setCorrectId(setId);
        Map<String, String> urlParams = new HashMap<>();

        urlParams.put("rebrickable_set_id", apiSetIds.get("brickSetId"));
        urlParams.put("lego_set_id", apiSetIds.get("legoSetId"));
        urlParams.put("brickKey", System.getenv("SECRETBRICK_KEY"));

        SetImport newApiSet = restTemplate.getForObject(
                "https://rebrickable.com/api/v3/lego/sets/{rebrickable_set_id}/?key={brickKey}", SetImport.class, urlParams);
        urlParams.put("theme_id", Integer.toString(newApiSet.getTheme_id()));
        ThemeImport newApiThemes = restTemplate.getForObject(
                "https://rebrickable.com/api/v3/lego/themes/{theme_id}/?key={brickKey}", ThemeImport.class, urlParams);
        PartImport newApiParts = restTemplate.getForObject(
                "https://rebrickable.com/api/v3/lego/sets/{rebrickable_set_id}/parts/?key={brickKey}", PartImport.class, urlParams);
        //LegoWebImport fromlego = restTemplate.getForObject(
        //        "https://www.lego.com/service/biservice/search?fromIndex=0&locale=en-US&onlyAlternatives=false&prefixText={lego_set_id}", LegoWebImport.class, urlParams);
        System.out.println(newApiSet.toString());
        System.out.println(newApiThemes.toString());
        System.out.println(newApiParts.toString());
      //  String setNum, String setName, int year, String theme, String setImgUrl, StatusEnum statusEnum, SkillEnum skillEnum, String notes
        Set set = new Set (
                newApiSet.getSet_num(),
                newApiSet.getName(),
                newApiSet.getYear(),
                newApiParts.getCount(),
                newApiThemes.getName(), //TODO :write method to get parent id and return that if exists
                newApiSet.getSet_img_url(),
                AVAILABLE,
                SetHelper.setSkill(newApiParts.getCount()),
                null);
        sets.save(set);

        for (int i = 0; i < newApiParts.getCount(); i++) {
            Result thisPart = newApiParts.getResults().get(i);
            PartPiece thisPartDetail = thisPart.getPart();
            Color thisPartColor = thisPart.getColor();
            Part newPart = new Part(
                    thisPart.getElement_id(),
                    thisPartDetail.getName(),
                    thisPartDetail.getPart_img_url(),
                    thisPartColor.getName());
            if( parts.findFirstByElementId(thisPart.getElement_id()) == null) {
                parts.save(newPart);
            }
            SetPart legoSetPart = new SetPart();
            legoSetPart.setSet(set);
            legoSetPart.setPart(newPart);
            legoSetPart.setSetQty(thisPart.getQuantity());
            legoSetPart.setInvQty(thisPart.getQuantity());
            setParts.save(legoSetPart);
        }
        SetViewModel model = new SetViewModel();
        return model;
    }
}
