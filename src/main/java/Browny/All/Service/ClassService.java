package Browny.All.Service;

import Browny.All.Entity.ClassT;
import Browny.All.Entity.InstructorContactT;
import Browny.All.Enum.*;
import Browny.All.Model.ClassM;
import Browny.All.Model.InstructorContactM;
import Browny.All.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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

        if (classT.getPaymentType() == 1 && classT.getInstructor1() != null)
            class_.setPayment(classT.getInstructor1().getAccount());
        else if (classT.getPaymentType() == 2 && classT.getInstructor2() != null)
            class_.setPayment(classT.getInstructor2().getAccount());
        else if (classT.getPaymentType() == 3)
            class_.setPayment(classT.getPayment());

        if(classT.getInstructor1() != null && classT.getInstructor1().getInstructorContactTList() != null) {
            for(InstructorContactT contactT : classT.getInstructor1().getInstructorContactTList())
                class_.getContactList().add(new InstructorContactM(classT.getInstructor1().getNickname(), ContactType.valueOf(contactT.getType()), contactT.getContact()));
        }

        if(classT.getInstructor2() != null && classT.getInstructor2().getInstructorContactTList() != null) {
            for(InstructorContactT contactT : classT.getInstructor2().getInstructorContactTList())
                class_.getContactList().add(new InstructorContactM(classT.getInstructor2().getNickname(), ContactType.valueOf(contactT.getType()), contactT.getContact()));
        }

        return class_;
    }
}
