package Browny.All.Controller;

import Browny.All.Entity.ClassDetailT;
import Browny.All.Entity.ClassSimpleT;
import Browny.All.Model.ClassDetailM;
import Browny.All.Model.ClassSimpleM;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
