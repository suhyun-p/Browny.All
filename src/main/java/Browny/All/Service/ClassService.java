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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public List<ClassT> getClassTList() {
        List<ClassT> classTList = classRepository.findAll();

        return classTList;
    }

    @Transactional
    public List<ClassM> getClassList() {
        List<ClassM> classList = new ArrayList<>();
        List<ClassT> classTList = classRepository.findAll();
        for(ClassT classT : classTList)
            classList.add(ConvertToClassM(classT));

        return classList;
    }

    @Transactional
    public List<ClassSimpleM> getClassSimpleList() {
        List<ClassSimpleM> classSimpleList = new ArrayList<>();
        List<ClassT> classTList = classRepository.findAll();
        for(ClassT classT : classTList)
            classSimpleList.add(ConvertToClassSimpleM(classT));

        return classSimpleList;
    }

    private ClassM ConvertToClassM(ClassT classT) {
        ClassM class_ = new ClassM();
        class_.setClassNo(classT.getClassNo());
        class_.setGenre(Genre.valueOf(classT.getGenre()));
        class_.setRegion(Region.valueOf(classT.getRegion()));
        class_.setType(ClassType.valueOf(classT.getType()));
        class_.setOnly(Only.valueOf(classT.getOnly()));
        class_.setTitle(classT.getTitle());
        class_.setInstructor1(classT.getInstructor1().getNickname());
        class_.setInstructor2(classT.getInstructor2() == null ? null : classT.getInstructor2().getNickname());
        class_.setStartDate(classT.getStartDate().toString());
        class_.setEndDate(classT.getEndDate().toString());
        class_.setStartTime(classT.getStartTime());
        class_.setEndTime(classT.getEndTime());
        class_.setLocation(classT.getLocation());
        class_.setMalePrice(classT.getMalePrice());
        class_.setFemalePrice(classT.getFemalePrice());

        if (classT.getPaymentType() == "1" && classT.getInstructor1() != null)
            class_.setPayment(classT.getInstructor1().getAccount());
        else if (classT.getPaymentType() == "2" && classT.getInstructor2() != null)
            class_.setPayment(classT.getInstructor2().getAccount());
        else if (classT.getPaymentType() == "3")
            class_.setPayment(classT.getPayment());

        if(classT.getInstructor1() != null && classT.getInstructor1().getInstructorContactTList() != null) {
            for(InstructorContactT contactT : classT.getInstructor1().getInstructorContactTList())
                class_.getContactList().add(new InstructorContactM(classT.getInstructor1().getNickname(), ContactType.valueOf(contactT.getType()), contactT.getContact()));
        }

        if(classT.getInstructor2() != null && classT.getInstructor2().getInstructorContactTList() != null) {
            for(InstructorContactT contactT : classT.getInstructor2().getInstructorContactTList())
                class_.getContactList().add(new InstructorContactM(classT.getInstructor2().getNickname(), ContactType.valueOf(contactT.getType()), contactT.getContact()));
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

    private ClassSimpleM ConvertToClassSimpleM(ClassT classT) {
        ClassSimpleM classSimpleM = new ClassSimpleM();
        classSimpleM.setClassNo(classT.getClassNo());
        classSimpleM.setGenre(Genre.valueOf(classT.getGenre()).getValue());
        classSimpleM.setRegion(Region.valueOf(classT.getRegion()).getValue());
        classSimpleM.setType(ClassType.valueOf(classT.getType()).getValue());
        classSimpleM.setOnly(classT.getOnly() == null ? null : Only.valueOf(classT.getOnly()).getValue());
        classSimpleM.setTitle(classT.getTitle());
        classSimpleM.setInstructorNo1(classT.getInstructor1().getUserNo());
        classSimpleM.setInstructorNick1(classT.getInstructor1().getNickname());
        classSimpleM.setInstructorNo2(classT.getInstructor2() == null ? null : classT.getInstructor2().getUserNo());
        classSimpleM.setInstructorNick2(classT.getInstructor2() == null ? "" : classT.getInstructor2().getNickname());
        classSimpleM.setDate(String.format("%s ~ %s", classT.getStartDate(), classT.getEndDate()));
        classSimpleM.setTime(String.format("%s ~ %s", classT.getStartTime(), classT.getEndTime()));
        classSimpleM.setPrice(getPriceText(classT.getMalePrice(), classT.getFemalePrice()));
        classSimpleM.setClassImage(String.format("http://localhost:8080/assets/images/%s", classT.getClassImage()));

        return classSimpleM;
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
