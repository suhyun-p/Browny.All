package Browny.All.Service;

import Browny.All.Entity.UserT;
import Browny.All.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<UserT> getUserTList() {
        List<UserT> userTList = userRepository.findAll();
        return userTList;
    }
}
