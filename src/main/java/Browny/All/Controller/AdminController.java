package Browny.All.Controller;

import Browny.All.Entity.ClassSimpleT;
import Browny.All.Model.ClassSimpleM;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @RequestMapping(value = "/user")
    public String User(Model model) {
        return "/admin/user";
    }

    @RequestMapping(value = "/class")
    public String Class(Model model) {
        return "/admin/class";
    }
}
