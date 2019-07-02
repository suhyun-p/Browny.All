package Browny.All.Controller;

import Browny.All.Entity.ClassDetailT;
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
    public ResponseEntity<List<ClassSimpleM>> getClassSimpleList() {
        List<ClassSimpleM> classSimpleList = classService.getClassSimpleList();

        return new ResponseEntity(classSimpleList, OK);
    }

    @RequestMapping(value = "/getClassDetail", method = RequestMethod.GET)
    public ResponseEntity<ClassDetailT> getClassDetail(@RequestParam("classNo") long classNo) {
        ClassDetailT classDetail = classService.getClassDetail(classNo);
        return new ResponseEntity(classDetail, OK);
    }

    @RequestMapping(value = "/getClassListByGenre", method = RequestMethod.GET)
    public ResponseEntity<List<ClassSimpleT>> getClassListByGenre(@RequestParam("genre") String genre) {
        List<ClassSimpleT> classSimpleList = classService.getClassSimpleListByGenre(genre);
        return new ResponseEntity(classSimpleList, OK);
    }

    @RequestMapping(value = "/getClassListByRegion", method = RequestMethod.GET)
    public ResponseEntity<List<ClassSimpleT>> getClassListByRegion(@RequestParam("region") String region) {
        List<ClassSimpleT> classSimpleList = classService.getClassSimpleListByRegion(region);
        return new ResponseEntity(classSimpleList, OK);
    }

    @RequestMapping(value = "/getClassListByType", method = RequestMethod.GET)
    public ResponseEntity<List<ClassSimpleT>> getClassListByType(@RequestParam("type") String type) {
        List<ClassSimpleT> classSimpleList = classService.getClassSimpleListByType(type);
        return new ResponseEntity(classSimpleList, OK);
    }

    @RequestMapping(value = "/getClassListByOnly", method = RequestMethod.GET)
    public ResponseEntity<ClassSimpleT> getClassListByOnly(@RequestParam("only") String only) {
        List<ClassSimpleT> classSimpleList = classService.getClassSimpleListByOnly(only);
        return new ResponseEntity(classSimpleList, OK);
    }

    @RequestMapping(value = "/getClassListByInstructor", method = RequestMethod.GET)
    public ResponseEntity<ClassSimpleT> getClassListByInstructor(@RequestParam("instructorNo") Long instructorNo) {
        List<ClassSimpleT> classSimpleList = classService.getClassSimpleListByInstructor(instructorNo);
        return new ResponseEntity(classSimpleList, OK);
    }

    @RequestMapping(value = "/getClosedClassListByInstructor", method = RequestMethod.GET)
    public ResponseEntity<ClassSimpleT> getClosedClassListByInstructor(@RequestParam("instructorNo") Long instructorNo) {
        List<ClassSimpleT> classSimpleList = classService.getClosedClassSimpleListByInstructor(instructorNo);
        return new ResponseEntity(classSimpleList, OK);
    }
}
