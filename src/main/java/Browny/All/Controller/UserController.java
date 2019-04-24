package Browny.All.Controller;

import Browny.All.Entity.UserT;
import Browny.All.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUserTList", method = RequestMethod.GET)
    public ResponseEntity<List<UserT>> getUserTList() {
        List<UserT> userTList = userService.getUserTList();
        return new ResponseEntity(userTList, OK);
    }
}
