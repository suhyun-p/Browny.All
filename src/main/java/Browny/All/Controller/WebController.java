package Browny.All.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value = "/")
public class WebController {
    @RequestMapping(value = "/")
    public String Index(Model model) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> ret = restTemplate.getForEntity("http://localhost:8080/api/class/getClassSimpleList", Object.class);
        model.addAttribute("classSimpleList", ret.getBody());

        return "/index";
    }

    @RequestMapping(value = "/class")
    public String Class(Model model, @RequestParam("classNo") long classNo) {

        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("http://localhost:8080/api/class/getClassDetail?classNo=%s", classNo);
        ResponseEntity<Object> ret = restTemplate.getForEntity(url, Object.class);
        model.addAttribute("classDetail", ret.getBody());

        return "/class";
    }
}
