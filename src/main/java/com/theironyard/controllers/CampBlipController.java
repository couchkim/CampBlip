package com.theironyard.controllers;

import com.theironyard.datamodels.Instructions.LegoWebImport;
import com.theironyard.datamodels.Instructions.Product;
import com.theironyard.datamodels.PartsImport.Color;
import com.theironyard.datamodels.PartsImport.PartImport;
import com.theironyard.datamodels.PartsImport.PartPiece;
import com.theironyard.datamodels.PartsImport.Result;
import com.theironyard.datamodels.SetImport;
import com.theironyard.datamodels.SkillEnum;
import com.theironyard.datamodels.StatusEnum;
import com.theironyard.datamodels.ThemeImport;
import com.theironyard.entities.Part;
import com.theironyard.entities.Set;
import com.theironyard.entities.SetPart;
import com.theironyard.helpers.SetHelper;
import com.theironyard.services.SetPartRepository;
import com.theironyard.services.UsersRepository;
import com.theironyard.services.SetRepository;
import com.theironyard.services.PartRepository;
import com.theironyard.viewmodels.FilterViewModel;
import com.theironyard.viewmodels.PartViewModel;
import com.theironyard.viewmodels.SetView;
import com.theironyard.viewmodels.SetViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.theironyard.datamodels.StatusEnum.AVAILABLE;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

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

    @Autowired
    RestTemplate restTemplate;

    @PostConstruct
    public void init() {
    }

    @RequestMapping (path = "/sets", method = RequestMethod.GET)
    public SetViewModel setsPage(String theme, String status, String skill) {
        List<Set> viewSets = new ArrayList<Set>();
        Set s = new Set();

            s.setTheme(theme);
            if(status != null) {
                s.setStatusEnum(StatusEnum.valueOf(status));
            }
            if(skill != null) {
                s.setSkillEnum(SkillEnum.valueOf(skill));
            }
            ExampleMatcher matcher = ExampleMatcher.matching()
                    .withIgnoreNullValues();
            viewSets = (List) sets.findAll(Example.of(s,matcher));

        SetViewModel model = new SetViewModel();

        for ( Set viewSet : viewSets) {
            SetView setView = new SetView(
                    viewSet.getSetName(),
                    viewSet.getId(),
                    viewSet.getSetNum(),
                    viewSet.getYear(),
                    viewSet.getNumParts(),
                    viewSet.getSetImgUrl(),
                    viewSet.getSetBuildUrl(),
                    viewSet.getTheme(),
                    viewSet.getStatusEnum(),
                    viewSet.getSkillEnum(),
                    "inv_date Currently Unavailable",
                    "inv_name Currently unavailable",
                    false,
                    "last_checkout Currently Unavailable",
                    42, //TODO: Count all the inventory parts
                    viewSet.getNotes());
            model.getSetViews().add(setView);
        }
        return model;
    }

    @RequestMapping (path = "/add-set/{set_num}", method = RequestMethod.POST)
    public List<String> addset(@PathVariable("set_num") String setId) {
        Map<String,String> apiSetIds = SetHelper.setCorrectId(setId);
        Map<String, String> urlParams = new HashMap<>();

        urlParams.put("rebrickable_set_num", apiSetIds.get("brickSetId"));
        urlParams.put("lego_set_num", apiSetIds.get("legoSetId"));
        urlParams.put("brickKey", System.getenv("SECRETBRICK_KEY"));

        SetImport newApiSet = restTemplate.getForObject(
                "https://rebrickable.com/api/v3/lego/sets/{rebrickable_set_num}/?key={brickKey}", SetImport.class, urlParams);
        System.out.println(newApiSet.toString());
        urlParams.put("theme_id", Integer.toString(newApiSet.getTheme_id()));
        ThemeImport newApiThemes = restTemplate.getForObject(
                "https://rebrickable.com/api/v3/lego/themes/{theme_id}/?key={brickKey}", ThemeImport.class, urlParams);
        System.out.println(newApiThemes.toString());
        PartImport newApiParts = restTemplate.getForObject(
                "https://rebrickable.com/api/v3/lego/sets/{rebrickable_set_num}/parts/?key={brickKey}", PartImport.class, urlParams);
        System.out.println(newApiParts.toString());
        LegoWebImport fromlego = restTemplate.getForObject(
                "https://www.lego.com/service/biservice/search?fromIndex=0&locale=en-US&onlyAlternatives=false&prefixText={lego_set_num}", LegoWebImport.class, urlParams);
        System.out.println(fromlego.toString());
        Product legoProducts = fromlego.getProducts().get(0);
        Set newSet = new Set (
                newApiSet.getSet_num(),
                newApiSet.getName(),
                newApiSet.getYear(),
                newApiSet.getNum_parts(),
                legoProducts.getThemeName(),
                newApiSet.getSet_img_url(),
                legoProducts.getBuildingInstructions().get(0).getPdfLocation(),
                AVAILABLE,
                SetHelper.setSkill(newApiParts.getCount()),
                null);
        newSet = sets.save(newSet);
        for (int i = 0; i < newApiParts.getCount(); i++) {
            Result thisPart = newApiParts.getResults().get(i);
            PartPiece thisPartDetail = thisPart.getPart();
            Color thisPartColor = thisPart.getColor();
            Part newPart = new Part(
                    thisPart.getElement_id(),
                    thisPartDetail.getName(),
                    thisPartDetail.getPart_img_url(),
                    thisPartColor.getName());
            if(parts.findFirstByElementId(thisPart.getElement_id()) == null) {
            newPart = parts.save(newPart);
            }
            SetPart legoSetPart = new SetPart(
            newSet, newPart, thisPart.getQuantity(), thisPart.getQuantity());
            setParts.save(legoSetPart);
        }
        List <String> addedSet = new ArrayList<>();
        addedSet.add(newSet.getSetName());
        addedSet.add(newSet.getSetNum());
        return addedSet;
    }

    @RequestMapping (path = "/parts/{set_id}", method = RequestMethod.GET)
    public PartViewModel partsPage(@PathVariable("set_id") int setId) {
        PartViewModel model = new PartViewModel();
        model.setParts(setParts.partViewFromSetId(setId));
        model.setSet_name(sets.findById(setId).getSetName());
        return model;
    }

    @RequestMapping (path = "/set/{set_id}", method = RequestMethod.POST)
    public Set setPage(@PathVariable("set_id") int setId) {
        return sets.findById(setId);
    }

    @RequestMapping (path = "/filters", method = RequestMethod.GET)
    public FilterViewModel filterLayout() {
        FilterViewModel model = new FilterViewModel();
        model.setThemes(sets.selectDistinctThemes());
        model.setSkills(Stream.of(SkillEnum.values()).map(Enum::name).collect(Collectors.toList()));
        model.setStatus(Stream.of(StatusEnum.values()).map(Enum::name).collect(Collectors.toList()));
        return model;
    }

//    @RequestMapping (path = "/status", method = RequestMethod.POST)
//    public Set updateStatus(@PathVariable("set_id") int setId, String status)

//    @RequestMapping (path = "/delete-set/{set_id}", method = RequestMethod.POST)
//    public  (@PathVariable("set_id") int setId) {
//         sets.delete(setId);
//    }
}