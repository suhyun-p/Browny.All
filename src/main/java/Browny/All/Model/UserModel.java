package Browny.All.Model;

import Browny.All.Entity.InstructorCareerT;
import Browny.All.Entity.InstructorContactT;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
public class UserModel {
    @NonNull
    private Long userNo;
    @NonNull private String nickname;
    @NonNull private String sex;
    @NonNull private Boolean instructor;
    private String account;
    private List<String> instructorCareer = new ArrayList<>();
    private InstructorContactModel instructorContact;

    public UserModel() {

    }

    public UserModel(UserM m) {
        this.setUserNo(m.getUserNo());
        this.setNickname(m.getNickname());
        this.setSex(m.getSex());
        this.setInstructor(m.getInstructor());

        if(m.getInstructor()) {
            this.setAccount(m.getAccount());
            if(m.getCareerList() != null) {
                for (String career : m.getCareerList())
                    this.getInstructorCareer().add(career);
            }
            if(m.getContactList() != null) {
                this.setInstructorContact(new InstructorContactModel(m.getContactList()));
            }
        }
    }
}
