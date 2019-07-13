package Browny.All.Service;

import Browny.All.Entity.*;
import Browny.All.Enum.*;
import Browny.All.Model.*;
import Browny.All.Model.Request.ClassContactRequest;
import Browny.All.Model.Request.EditClassRequest;
import Browny.All.Model.Request.RegClassRequest;
import Browny.All.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClassDateOptionRepository classDateOptionRepository;

    @Autowired
    private ClassPriceOptionRepository classPriceOptionRepository;

    @Autowired
    private ClassContactRepository classContactRepository;

    @Autowired
    private ClassEarlybirdRepository classEarlybirdRepository;

    @Transactional
    public List<ClassSimpleM> getClassSimpleList() {
        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        // List<ClassT> classTList = classRepository.findAllByOrderByStartDateDesc();
        List<ClassT> classTList = classRepository.findAllByEndDateIsGreaterThanEqualOrderByStartDateDesc(LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleM(classT));

        return classSimpleList;
    }

    @Transactional
    public List<ClassSimpleM> getClassSimpleListByGenre(String genre) {
        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        // List<ClassT> classTList = classRepository.findAllByGenreIsOrderByStartDateDesc(genre);
        List<ClassT> classTList = classRepository.findAllByGenreIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(genre, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleM(classT));

        return classSimpleList;
    }

    @Transactional
    public List<ClassSimpleM> getClassSimpleListByRegion(String region) {
        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        // List<ClassT> classTList = classRepository.findAllByRegionIsOrderByStartDateDesc(region);
        List<ClassT> classTList = classRepository.findAllByRegionIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(region, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleM(classT));

        return classSimpleList;
    }

    @Transactional
    public List<ClassSimpleM> getClassSimpleListByType(String type) {
        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        // List<ClassT> classTList = classRepository.findAllByTypeIsOrderByStartDateDesc(type);
        List<ClassT> classTList = classRepository.findAllByTypeIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(type, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleM(classT));

        return classSimpleList;
    }

    @Transactional
    public List<ClassSimpleM> getClassSimpleListByOnly(String only) {
        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        // List<ClassT> classTList = classRepository.findAllByOnlyIsOrderByStartDateDesc(only);
        List<ClassT> classTList = classRepository.findAllByOnlyIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(only, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleM(classT));

        return classSimpleList;
    }

    @Transactional
    public List<ClassSimpleM> getClassSimpleListByInstructor(Long instructorNo) {
        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        UserT instructor = userRepository.getOne(instructorNo);
        // List<ClassT> classTList = classRepository.findAllByInstructor1OrInstructor2OrderByStartDateDesc(instructor, instructor);
        List<ClassT> classTList = classRepository.findAllByInstructor1AndEndDateIsGreaterThanEqualOrInstructor2AndEndDateIsGreaterThanEqualOrderByStartDateDesc(instructor, LocalDate.now(), instructor, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleM(classT));

        return classSimpleList;
    }

    @Transactional
    public List<ClassSimpleM> getClosedClassSimpleListByInstructor(Long instructorNo) {
        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        UserT instructor = userRepository.getOne(instructorNo);
        // List<ClassT> classTList = classRepository.findAllByInstructor1OrInstructor2OrderByStartDateDesc(instructor, instructor);
        List<ClassT> classTList = classRepository.findAllByInstructor1AndEndDateIsLessThanOrInstructor2AndEndDateIsLessThanOrderByStartDateDesc(instructor, LocalDate.now(), instructor, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleM(classT));

        return classSimpleList;
    }

    @Transactional
    public ClassDetailM getClassDetail(long classNo) {
        ClassT classT = classRepository.findById(classNo).get();
        return new ClassDetailM(classT);
    }

    @Transactional
    public ClassDetailM regClass(ClassDetailM req) {
        UserT instructor1= userRepository.findById(req.getInstructorNo1()).get();
        Optional<UserT> instructor2 = userRepository.findById(req.getInstructorNo2());
        ClassT classT = classRepository.save(new ClassT(req, instructor1, instructor2.isPresent() ? instructor2.get() : null));

        for (String option : req.getDateOptionList())
            classDateOptionRepository.save(new ClassDateOptionT(classT.getClassNo(), option));

        for (String option : req.getPriceOptionList())
            classPriceOptionRepository.save(new ClassPriceOptionT(classT.getClassNo(), option));

        for (ClassContactM contact : req.getClassContactList())
            classContactRepository.save(new ClassContactT(classT.getClassNo(), contact));

        return getClassDetail(classT.getClassNo());
    }

    @Transactional
    public ClassDetailM editClass(ClassDetailM req) {
        UserT instructor1= userRepository.findById(req.getInstructorNo1()).get();
        Optional<UserT> instructor2 = userRepository.findById(req.getInstructorNo2());

        ClassT classT = classRepository.findById(req.getClassNo()).get();
        classT.setGenre(req.getGenre());
        classT.setRegion(req.getRegion());
        classT.setType(req.getType());
        classT.setOnly(req.getOnly());
        classT.setInstructor1(instructor1);
        if(instructor2 != null) classT.setInstructor2(instructor2.isPresent() ? instructor2.get() : null);
        classT.setTitle(req.getTitle());
        classT.setStartDate(LocalDate.parse(req.getStartDate()));
        classT.setEndDate(LocalDate.parse(req.getEndDate()));
        classT.setDateSummary(req.getDateSummary());
        classT.setStartTime(req.getStartTime());
        classT.setEndTime(req.getEndTime());
        classT.setLocation(req.getLocation());
        classT.setMalePrice(req.getMalePrice());
        classT.setFemalePrice(req.getFemalePrice());
        classT.setPayment(req.getPayment());
        classT.setClassImage(req.getClassImage());
        classT.setUpdateId("Admin");
        classT.setUpdateDate(LocalDateTime.now());

        // classT.getClassDateOptionTList().clear();
        // for(ClassDateOptionT option : classT.getClassDateOptionTList()) classDateOptionRepository.delete(option);
        classDateOptionRepository.deleteAllByClassNo(req.getClassNo());
        for (String option : req.getDateOptionList())
            classDateOptionRepository.save(new ClassDateOptionT(classT.getClassNo(), option));

        // classT.getClassPriceOptionTList().clear();
        // for(ClassPriceOptionT option : classT.getClassPriceOptionTList()) classPriceOptionRepository.delete(option);
        classPriceOptionRepository.deleteAllByClassNo(req.getClassNo());
        for (String option : req.getPriceOptionList())
            classPriceOptionRepository.save(new ClassPriceOptionT(classT.getClassNo(), option));

        // classT.getClassContactTList().clear();
        // for(ClassContactT contact : classT.getClassContactTList()) classContactRepository.delete(contact);
        classContactRepository.deleteAllByClassNo(req.getClassNo());
        for (ClassContactM contact : req.getClassContactList())
            classContactRepository.save(new ClassContactT(classT.getClassNo(), contact));

        return getClassDetail(classT.getClassNo());
    }
}
