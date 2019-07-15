package Browny.All.Model;

import Browny.All.Entity.InstructorCareerT;
import Browny.All.Entity.InstructorContactT;
import Browny.All.Entity.UserT;
import Browny.All.Enum.Sex;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class UserM {
    @NonNull private Long userNo;
    @NonNull private String nickname;
    @NonNull private String sex;
    @NonNull private Boolean instructor;
    private String account;
    private List<String> careerList = new ArrayList<>();
    private List<InstructorContactM> contactList = new ArrayList<>();

    public UserM(UserT t) {
        this.setUserNo(t.getUserNo());
        this.setNickname(t.getNickname());
        this.setSex(t.getSex());
        this.setInstructor(t.getInstructor());

        if(t.getInstructor()) {
            this.setAccount(t.getAccount());
            if(t.getInstructorCareerTList() != null) {
                for (InstructorCareerT career : t.getInstructorCareerTList())
                    careerList.add(career.getCareer());
            }
            if(t.getInstructorContactTList() != null) {
                for (InstructorContactT contact : t.getInstructorContactTList())
                    contactList.add(new InstructorContactM(contact.getType(), contact.getName(), contact.getContact()));
            }
        }
    }
}