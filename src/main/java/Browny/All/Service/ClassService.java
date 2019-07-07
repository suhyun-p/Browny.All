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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
    public ClassDetailM regClass(RegClassRequest req) {
        UserT instructor1= userRepository.getOne(req.getInstructorNo1());
        UserT instructor2 = userRepository.findById(req.getInstructorNo2()).get();
        ClassT classT = classRepository.save(new ClassT(req, instructor1, instructor2));

        for (String option : req.getDateOptionList())
            classDateOptionRepository.save(new ClassDateOptionT(classT.getClassNo(), option));

        for (String option : req.getPriceOptionList())
            classPriceOptionRepository.save(new ClassPriceOptionT(classT.getClassNo(), option));

        for (ClassContactRequest contact : req.getContactList())
            classContactRepository.save(new ClassContactT(classT.getClassNo(), contact));

        return getClassDetail(classT.getClassNo());
    }

    @Transactional
    public ClassDetailM editClass(EditClassRequest req) {
        ClassT classT = classRepository.findById(req.getClassNo()).get();
        UserT instructor1= userRepository.getOne(req.getInstructorNo1());
        UserT instructor2 = userRepository.findById(req.getInstructorNo2()).get();
        classT.set(req, instructor1, instructor2 == null ? null : instructor2);

        for (String option : req.getDateOptionList())
            classDateOptionRepository.save(new ClassDateOptionT(classT.getClassNo(), option));

        for (String option : req.getPriceOptionList())
            classPriceOptionRepository.save(new ClassPriceOptionT(classT.getClassNo(), option));

        for (ClassContactRequest contact : req.getContactList())
            classContactRepository.save(new ClassContactT(classT.getClassNo(), contact));

        return getClassDetail(classT.getClassNo());
    }
}
