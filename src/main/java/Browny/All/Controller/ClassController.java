package Browny.All.Controller;

import Browny.All.Entity.ClassSimpleT;
import Browny.All.Entity.ClassT;
import Browny.All.Model.ClassM;
import Browny.All.Model.ClassSimpleM;
import Browny.All.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/class")
public class ClassController {
    @Autowired
    ClassService classService;

    @RequestMapping(value = "/getClassSimpleList", method = RequestMethod.GET)
    public ResponseEntity<List<ClassSimpleT>> getClassSimpleTList() {
        List<ClassSimpleT> classSimpleList = classService.getClassSimpleList();

        return new ResponseEntity(classSimpleList, OK);
    }

    @RequestMapping(value = "/getClassDetail", method = RequestMethod.GET)
    public ResponseEntity<ClassM> getClassDetail(@RequestParam("classNo") long classNo) {
        ClassM classDatail = classService.getClassDetail(classNo);

        return new ResponseEntity(classDatail, OK);
    }
}
