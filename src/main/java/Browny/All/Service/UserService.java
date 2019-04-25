package Browny.All.Service;

import Browny.All.Entity.InstructorCareerT;
import Browny.All.Entity.InstructorContactT;
import Browny.All.Entity.UserT;
import Browny.All.Enum.ContactType;
import Browny.All.Enum.Sex;
import Browny.All.Model.InstructorContactM;
import Browny.All.Model.Request.InstructorContactRequest;
import Browny.All.Model.Request.SignUpRequest;
import Browny.All.Model.UserM;
import Browny.All.Repository.InstructorCareerRepository;
import Browny.All.Repository.InstructorContactRepository;
import Browny.All.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InstructorCareerRepository instructorCareerRepository;

    @Autowired
    private InstructorContactRepository instructorContactRepository;

    @Transactional
    public List<UserM> getUserList() {
        List<UserM> userList = new ArrayList<>();
        List<UserT> userTList = userRepository.findAll();
        for(UserT userT : userTList)
            userList.add(ConvertToUserM(userT));

        return userList;
    }

    @Transactional
    public UserM getUser(long userNo) {
        UserT userT = userRepository.findById(userNo).get();
        return ConvertToUserM(userT);
    }

    @Transactional
    public List<UserM> getInstructorList() {
        List<UserM> instructorList = new ArrayList<>();
        List<UserT> userTList = userRepository.findAllByInstructorIsTrue();
        for(UserT userT : userTList)
            instructorList.add(ConvertToUserM(userT));

        return instructorList;
    }

    @Transactional
    public String SignUp(SignUpRequest req) {
        UserT user = userRepository.save(ConvertToUserT(req));

        // Instructor인 경우에만 Career 및 Contact 정보 저장
        if(req.getInstructor()) {
            if(req.getCareerList() != null) {
                for (String career : req.getCareerList())
                    instructorCareerRepository.save(ConvertToInstructorCareerT(user.getUserNo(), career));
            }
            if(req.getContactList() != null) {
                for (InstructorContactRequest contact : req.getContactList())
                    instructorContactRepository.save(ConvertToInstructorContactT(user.getUserNo(), contact));
            }
        }

        return "OK";
    }

    private UserM ConvertToUserM(UserT userT) {
        UserM user = new UserM(userT.getUserNo(), userT.getNickname(), Sex.valueOf(userT.getSex()), userT.getInstructor());

        // Instructor인 경우에만 Account, Career, Contact 정보 Return
        if(userT.getInstructor()) {
            user.setAccount(userT.getAccount());
            for(InstructorCareerT careerT : userT.getInstructorCareerTList())
                user.getCareerList().add(careerT.getCareer());
            for(InstructorContactT contactT : userT.getInstructorContactTList())
                user.getContactList().add(new InstructorContactM(ContactType.valueOf(contactT.getType()), contactT.getContact()));
        }

        return user;
    }

    private UserT ConvertToUserT(SignUpRequest req) {
        UserT userT = new UserT(req.getNickname(), req.getSex(), req.getInstructor());

        // Instructor인 경우에만 Account 정보 저장
        if(req.getInstructor()) userT.setAccount(req.getAccount());

        return userT;
    }

    private InstructorCareerT ConvertToInstructorCareerT(Long userNo, String career) {
        return new InstructorCareerT(userNo, career);
    }

    private InstructorContactT ConvertToInstructorContactT(Long userNo, InstructorContactRequest contact) {
        return new InstructorContactT(userNo, contact.getType(), contact.getContact());
    }
}
