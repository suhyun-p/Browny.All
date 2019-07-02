package Browny.All.Service;

import Browny.All.Entity.*;
import Browny.All.Enum.*;
import Browny.All.Model.ClassM;
import Browny.All.Model.ClassSimpleM;
import Browny.All.Model.EarlybirdM;
import Browny.All.Model.InstructorContactM;
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
    public List<ClassSimpleT> getClassSimpleListByGenre(String genre) {
        List<ClassSimpleT> classSimpleList = new ArrayList<>();
        // List<ClassT> classTList = classRepository.findAllByGenreIsOrderByStartDateDesc(genre);
        List<ClassT> classTList = classRepository.findAllByGenreIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(genre, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleT(classT));

        return classSimpleList;
    }

    @Transactional
    public List<ClassSimpleT> getClassSimpleListByRegion(String region) {
        List<ClassSimpleT> classSimpleList = new ArrayList<>();
        // List<ClassT> classTList = classRepository.findAllByRegionIsOrderByStartDateDesc(region);
        List<ClassT> classTList = classRepository.findAllByRegionIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(region, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleT(classT));

        return classSimpleList;
    }

    @Transactional
    public List<ClassSimpleT> getClassSimpleListByType(String type) {
        List<ClassSimpleT> classSimpleList = new ArrayList<>();
        // List<ClassT> classTList = classRepository.findAllByTypeIsOrderByStartDateDesc(type);
        List<ClassT> classTList = classRepository.findAllByTypeIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(type, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleT(classT));

        return classSimpleList;
    }

    @Transactional
    public List<ClassSimpleT> getClassSimpleListByOnly(String only) {
        List<ClassSimpleT> classSimpleList = new ArrayList<>();
        // List<ClassT> classTList = classRepository.findAllByOnlyIsOrderByStartDateDesc(only);
        List<ClassT> classTList = classRepository.findAllByOnlyIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(only, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleT(classT));

        return classSimpleList;
    }

    @Transactional
    public List<ClassSimpleT> getClassSimpleListByInstructor(Long instructorNo) {
        List<ClassSimpleT> classSimpleList = new ArrayList<>();
        UserT instructor = userRepository.getOne(instructorNo);
        // List<ClassT> classTList = classRepository.findAllByInstructor1OrInstructor2OrderByStartDateDesc(instructor, instructor);
        List<ClassT> classTList = classRepository.findAllByInstructor1AndEndDateIsGreaterThanEqualOrInstructor2AndEndDateIsGreaterThanEqualOrderByStartDateDesc(instructor, LocalDate.now(), instructor, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleT(classT));

        return classSimpleList;
    }

    @Transactional
    public List<ClassSimpleT> getClosedClassSimpleListByInstructor(Long instructorNo) {
        List<ClassSimpleT> classSimpleList = new ArrayList<>();
        UserT instructor = userRepository.getOne(instructorNo);
        // List<ClassT> classTList = classRepository.findAllByInstructor1OrInstructor2OrderByStartDateDesc(instructor, instructor);
        List<ClassT> classTList = classRepository.findAllByInstructor1AndEndDateIsLessThanOrInstructor2AndEndDateIsLessThanOrderByStartDateDesc(instructor, LocalDate.now(), instructor, LocalDate.now());
        for(ClassT classT : classTList)
            classSimpleList.add(new ClassSimpleT(classT));

        return classSimpleList;
    }

    @Transactional
    public ClassDetailT getClassDetail(long classNo) {
        ClassM classDetail = new ClassM();
        ClassT classT = classRepository.findById(classNo).get();

        return new ClassDetailT(classT);
    }

    private ClassM ConvertToClassM(ClassT classT) {
        ClassM class_ = new ClassM();
        class_.setClassNo(classT.getClassNo());
        class_.setGenre(Genre.valueOf(classT.getGenre()));
        class_.setRegion(Region.valueOf(classT.getRegion()));
        class_.setType(ClassType.valueOf(classT.getType()));
        class_.setOnly(classT.getOnly() == null ? null : Only.valueOf(classT.getOnly()));
        class_.setClassImage(String.format("http://localhost:8080/assets/images/%s", classT.getClassImage()));
        class_.setTitle(classT.getTitle());
        class_.setInstructor1(classT.getInstructor1().getNickname());
        class_.setInstructor2(classT.getInstructor2() == null ? null : classT.getInstructor2().getNickname());
        class_.setStartDate(classT.getStartDate().toString());
        class_.setEndDate(classT.getEndDate().toString());
        class_.setStartTime(classT.getStartTime());
        class_.setEndTime(classT.getEndTime());
        class_.setDateSummary(classT.getDateSummary());
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.KOREA);
            long diff = format.parse(classT.getEndTime()).getTime() - format.parse(classT.getStartTime()).getTime();
            long minDiff = diff / (1000 * 60);
            class_.setTimeSummary(String.format("%s분", minDiff));
        }
        catch (ParseException e) {
        }

        class_.setLocation(classT.getLocation());
        class_.setMalePrice(classT.getMalePrice());
        class_.setFemalePrice(classT.getFemalePrice());
        class_.setPayment(classT.getPayment());

        if(classT.getInstructor1() != null && classT.getInstructor1().getInstructorContactTList() != null) {
            // for(InstructorContactT contactT : classT.getInstructor1().getInstructorContactTList())
                // class_.getContactList().add(new InstructorContactM(classT.getInstructor1().getUserNo(), contactT.getType(), contactT.getContact()));
        }

        if(classT.getInstructor2() != null && classT.getInstructor2().getInstructorContactTList() != null) {
            // for(InstructorContactT contactT : classT.getInstructor2().getInstructorContactTList())
                // class_.getContactList().add(new InstructorContactM(classT.getInstructor2().getUserNo(), contactT.getType(), contactT.getContact()));
        }

        if(classT.getClassDateOptionTList() != null) {
            for(ClassDateOptionT dateOption : classT.getClassDateOptionTList()) {
                class_.getDateOptionList().add(dateOption.getOpt());
            }
        }

        if(classT.getClassPriceOptionTList() != null) {
            for(ClassPriceOptionT priceOption : classT.getClassPriceOptionTList()) {
                class_.getPriceOptionList().add(priceOption.getOpt());
            }
        }

        if(classT.getClassEarlybirdTList() != null) {
            for(ClassEarlybirdT earlybird : classT.getClassEarlybirdTList()) {
                if(LocalDate.now().isBefore(earlybird.getDeadline())) {
                    class_.setEarlybird(new EarlybirdM(earlybird.getDeadline(), earlybird.getAmount()));
                    break;
                }
            }
        }

        return class_;
    }

    private String getPriceText(int malePrice, int femalePrice) {
        if(malePrice == 0) return String.format("%s", femalePrice);
        else if (femalePrice == 0) return String.format("%s", malePrice);
        else {
            if(malePrice == femalePrice) return String.format("%s", malePrice);
            else return String.format("%s / %s", malePrice, femalePrice);
        }
    }
}
