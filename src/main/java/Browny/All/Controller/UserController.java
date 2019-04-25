package Browny.All.Controller;

import Browny.All.Entity.UserT;
import Browny.All.Model.Request.SignUpRequest;
import Browny.All.Model.UserM;
import Browny.All.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public ResponseEntity<List<UserM>> getUserList() {
        List<UserM> userList = userService.getUserList();
        return new ResponseEntity(userList, OK);
    }

    @RequestMapping(value = "/getUserByUserNo", method = RequestMethod.GET)
    public ResponseEntity<UserM> getUserByUserNo(@RequestParam("userNo") long userNo) {
        UserM user = userService.getUser(userNo);
        return new ResponseEntity(user, OK);
    }

    @RequestMapping(value = "/getInstructorList", method = RequestMethod.GET)
    public ResponseEntity<List<UserM>> getInstructorList() {
        List<UserM> instructorList = userService.getInstructorList();
        return new ResponseEntity(instructorList, OK);
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseEntity<String> signup(@RequestBody SignUpRequest req) {
        String ret = userService.SignUp(req);
        return new ResponseEntity(ret, OK);
    }
}
