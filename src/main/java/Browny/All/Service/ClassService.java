package Browny.All.Service;

import Browny.All.Entity.*;
import Browny.All.Enum.*;
import Browny.All.Model.*;
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
}
