package Browny.All.Controller;

import Browny.All.Entity.UserT;
import Browny.All.Model.Request.EditUserRequest;
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
        List<UserM> userList = userService.GetUserList();
        return new ResponseEntity(userList, OK);
    }

    @RequestMapping(value = "/getUserByUserNo", method = RequestMethod.GET)
    public ResponseEntity<UserM> getUserByUserNo(@RequestParam("userNo") long userNo) {
        UserM user = userService.GetUser(userNo);
        return new ResponseEntity(user, OK);
    }

    @RequestMapping(value = "/getInstructorList", method = RequestMethod.GET)
    public ResponseEntity<List<UserM>> getInstructorList() {
        List<UserM> instructorList = userService.GetInstructorList();
        return new ResponseEntity(instructorList, OK);
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseEntity<UserM> signUp(@RequestBody SignUpRequest req) {
        UserM user = userService.SignUp(req);
        return new ResponseEntity(user, OK);
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public ResponseEntity<UserM> editUser(@RequestBody EditUserRequest req) {
        UserM user = userService.EditUser(req);
        return new ResponseEntity(user, OK);
    }
}
