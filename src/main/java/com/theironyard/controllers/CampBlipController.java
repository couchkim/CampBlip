package com.theironyard.controllers;

import com.theironyard.datamodels.Enums.InvEnum;
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
import com.theironyard.entities.Status;
import com.theironyard.helpers.SetHelper;
import com.theironyard.services.SetPartRepository;
import com.theironyard.services.UsersRepository;
import com.theironyard.services.SetRepository;
import com.theironyard.services.PartRepository;
import com.theironyard.viewmodels.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.persistence.OrderBy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Native;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.theironyard.datamodels.Enums.InvEnum.COMPLETE;
import static com.theironyard.datamodels.Enums.InvEnum.IN_PROGRESS;
import static com.theironyard.datamodels.Enums.InvEnum.REQUIRED;
import static com.theironyard.datamodels.Enums.StatusEnum.AVAILABLE;
import static com.theironyard.datamodels.Enums.StatusEnum.CHECKED_OUT;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.NullHandling.NATIVE;

/**
 * Created by graceconnelly on 2/7/17.
 */

//changed from rest controller
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
//        if (sets.count() == 0 && setParts.count() == 0 && parts.count() == 0) {
//            addNewSet("4866");
//        }
    }

    //Gets For Sets
    //PERMISSIONS: All
    @RequestMapping (path = "/sets", method = RequestMethod.GET)
    public SetViewModel setsPage(String setName, String setNum, String theme, String status, String skill) {
        //Gets all sets filtered by existing filters and sorted by theme and num parts ascending
        List<Set> viewSets = new ArrayList<Set>();
        Set s = new Set();
            s.setActive(TRUE);
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
            Sort sort = new Sort(Sort.Direction.ASC, "Theme", "numParts");
            viewSets = (List) sets.findAll(Example.of(s,matcher), sort);
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
                    "06/30/2016", //ToDo: populate
                    "Marshall",//ToDo: populate
                    viewSet.getInvStatus(),
                    "05/01/2016", //Todo:
                    viewSet.getNumParts(), //TODO: Count all the inventory parts
                    viewSet.getNotes());
            model.getSetViews().add(setView);
        }
        return model;
    }

    @RequestMapping (path = "/deleted" , method = RequestMethod.GET)
    public SetViewModel deleted() {
            List<Set> viewSets = new ArrayList<Set>();
            Set s = new Set();
            s.setActive(FALSE);
            ExampleMatcher matcher = ExampleMatcher.matching()
                    .withIgnoreCase()
                    .withIgnoreNullValues()
                    .withMatcher("setName", contains())
                    .withMatcher("setNum", contains());
            Sort sort = new Sort(Sort.Direction.ASC, "Theme", "numParts");
            viewSets = (List) sets.findAll(Example.of(s, matcher), sort);
            SetViewModel model = new SetViewModel();
            for (Set viewSet : viewSets) {
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
                        "06/30/2016", //ToDo: populate
                        "Marshall",//ToDo: populate
                        viewSet.getInvStatus(),
                        "05/01/2016", //Todo:
                        viewSet.getNumParts(), //TODO: Count all the inventory parts
                        viewSet.getNotes());
                model.getSetViews().add(setView);
            }
            return model;
    }
    //PERMISSIONS: All
    @RequestMapping (path = "/set/{set_id}", method = RequestMethod.GET)
    public SetViewModel setPage(@PathVariable("set_id") Integer setId) {

        SetViewModel model = new SetViewModel();
        Set viewSet = sets.findById(setId);

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
                "06/30/2016", //ToDo: populate
                "Marshall",//ToDo: populate
                viewSet.getInvStatus(),
                "05/01/2016", //Todo:
                viewSet.getNumParts(), //TODO: Count all the inventory parts
                viewSet.getNotes());
        model.getSetViews().add(setView);

        return model;
    }

    //PERMISSIONS: ALL
    @RequestMapping (path = "/filters", method = RequestMethod.GET)
    public FilterViewModel filterLayout() {
        FilterViewModel model = new FilterViewModel();
        model.setThemes(sets.selectDistinctThemes());
        model.setSkills(Stream.of(SkillEnum.values()).map(Enum::name).collect(Collectors.toList()));
        model.setStatus(Stream.of(StatusEnum.values()).map(Enum::name).collect(Collectors.toList()));
        model.setInvStat(Stream.of(InvEnum.values()).map(Enum::name).collect(Collectors.toList()));
        return model;
    }

    //PERMISSIONS: COUNSELOR
    @RequestMapping (path = "/parts/{set_id}", method = RequestMethod.GET)
    public PartViewModel partsPage(@PathVariable("set_id") int setId) {
        PartViewModel model = new PartViewModel();
        model.setParts(setParts.partViewFromSetId(setId));
        model.setSet_name(sets.findById(setId).getSetName());
        return model;
    }

    //PERMISSIONS: ADMIN
    @RequestMapping (path = "/add-set/{set_num}", method = RequestMethod.POST)
    public List<String> addSet(@PathVariable("set_num") String setId) {
        return addNewSet(setId);
    }

    //PERMISSIONS: COUNSELOR
    @RequestMapping (path = "/set/{set_id}", method = RequestMethod.POST)
    public SetViewModel updateSetPage(@PathVariable("set_id") Integer setId, @RequestBody String [] infoUpdate) {
        Set viewSet = sets.findById(setId);

        if(infoUpdate[0] != null || infoUpdate[0].length() == 0) {
            viewSet.setStatusEnum(StatusEnum.valueOf(infoUpdate[0]));
        }
        if(infoUpdate[1]!= null || infoUpdate[1].length() == 0) {
            viewSet.setNotes(infoUpdate[1]);
        }
        sets.save(viewSet);

        SetViewModel model = new SetViewModel();

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
                "06/30/2016", //ToDo: populate
                "Marshall",//ToDo: populate
                viewSet.getInvStatus(),
                "05/01/2016", //Todo:
                viewSet.getNumParts(), //TODO: Count all the inventory parts
                viewSet.getNotes());
        model.getSetViews().add(setView);

        return model;
    }

    //PERMISSIONS: COUNSELOR
    //Change current status of set and record status and add to status table
    @RequestMapping (path = "set/status/{set_id}", method = RequestMethod.POST)
    public Set updateStatus(@PathVariable("set_id") int setId, String status) {
        Set update = sets.findById(setId);
//        System.out.println(update);
        update.setStatusEnum(StatusEnum.valueOf(status));
        //In the case that the status is changed to checked out the inventory status will be set to required.
        if(StatusEnum.valueOf(status).equals(CHECKED_OUT)) {
            update.setInvStatus(REQUIRED);
        }
//        System.out.println(update);
        //get user by id and add the user and and the current status to the enum record
        sets.save(update);

        return sets.findById(setId);
    }

    //PERMISSIONS: ADMIN
    @RequestMapping (path = "/delete-set/{set_id}", method = RequestMethod.POST)
    public void deleteSet(@PathVariable("set_id") Integer setId) {
        Set remove = sets.findById(setId);
        remove.setActive(false);
        sets.save(remove);
    }

    //PERMISSIONS: ADMIN
    @RequestMapping (path = "/add-all-sets", method = RequestMethod.POST)
    public Map<String,List<String>> addAllSets () {
        Map<String,List<String>> createdSets = new HashMap<>();
        if (sets.count() == 0) {
            try {
                File csvSets = new File("LeogSetsClean.csv");
                Scanner fileScanner = new Scanner(csvSets);
                List<String> seedSets = new ArrayList<>();
                while (fileScanner.hasNext()) {
                    String line = fileScanner.nextLine();
                    String[] columns = line.split(",");
                    seedSets.add(SetHelper.removeUTF8BOM(columns[0].replaceAll("\\s","")));
                }
                System.out.println(seedSets.toString());
                for (String setNum : seedSets) {
                    createdSets.put(setNum, addNewSet(setNum));
                }
                return createdSets;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return createdSets;
    }
    //Posts for Parts

    //PERMISSIONS: COUNSELOR
    @RequestMapping (path = "/parts/{set_id}", method = RequestMethod.POST)
    public Integer [] setPartInv(@PathVariable("set_id") int setId, @RequestBody Integer[] setPartInv) {
        if(setPartInv != null) {
            Set updateS = sets.findById(setId);
            //Save In progress inventory to last inventoried
            Integer [] saveArray = new Integer[] {9999,9999};
            if (Arrays.equals(setPartInv,saveArray)) {
                //Update all of the set parts to store the current inventory as the previous inventory
                // set current inventory to null
                // set the inventory flag to complete.
                for (SetPart part : updateS.getSetParts()) {
                    part.setInvQty(part.getCurrInv() == null ? 0 : part.getCurrInv());
                    part.setCurrInv(null);
                    setParts.save(part);
                }
                //set inv status to complete
                //set
                updateS.setInvStatus(COMPLETE);
                sets.save(updateS);
            }else {
                SetPart updateSP = setParts.findFirstById(setPartInv[0]);
                updateS.setInvStatus(IN_PROGRESS);
                updateSP.setCurrInv(setPartInv[1]);
                sets.save(updateS);
                setParts.save(updateSP);
                return setPartInv;
            }
        }
        return new Integer[2];
    }
    //Methods for Sets

    public List<String> addNewSet (String setNum) {

        List<String> addedSet = new ArrayList<>();
        Map<String, String> apiSetIds = SetHelper.setCorrectId(setNum);
        Map<String, String> urlParams = new HashMap<>();

        System.out.println("THIS IS THE SET NUM" + apiSetIds.get("brickSetId"));

        urlParams.put("rebrickable_set_num", apiSetIds.get("brickSetId"));
        urlParams.put("lego_set_num", apiSetIds.get("legoSetId"));
        urlParams.put("brickKey", System.getenv("SECRETBRICK_KEY"));

        SetImport newApiSet = null;
        try {
            newApiSet = restTemplate.getForObject(
                    "https://rebrickable.com/api/v3/lego/sets/{rebrickable_set_num}/?key={brickKey}", SetImport.class, urlParams);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        if (newApiSet == null) {
            addedSet.add(apiSetIds.get("brickSetId"));
            return addedSet;
        }
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
                (newApiSet.getSet_num()).substring(0,newApiSet.getSet_num().length() - 2),
                newApiSet.getName(),
                newApiSet.getYear(),
                newApiSet.getNum_parts(),
                //If the lego set doesn't exist in the lego api then it grabs the theme from rebrickable
                legoProducts.getProductId() != apiSetIds.get("legoSetId") ? newApiThemes.getName() : legoProducts.getThemeName(),
                newApiSet.getSet_img_url(),
                //If the lego  set doesn't exist in the lego api then sets the directions to null rather than giving the wrong directions.
                legoProducts.getProductId() == apiSetIds.get("legoSetId") ? null : legoProducts.getBuildingInstructions().get(0).getPdfLocation(),
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
        addedSet.add(newSet.getSetName());
        addedSet.add(newSet.getSetNum());

        return addedSet;
    }
}