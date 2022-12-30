package GUI.Utils;

import GUI.requestbody.DepartmentBody;
import GUI.requestbody.LessonBody;
import GUI.requestbody.PlanBody;
import GUI.requestbody.UserBody;
import com.dekanat.dekanat.server.entity.Semester;
import com.dekanat.dekanat.server.entity.Speciality;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


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

    public static String DepartmentToJSON(DepartmentBody departmentBody) throws JsonProcessingException {
        mapForJson.put("id", departmentBody.getId()+"");
        mapForJson.put("name", departmentBody.getName());

        return StringMapToJSON(mapForJson);
    }

    public static String LessonToJSON(LessonBody lessonBody) throws JsonProcessingException {
        mapForJson.put("id", lessonBody.getId()+"");
        mapForJson.put("name", lessonBody.getName());
        mapForJson.put("lectureH", lessonBody.getLectureH()+"");
        mapForJson.put("practiseH", lessonBody.getPractiseH()+"");
        mapForJson.put("laboratoryH", lessonBody.getLaboratoryH()+"");
        mapForJson.put("control", lessonBody.getControl()+"");
        mapForJson.put("index", lessonBody.getIndex()+"");
        mapForJson.put("semester", lessonBody.getSemester()+"");


        return StringMapToJSON(mapForJson);
    }

    public static String PlanToJSON(PlanBody planBody) throws JsonProcessingException {
        mapForJson.put("id", planBody.getId()+"");
        mapForJson.put("oldId", planBody.getOldId()+"");
        mapForJson.put("hours", planBody.getHours()+"");
        mapForJson.put("startDate", planBody.getStartDate()+"");
        mapForJson.put("endDate", planBody.getEndDate()+"");
        mapForJson.put("specialityNumber", planBody.getSpecialityNumber()+"");

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
