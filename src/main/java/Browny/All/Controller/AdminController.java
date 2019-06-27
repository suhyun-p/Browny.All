package Browny.All.Controller;

import Browny.All.Entity.ClassSimpleT;
import Browny.All.Model.ClassSimpleM;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @RequestMapping(value = "/regUser")
    public String RegUser(Model model) {
        return "/admin/regUser";
    }

    @RequestMapping(value = "/regClass")
    public String RegClass(Model model) {
        return "/admin/regClass";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> SignUp(@RequestBody Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        RestTemplate restTemplate = new RestTemplate();
        // ResponseEntity<String> ret = restTemplate.postForEntity("http://ec2-13-124-12-201.ap-northeast-2.compute.amazonaws.com:8080/api/user/signUp", params, String.class);
        ResponseEntity<String> ret = restTemplate.postForEntity("http://localhost:8080/api/user/signUp", params, String.class);
        resultMap.put("Message", ret);
        return resultMap;
    }
}
