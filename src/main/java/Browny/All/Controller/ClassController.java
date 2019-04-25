package Browny.All.Controller;

import Browny.All.Entity.ClassT;
import Browny.All.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/class")
public class ClassController {
    @Autowired
    ClassService classService;

    @RequestMapping(value = "/getClassTList", method = RequestMethod.GET)
    public ResponseEntity<List<ClassT>> getClassTList() {
        List<ClassT> classTList = classService.getClassTList();

        return new ResponseEntity(classTList, OK);
    }
}
