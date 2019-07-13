package Browny.All.Controller;

import Browny.All.Entity.ClassDetailT;
import Browny.All.Model.ClassDetailM;
import Browny.All.Model.ClassSimpleM;
import Browny.All.Model.Request.EditClassRequest;
import Browny.All.Model.Request.RegClassRequest;
import Browny.All.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/class")
public class ClassController {
    @Autowired
    ClassService classService;

    @RequestMapping(value = "/getClassSimpleList", method = RequestMethod.GET)
    public ResponseEntity<List<ClassSimpleM>> getClassSimpleList(@RequestParam(value="type",required=false) String type, @RequestParam(value="value",required=false) String value) {

        List<ClassSimpleM> classSimpleList = new ArrayList<>();

        switch (type == null ? "" : type) {
            case "genre":
                classSimpleList = classService.getClassSimpleListByGenre(value);
                break;
            case "region":
                classSimpleList = classService.getClassSimpleListByRegion(value);
                break;
            case "type":
                classSimpleList = classService.getClassSimpleListByType(value);
                break;
            case "only":
                classSimpleList = classService.getClassSimpleListByOnly(value);
                break;
            default:
                classSimpleList = classService.getClassSimpleList();
                break;
        }

        return new ResponseEntity(classSimpleList, OK);
    }

    @RequestMapping(value = "/getClassDetail", method = RequestMethod.GET)
    public ResponseEntity<ClassDetailM> getClassDetail(@RequestParam("classNo") long classNo) {
        ClassDetailM classDetail = classService.getClassDetail(classNo);
        return new ResponseEntity(classDetail, OK);
    }

    @RequestMapping(value = "/getClassListByInstructor", method = RequestMethod.GET)
    public ResponseEntity<ClassSimpleM> getClassListByInstructor(@RequestParam("instructorNo") Long instructorNo) {
        List<ClassSimpleM> classSimpleList = classService.getClassSimpleListByInstructor(instructorNo);
        return new ResponseEntity(classSimpleList, OK);
    }

    @RequestMapping(value = "/getClosedClassListByInstructor", method = RequestMethod.GET)
    public ResponseEntity<ClassSimpleM> getClosedClassListByInstructor(@RequestParam("instructorNo") Long instructorNo) {
        List<ClassSimpleM> classSimpleList = classService.getClosedClassSimpleListByInstructor(instructorNo);
        return new ResponseEntity(classSimpleList, OK);
    }

    @RequestMapping(value = "/regClass", method = RequestMethod.POST)
    public ResponseEntity<ClassDetailM> RegClass(@RequestBody ClassDetailM req) {
        ClassDetailM classDetail = classService.regClass(req);
        return new ResponseEntity(classDetail, OK);
    }

    @RequestMapping(value = "/editClass", method = RequestMethod.POST)
    public ResponseEntity<ClassDetailM> EditClass(@RequestBody ClassDetailM req) {
        ClassDetailM classDetail = classService.editClass(req);
        return new ResponseEntity(classDetail, OK);
    }
}
