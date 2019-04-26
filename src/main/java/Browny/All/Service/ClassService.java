package Browny.All.Service;

import Browny.All.Entity.ClassT;
import Browny.All.Enum.ClassType;
import Browny.All.Enum.Genre;
import Browny.All.Enum.Only;
import Browny.All.Enum.Region;
import Browny.All.Model.ClassM;
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

        return class_;
    }
}
