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
    @RequestMapping(value = "/regUser")
    public String RegUser(Model model) {
        return "/admin/regUser";
    }

    @RequestMapping(value = "/regClass")
    public String RegClass(Model model) {
        return "/admin/regClass";
    }
}
