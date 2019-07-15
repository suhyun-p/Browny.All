package Browny.All.Service;

import Browny.All.Entity.InstructorCareerT;
import Browny.All.Entity.InstructorContactT;
import Browny.All.Entity.UserT;
import Browny.All.Model.InstructorContactM;
import Browny.All.Model.UserM;
import Browny.All.Repository.InstructorCareerRepository;
import Browny.All.Repository.InstructorContactRepository;
import Browny.All.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
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
    public List<UserM> GetUserList() {
        List<UserM> userList = new ArrayList<>();
        List<UserT> userTList = userRepository.findAll();
        for(UserT userT : userTList)
            userList.add(new UserM(userT));

        return userList;
    }

    @Transactional
    public UserM GetUser(long userNo) {
        UserT userT = userRepository.findById(userNo).get();
        return new UserM(userT);
    }

    @Transactional
    public List<UserM> GetInstructorList() {
        List<UserM> instructorList = new ArrayList<>();
        List<UserT> userTList = userRepository.findAllByInstructorIsTrue();
        for(UserT userT : userTList)
            instructorList.add(new UserM(userT));

        return instructorList;
    }

    @Transactional
    public UserM SignUp(UserM req) {
        UserT user = userRepository.save(new UserT(req));

        // Instructor인 경우에만 Career 및 Contact 정보 저장
        if(req.getInstructor()) {
            if(req.getCareerList() != null && !req.getCareerList().isEmpty()) {
                for (String career : req.getCareerList())
                    instructorCareerRepository.save(new InstructorCareerT(user.getUserNo(), career));
            }
            if(req.getContactList() != null && !req.getContactList().isEmpty()) {
                for (InstructorContactM contact : req.getContactList())
                    instructorContactRepository.save(new InstructorContactT(user.getUserNo(), contact));
            }
        }

        return GetUser(user.getUserNo());
    }

    @Transactional
    public UserM EditUser(UserM req) {
        UserT user = userRepository.findById(req.getUserNo()).get();
        user.setNickname(req.getNickname());
        user.setSex(req.getSex());
        user.setInstructor(req.getInstructor());
        user.setAccount(req.getInstructor() ? req.getAccount() : null);
        user.setUpdateDate(LocalDateTime.now());
        user.setUpdateId("Admin");
        userRepository.save(user);

        if(req.getInstructor()) {
            instructorCareerRepository.deleteAllByInstructorNo(req.getUserNo());
            if(req.getCareerList() != null) {
                for (String career : req.getCareerList())
                    instructorCareerRepository.save(new InstructorCareerT(user.getUserNo(), career));
            }

            instructorContactRepository.deleteAllByInstructorNo(req.getUserNo());
            if(req.getContactList() != null) {
                for (InstructorContactM contact : req.getContactList())
                    instructorContactRepository.save(new InstructorContactT(user.getUserNo(), contact));
            }
        }

        return GetUser(user.getUserNo());
    }
}
