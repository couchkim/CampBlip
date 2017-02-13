package com.theironyard.helpers;

import com.theironyard.datamodels.SkillEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by graceconnelly on 2/11/17.
 */
public class SetHelper {
    public static Map<String,String> setCorrectId (String setId) {
        Map<String,String> apiSetIds = new HashMap<>();
        //get last two character of input id does is equal -1
        if(setId.substring(setId.length()-2,setId.length()).equals("-1")){
            apiSetIds.put("brickSetId", setId);
            apiSetIds.put("legoSetId", setId.substring(0,setId.length()-2));
        }else {
            apiSetIds.put("brickSetId", setId+"-1");
            apiSetIds.put("legoSetId", setId);
        }
        return apiSetIds;
    }
    public static SkillEnum setSkill (int count) {
        if (count < 200) {
            return SkillEnum.BEGINNER;
        }
        if (count < 500) {
            return SkillEnum.INTERMEDIATE;
        }
        if (count < 1000) {
            return SkillEnum.ADVANCED;
        } else {
            return SkillEnum.EXPERT;
        }
    }
}
