package Browny.All.Service;

import Browny.All.Entity.InstructorCareerT;
import Browny.All.Entity.InstructorContactT;
import Browny.All.Entity.UserT;
import Browny.All.Enum.ContactType;
import Browny.All.Enum.Sex;
import Browny.All.Model.InstructorContactM;
import Browny.All.Model.UserM;
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

    private UserM ConvertToUserM(UserT userT) {
        UserM user = new UserM(userT.getUserNo(), userT.getNickname(), Sex.valueOf(userT.getSex()), userT.getInstructor());
        if(userT.getInstructor()) {
            user.setAccount(userT.getAccount());
            for(InstructorCareerT careerT : userT.getInstructorCareerTList())
                user.getCareerList().add(careerT.getCareer());
            for(InstructorContactT contactT : userT.getInstructorContactTList())
                user.getContactList().add(new InstructorContactM(ContactType.valueOf(contactT.getType()), contactT.getContact()));
        }

        return user;
    }

}
