package Browny.All.Model;

import Browny.All.Entity.ClassContactT;
import Browny.All.Enum.ContactType;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ClassContactM {
    public String instructorPhoneNo1;
    public String instructorKakaoTalk1;
    public String instructorPhoneNo2;
    public String instructorKakaoTalk2;
    public List<String> contactList;

    public ClassContactM() {

    }

    public ClassContactM(Long instructorNo1, Long instructorNo2, List<ClassContactT> contactTList) {
        ClassContactT phoneNo = contactTList.stream().filter(x -> (x.getInstructorNo() == instructorNo1 && x.getType().equals("P"))).findFirst().orElse(null);
        ClassContactT kakaoTalk = contactTList.stream().filter(x -> (x.getInstructorNo() == instructorNo1 && x.getType().equals("K"))).findFirst().orElse(null);
        if(phoneNo != null || kakaoTalk != null){
            if(phoneNo != null) this.setInstructorPhoneNo1(phoneNo.getContact());
            if(kakaoTalk != null) this.setInstructorKakaoTalk1(kakaoTalk.getContact());
        }

        if(instructorNo2 != null) {
            phoneNo = contactTList.stream().filter(x -> (x.getInstructorNo() == instructorNo2 && x.getType().equals("P"))).findFirst().orElse(null);
            kakaoTalk = contactTList.stream().filter(x -> (x.getInstructorNo() == instructorNo2 && x.getType().equals("K"))).findFirst().orElse(null);
            if(phoneNo != null || kakaoTalk != null) {
                if(phoneNo != null) this.setInstructorPhoneNo2(phoneNo.getContact());
                if(kakaoTalk != null) this.setInstructorKakaoTalk2(kakaoTalk.getContact());
            }
        }

        for(ClassContactT classContactT : contactTList.stream().filter(x -> (x.getInstructorNo() == null && x.getType() == null)).collect(Collectors.toList())) {
            this.contactList.add(classContactT.getContact());
        }
    }
}
