package GUI.Utils;

import GUI.requestbody.UserBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.HashMap;
import java.util.Map;


public class JsonHelper {

    private static Map<String, String> mapForJson = new HashMap<>();

    public static String UserToJSON(UserBody userBody) throws JsonProcessingException {
        mapForJson.put("id", userBody.getId()+"");
        mapForJson.put("login", userBody.getLogin());
        mapForJson.put("pswrd", userBody.getPswrd());
        mapForJson.put("fio", userBody.getFio());
        mapForJson.put("role", userBody.getRole()+"");
        return StringMapToJSON(mapForJson);
    }
    public static String StringMapToJSON(Map<String,String> mapForJson) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.writeValueAsString(mapForJson);
    }

    public static String replacer(String json){
        String newJson = json.replace("%22","\"");
        newJson = newJson.replace("%2C",",");
        newJson = newJson.replace("%7B", "{");
        newJson = newJson.replace("%3A", ":");
        newJson = newJson.replace("%7D=", "}");

        return newJson;
    }



}
