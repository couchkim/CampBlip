package com.theironyard.helpers;

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

}
