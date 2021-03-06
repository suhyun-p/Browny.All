package Browny.All.Service;

import Browny.All.Entity.*;
import Browny.All.Model.*;
import Browny.All.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    private ClubRepository clubRepository;

    private String ExposeYn = "Y";

    @Transactional
    public List<ClassSimpleM> getClassSimpleList() {
        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        // List<ClassT> classTList = classRepository.findAllByOrderByStartDateDesc();
        List<ClassT> classTList = classRepository.findAllByExposeYnIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(ExposeYn, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleM(classT));

        return classSimpleList;
    }

    @Transactional
    public List<ClassSimpleM> getClassSimpleListByGenre(String genre) {
        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        // List<ClassT> classTList = classRepository.findAllByGenreIsOrderByStartDateDesc(genre);
        List<ClassT> classTList = classRepository.findAllByExposeYnIsAndGenreIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(ExposeYn, genre, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleM(classT));

        return classSimpleList;
    }

    @Transactional
    public List<ClassSimpleM> getClassSimpleListByRegion(String region) {
        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        // List<ClassT> classTList = classRepository.findAllByRegionIsOrderByStartDateDesc(region);
        List<ClassT> classTList = classRepository.findAllByExposeYnIsAndRegionIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(ExposeYn, region, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleM(classT));

        return classSimpleList;
    }

    @Transactional
    public List<ClassSimpleM> getClassSimpleListByType(String type) {
        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        // List<ClassT> classTList = classRepository.findAllByTypeIsOrderByStartDateDesc(type);
        List<ClassT> classTList = classRepository.findAllByExposeYnIsAndTypeIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(ExposeYn, type, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleM(classT));

        return classSimpleList;
    }

    @Transactional
    public List<ClassSimpleM> getClassSimpleListByOnly(String only) {
        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        // List<ClassT> classTList = classRepository.findAllByOnlyIsOrderByStartDateDesc(only);
        List<ClassT> classTList = classRepository.findAllByExposeYnIsAndOnlyIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(ExposeYn, only, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleM(classT));

        return classSimpleList;
    }

    @Transactional
    public List<ClassSimpleM> getClassSimpleListByInstructor(Long instructorNo) {
        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        UserT instructor = userRepository.getOne(instructorNo);
        // List<ClassT> classTList = classRepository.findAllByInstructor1OrInstructor2OrderByStartDateDesc(instructor, instructor);
        List<ClassT> classTList = classRepository.findAllByExposeYnIsAndInstructor1AndEndDateIsGreaterThanEqualOrExposeYnIsAndInstructor2AndEndDateIsGreaterThanEqualOrderByStartDateDesc(ExposeYn, instructor, LocalDate.now(), ExposeYn, instructor, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleM(classT));

        return classSimpleList;
    }

    @Transactional
    public List<ClassSimpleM> getClosedClassSimpleListByInstructor(Long instructorNo) {
        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        UserT instructor = userRepository.getOne(instructorNo);
        // List<ClassT> classTList = classRepository.findAllByInstructor1OrInstructor2OrderByStartDateDesc(instructor, instructor);
        List<ClassT> classTList = classRepository.findAllByExposeYnIsAndInstructor1AndEndDateIsLessThanOrExposeYnIsAndInstructor2AndEndDateIsLessThanOrderByStartDateDesc(ExposeYn, instructor, LocalDate.now(), ExposeYn, instructor, LocalDate.now());
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
        Optional<ClubT> club = clubRepository.findById(req.getClubNo());
        ClassT classT = classRepository.save(new ClassT(req, instructor1, instructor2.isPresent() ? instructor2.get() : null, club.isPresent() ? club.get() : null));

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
        Optional<ClubT> club = clubRepository.findById(req.getClubNo());

        ClassT classT = classRepository.findById(req.getClassNo()).get();
        classT.setGenre(req.getGenre());
        classT.setRegion(req.getRegion());
        classT.setType(req.getType());
        classT.setOnly(req.getOnly());
        classT.setInstructor1(instructor1);
        if(instructor2 != null) classT.setInstructor2(instructor2.get());
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
        if(club != null) classT.setClub(club.get());
        classT.setExposeYn(req.getExposeYn());
        classT.setUpdateId("Admin");
        classT.setUpdateDate(LocalDateTime.now());

        // classT.getClassDateOptionTList().clear();
        // for(ClassDateOptionT option : classT.getClassDateOptionTList()) classDateOptionRepository.delete(option);
        classDateOptionRepository.deleteAllByClassNo(req.getClassNo());
        // classT.getClassDateOptionTList().removeAll(classT.getClassDateOptionTList());
        for (String option : req.getDateOptionList())
            classDateOptionRepository.save(new ClassDateOptionT(classT.getClassNo(), option));

        // classT.getClassPriceOptionTList().clear();
        // for(ClassPriceOptionT option : classT.getClassPriceOptionTList()) classPriceOptionRepository.delete(option);
        classPriceOptionRepository.deleteAllByClassNo(req.getClassNo());
        // classT.getClassPriceOptionTList().removeAll(classT.getClassPriceOptionTList());
        for (String option : req.getPriceOptionList())
            classPriceOptionRepository.save(new ClassPriceOptionT(classT.getClassNo(), option));

        // classT.getClassContactTList().clear();
        // for(ClassContactT contact : classT.getClassContactTList()) classContactRepository.delete(contact);
        classContactRepository.deleteAllByClassNo(req.getClassNo());
        // classT.getClassContactTList().removeAll(classT.getClassContactTList());
        for (ClassContactM contact : req.getClassContactList())
            classContactRepository.save(new ClassContactT(classT.getClassNo(), contact));

        return getClassDetail(classT.getClassNo());
    }

    @Transactional
    public List<ClassSimpleM> getClassSimpleListByClub(Long clubNo) {
        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        Optional<ClubT> club = clubRepository.findById(clubNo);

        if(club.isPresent()) {
            // List<ClassT> classTList = classRepository.findAllByClubOrderByStartDateDesc(instructor, instructor);
            List<ClassT> classTList = classRepository.findAllByExposeYnIsAndClubAndEndDateIsGreaterThanEqualOrderByStartDateDesc(ExposeYn, club.get(), LocalDate.now());
            for(ClassT classT : classTList)
                classSimpleList.add(new ClassSimpleM(classT));
        }

        return classSimpleList;
    }
}
