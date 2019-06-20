package Browny.All.Controller;

import Browny.All.Entity.ClassDetailT;
import Browny.All.Entity.ClassSimpleT;
import Browny.All.Enum.*;
import Browny.All.Model.ClassDetailM;
import Browny.All.Model.ClassSimpleM;
import Browny.All.Model.UserM;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class WebController {
    @RequestMapping(value = "/")
    public String Index(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ClassSimpleT[]> ret = restTemplate.getForEntity("http://localhost:8080/api/class/getClassSimpleList", ClassSimpleT[].class);

        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        for(ClassSimpleT classSimpleT : ret.getBody())
            classSimpleList.add(new ClassSimpleM(classSimpleT));
        model.addAttribute("classSimpleList", classSimpleList);

        return "/index";
    }

    @RequestMapping(value = "/class")
    public String Class(Model model, @RequestParam("classNo") long classNo) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("http://localhost:8080/api/class/getClassDetail?classNo=%s", classNo);
        ResponseEntity<ClassDetailT> ret = restTemplate.getForEntity(url, ClassDetailT.class);
        model.addAttribute("classDetail", new ClassDetailM(ret.getBody()));

        return "/class";
    }

    @RequestMapping(value = "/instructor")
    public String Instructor(Model model, @RequestParam("instructorNo") long instructorNo) {
        RestTemplate restTemplate = new RestTemplate();
        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        UserM instructor = null;

        String classInProgressUrl = String.format("http://localhost:8080/api/class/getClassListByInstructor?instructorNo=%s", instructorNo);
        String classClosedUrl = String.format("http://localhost:8080/api/class/getClassListByInstructor?instructorNo=%s", instructorNo);
        String instructorUrl = String.format("http://localhost:8080/api/user/getUserByUserNo?userNo=%s", instructorNo);

        ResponseEntity<ClassSimpleT[]> classRet = restTemplate.getForEntity(classInProgressUrl, ClassSimpleT[].class);
        for(ClassSimpleT classSimpleT : classRet.getBody()) classSimpleList.add(new ClassSimpleM(classSimpleT));

        ResponseEntity<UserM> instructorRet = restTemplate.getForEntity(instructorUrl, UserM.class);
        instructor = instructorRet.getBody();

        model.addAttribute("classSimpleList", classSimpleList);
        model.addAttribute("instructor", instructor);
        // model.addAttribute("phoneNo", instructor.getContactList().stream().filter(x -> x.getType().equals("P")).);

        return "/instructor";
    }

    @RequestMapping(value = "/{type}/{value}")
    public String Search(Model model, @PathVariable("type") String type, @PathVariable("value") String value) {
        RestTemplate restTemplate = new RestTemplate();
        List<ClassSimpleM> classSimpleList = new ArrayList<>();

        String classUrl = "";
        String hashtag = "";

        switch (type) {
            case "genre":
                classUrl = String.format("http://localhost:8080/api/class/getClassListByGenre?genre=%s", value);
                hashtag = String.format("#%s", Genre.valueOf(value).getValue());
                break;
            case "region":
                classUrl = String.format("http://localhost:8080/api/class/getClassListByRegion?region=%s", value);
                hashtag = String.format("#%s", Region.valueOf(value).getValue());
                break;
            case "type":
                classUrl = String.format("http://localhost:8080/api/class/getClassListByType?type=%s", value);
                hashtag = String.format("#%s", ClassType.valueOf(value).getValue());
                break;
            case "only":
                classUrl = String.format("http://localhost:8080/api/class/getClassListByOnly?only=%s", value);
                hashtag = String.format("#%s", Only.valueOf(value).getValue());
                break;
        }

        ResponseEntity<ClassSimpleT[]> classRet = restTemplate.getForEntity(classUrl, ClassSimpleT[].class);
        for(ClassSimpleT classSimpleT : classRet.getBody()) classSimpleList.add(new ClassSimpleM(classSimpleT));

        model.addAttribute("classSimpleList", classSimpleList);
        model.addAttribute("hashtag", hashtag);

        return "/search";
    }
}
