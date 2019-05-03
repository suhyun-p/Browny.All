package Browny.All.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value = "/")
public class WebController {
    @RequestMapping(value = "/")
    public String Index(Model model) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> ret = restTemplate.getForEntity("http://localhost:8080/api/class/getClassList", Object.class);
        model.addAttribute("classList", ret.getBody());

        return "/index";
    }
}
