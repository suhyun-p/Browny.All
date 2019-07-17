package Browny.All.Controller;

import Browny.All.Entity.ClassDetailT;
import Browny.All.Enum.*;
import Browny.All.Model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/")
public class WebController {
    @RequestMapping(value = "/")
    public String Index(Model model) { return "/index"; }

    @RequestMapping(value = "/genre/{code}")
    public String Genre(Model model, @PathVariable("code") String code) {
        model.addAttribute("genreText",String.format("#%s",Genre.valueOf(code).getValue()));
        return "/genre";
    }

    @RequestMapping(value = "/region/{code}")
    public String Region(Model model, @PathVariable("code") String code) {
        model.addAttribute("regionText",String.format("#%s",Region.valueOf(code).getValue()));
        return "/region";
    }

    @RequestMapping(value = "/type/{code}")
    public String Type(Model model, @PathVariable("code") String code) {
        model.addAttribute("typeText",String.format("#%s",ClassType.valueOf(code).getValue()));
        return "/type";
    }

    @RequestMapping(value = "/only/{code}")
    public String Only(Model model, @PathVariable("code") String code) {
        model.addAttribute("onlyText",String.format("#%s",Only.valueOf(code).getValue()));
        return "/only";
    }

    @RequestMapping(value = "/getClassSimpleList", method = RequestMethod.GET)
    @ResponseBody
    public ClassSimpleM[] GetClassSimpleList(HttpServletRequest httpServletRequest, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String type = httpServletRequest.getParameter("type");
        String value = httpServletRequest.getParameter("value");
        String url = String.format("http://localhost:8080/api/class/getClassSimpleList?type=%s&value=%s", type, value);
        ResponseEntity<ClassSimpleM[]> ret = restTemplate.getForEntity(url, ClassSimpleM[].class);

        return ret.getBody();
    }

    @RequestMapping(value = "/instructor")
    public String Instructor(Model model, @RequestParam("instructorNo") long instructorNo) { return "/instructor"; }

    @RequestMapping(value = "/getInstructorInfo", method = RequestMethod.GET)
    @ResponseBody
    public UserModel GetInstructorInfo(HttpServletRequest httpServletRequest, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String instructorNo = httpServletRequest.getParameter("instructorNo");
        String url = String.format("http://localhost:8080/api/user/getUserByUserNo?userNo=%s", instructorNo);
        ResponseEntity<UserM> ret = restTemplate.getForEntity(url, UserM .class);

        return new UserModel(ret.getBody());
    }

    @RequestMapping(value = "/getClassListByInstructor", method = RequestMethod.GET)
    @ResponseBody
    public ClassSimpleM[] GetClassListByInstructor(HttpServletRequest httpServletRequest, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String instructorNo = httpServletRequest.getParameter("instructorNo");
        String url = String.format("http://localhost:8080/api/class/getClassListByInstructor?instructorNo=%s", instructorNo);
        ResponseEntity<ClassSimpleM[]> ret = restTemplate.getForEntity(url, ClassSimpleM[].class);

        return ret.getBody();
    }

    @RequestMapping(value = "/getClosedClassListByInstructor", method = RequestMethod.GET)
        @ResponseBody
        public ClassSimpleM[] GetClosedClassListByInstructor(HttpServletRequest httpServletRequest, Model model) {

            RestTemplate restTemplate = new RestTemplate();
            String instructorNo = httpServletRequest.getParameter("instructorNo");
            String url = String.format("http://localhost:8080/api/class/getClosedClassListByInstructor?instructorNo=%s", instructorNo);
            ResponseEntity<ClassSimpleM[]> ret = restTemplate.getForEntity(url, ClassSimpleM[].class);

        return ret.getBody();
    }

    @RequestMapping(value = "/class")
    public String Class(Model model, @RequestParam("classNo") long classNo) { return "/class"; }

    @RequestMapping(value = "/getClassDetail", method = RequestMethod.GET)
    @ResponseBody
    public ClassDetailModel GetClassDetail(HttpServletRequest httpServletRequest, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String classNo = httpServletRequest.getParameter("classNo");
        String url = String.format("http://localhost:8080/api/class/getClassDetail?classNo=%s", classNo);
        ResponseEntity<ClassDetailM> ret = restTemplate.getForEntity(url, ClassDetailM.class);

        return new ClassDetailModel(ret.getBody());
    }

    @RequestMapping(value = "/club")
    public String Club(Model model, @RequestParam("clubNo") long clubNo) { return "/club"; }

    @RequestMapping(value = "/getClubInfo", method = RequestMethod.GET)
    @ResponseBody
    public ClubM GetClubInfo(HttpServletRequest httpServletRequest, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String clubNo = httpServletRequest.getParameter("clubNo");
        String url = String.format("http://localhost:8080/api/club/getClubByClubNo?clubNo=%s", clubNo);
        ResponseEntity<ClubM> ret = restTemplate.getForEntity(url, ClubM .class);

        return ret.getBody();
    }

    @RequestMapping(value = "/getClassListByClub", method = RequestMethod.GET)
    @ResponseBody
    public ClassSimpleM[] GetClassListByClub(HttpServletRequest httpServletRequest, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String clubNo = httpServletRequest.getParameter("clubNo");
        String url = String.format("http://localhost:8080/api/class/getClassListByClub?clubNo=%s", clubNo);
        ResponseEntity<ClassSimpleM[]> ret = restTemplate.getForEntity(url, ClassSimpleM[].class);

        return ret.getBody();
    }
}
