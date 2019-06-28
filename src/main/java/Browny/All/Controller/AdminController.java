package Browny.All.Controller;

import Browny.All.Entity.ClassDetailT;
import Browny.All.Entity.ClassSimpleT;
import Browny.All.Model.ClassDetailM;
import Browny.All.Model.ClassSimpleM;
import Browny.All.Model.UserM;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/editUser")
    public String EditUser(Model model, @RequestParam("userNo") long userNo) { return "/admin/editUser"; }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public UserM GetUserInfo(HttpServletRequest httpServletRequest, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String userNo = httpServletRequest.getParameter("userNo");
        String url = String.format("http://localhost:8080/api/user/getUserByUserNo?userNo=%s", userNo);
        ResponseEntity<UserM> ret = restTemplate.getForEntity(url, UserM.class);

        return ret.getBody();
    }

    @RequestMapping(value = "/regClass")
    public String RegClass(Model model) {
        return "/admin/regClass";
    }

    @RequestMapping(value = "/getInstructorList", method = RequestMethod.GET)
    @ResponseBody
    public UserM[] GetInstructorList(HttpServletRequest httpServletRequest, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserM[]> ret = restTemplate.getForEntity("http://localhost:8080/api/user/getInstructorList", UserM[].class);

        return ret.getBody();
    }

    @RequestMapping(value = "/editClass")
    public String EditClass(Model model, @RequestParam("classNo") long classNo) { return "/admin/editClass"; }

    @RequestMapping(value = "/getClassDetail", method = RequestMethod.GET)
    @ResponseBody
    public ClassDetailT GetClassDetail(HttpServletRequest httpServletRequest, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String classNo = httpServletRequest.getParameter("classNo");
        String url = String.format("http://localhost:8080/api/class/getClassDetail?classNo=%s", classNo);
        ResponseEntity<ClassDetailT> ret = restTemplate.getForEntity(url, ClassDetailT.class);

        return ret.getBody();
    }
}
