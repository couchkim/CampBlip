package com.theironyard.controllers;

import com.theironyard.datamodels.Instructions.LegoWebImport;
import com.theironyard.datamodels.Instructions.Product;
import com.theironyard.datamodels.PartsImport.Color;
import com.theironyard.datamodels.PartsImport.PartImport;
import com.theironyard.datamodels.PartsImport.PartPiece;
import com.theironyard.datamodels.PartsImport.Result;
import com.theironyard.datamodels.SetImport;
import com.theironyard.datamodels.Enums.SkillEnum;
import com.theironyard.datamodels.Enums.StatusEnum;
import com.theironyard.datamodels.ThemeImport;
import com.theironyard.entities.Part;
import com.theironyard.entities.Set;
import com.theironyard.entities.SetPart;
import com.theironyard.helpers.SetHelper;
import com.theironyard.services.SetPartRepository;
import com.theironyard.services.UsersRepository;
import com.theironyard.services.SetRepository;
import com.theironyard.services.PartRepository;
import com.theironyard.viewmodels.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.theironyard.datamodels.Enums.InvEnum.COMPLETE;
import static com.theironyard.datamodels.Enums.InvEnum.IN_PROGRESS;
import static com.theironyard.datamodels.Enums.StatusEnum.AVAILABLE;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

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
//        if (sets.count() == 0) {
//            try {
//                File csvSets = new File("LegoSets.csv");
//                Scanner fileScanner = new Scanner(csvSets);
//                List<String> seedSets = new ArrayList<>();
//                while (fileScanner.hasNext()) {
//                    String line = fileScanner.nextLine();
//                    String[] columns = line.split(",");
//                    addSet(columns[0]);
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        if (sets.count() == 0 && setParts.count() == 0 && parts.count() == 0) {
            addNewSet("4866");
        }
    }

    @RequestMapping (path = "/sets", method = RequestMethod.GET)
    public SetViewModel setsPage(String setName, String setNum, String theme, String status, String skill) {
        List<Set> viewSets = new ArrayList<Set>();
        Set s = new Set();
            if (setName != null && setName.length() != 0) {
                s.setSetName(setName);
            }
            if (setNum != null && setNum.length() != 0) {
                s.setSetNum(setNum);
            }
            if(theme != null && theme.length() != 0) {
                s.setTheme(theme);
            }
            if(status != null && status.length() != 0) {
                s.setStatusEnum(StatusEnum.valueOf(status));
            }
            if(skill != null && skill.length() != 0) {
                s.setSkillEnum(SkillEnum.valueOf(skill));
            }
            ExampleMatcher matcher = ExampleMatcher.matching()
                    .withIgnoreCase()
                    .withIgnoreNullValues()
                    .withMatcher("setName", contains())
                    .withMatcher("setNum", contains());

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
                    "inv_date Currently Unavailable", //ToDo: populate
                    "inv_name Currently unavailable",//ToDo: populate
                    false, //todo:populate and add as a enum
                    "last_checkout Currently Unavailable", //Todo:
                    42, //TODO: Count all the inventory parts
                    viewSet.getNotes());
            model.getSetViews().add(setView);
        }
        return model;
    }

    @RequestMapping (path = "/add-set/{set_num}", method = RequestMethod.POST)
    public List<String> addSet(@PathVariable("set_num") String setId) {
        return addNewSet(setId);
    }

    @RequestMapping (path = "/parts/{set_id}", method = RequestMethod.GET)
    public PartViewModel partsPage(@PathVariable("set_id") int setId) {
        PartViewModel model = new PartViewModel();
        model.setParts(setParts.partViewFromSetId(setId));
        model.setSet_name(sets.findById(setId).getSetName());
        return model;
    }

    @RequestMapping (path = "/parts/{set_id}", method = RequestMethod.POST)
    public int setPartInv(@RequestBody Integer[] setPartInv) {
        SetPart updateSP = setParts.findFirstById(setPartInv[0]);
        Set updateS = sets.findById(updateSP.getSet().getId());
        updateS.setInvStatus(IN_PROGRESS);
        updateSP.setInvQty(setPartInv[1]);
        setParts.save(updateSP);
        return 1;
    }

    @RequestMapping (path = "/set/{set_id}", method = RequestMethod.GET) //TODO: change this to a get instead of a post
    public Set setPage(@PathVariable("set_id") Integer setId) {
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

    @RequestMapping (path = "set/status/{set_id}", method = RequestMethod.POST)
    public Set updateStatus(@PathVariable("set_id") int setId, String status) {
        Set update = sets.findById(setId);
        System.out.println(update);
        update.setStatusEnum(StatusEnum.valueOf(status));

        System.out.println(update);
        sets.save(update);

        return sets.findById(setId);
    }

    @RequestMapping (path = "/delete-set/{set_id}", method = RequestMethod.POST)
    public void deleteSet(@PathVariable("set_id") Integer setId) {
    }

    public List<String> addNewSet (String setNum) {

        Map<String, String> apiSetIds = SetHelper.setCorrectId(setNum);
        Map<String, String> urlParams = new HashMap<>();

        urlParams.put("rebrickable_set_num", apiSetIds.get("brickSetId"));
        urlParams.put("lego_set_num", apiSetIds.get("legoSetId"));
        urlParams.put("brickKey", System.getenv("SECRETBRICK_KEY"));

        SetImport newApiSet = restTemplate.getForObject(
                "https://rebrickable.com/api/v3/lego/sets/{rebrickable_set_num}/?key={brickKey}", SetImport.class, urlParams);
        //System.out.println(newApiSet.toString());
        urlParams.put("theme_id", Integer.toString(newApiSet.getTheme_id()));
        ThemeImport newApiThemes = restTemplate.getForObject(
                "https://rebrickable.com/api/v3/lego/themes/{theme_id}/?key={brickKey}", ThemeImport.class, urlParams);
        //System.out.println(newApiThemes.toString());
        PartImport newApiParts = restTemplate.getForObject(
                "https://rebrickable.com/api/v3/lego/sets/{rebrickable_set_num}/parts/?key={brickKey}", PartImport.class, urlParams);
        //System.out.println(newApiParts.toString());
        LegoWebImport fromlego = restTemplate.getForObject(
                "https://www.lego.com/service/biservice/search?fromIndex=0&locale=en-US&onlyAlternatives=false&prefixText={lego_set_num}", LegoWebImport.class, urlParams);
        //System.out.println(fromlego.toString());
        Product legoProducts = fromlego.getProducts().get(0);
        Set newSet = new Set(
                newApiSet.getSet_num(),
                newApiSet.getName(),
                newApiSet.getYear(),
                newApiSet.getNum_parts(),
                legoProducts.getThemeName(),
                newApiSet.getSet_img_url(),
                legoProducts.getBuildingInstructions().get(0).getPdfLocation(),
                AVAILABLE,
                SetHelper.setSkill(newApiSet.getNum_parts()),
                COMPLETE, null, true);
        newSet = sets.saveAndFlush(newSet);
        for (int i = 0; i < newApiParts.getCount(); i++) {
            Result thisPart = newApiParts.getResults().get(i);
            PartPiece thisPartDetail = thisPart.getPart();
            Color thisPartColor = thisPart.getColor();
            Part newPart = new Part(
                    thisPart.getElement_id(),
                    thisPartDetail.getName(),
                    thisPartDetail.getPart_img_url(),
                    thisPartColor.getName());
            if (parts.findFirstByElementId(thisPart.getElement_id()) == null) {
                newPart = parts.saveAndFlush(newPart);
            }
            SetPart legoSetPart = new SetPart(
                    newSet, newPart, thisPart.getQuantity(), thisPart.getQuantity(), null, true);
            setParts.saveAndFlush(legoSetPart);
        }
        List<String> addedSet = new ArrayList<>();
        addedSet.add(newSet.getSetName());
        addedSet.add(newSet.getSetNum());

        return addedSet;
    }
}