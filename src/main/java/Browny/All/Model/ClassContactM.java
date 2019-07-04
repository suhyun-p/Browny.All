package Browny.All.Model;

import Browny.All.Entity.ClassContactT;
import Browny.All.Enum.ContactType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ClassContactM {
    public InstructorContactM instructorContact1 = new InstructorContactM();
    public InstructorContactM instructorContact2 = new InstructorContactM();
    public List<String> contactList = new ArrayList<>();

    public ClassContactM() {

    }

    public ClassContactM(Long instructorNo1, Long instructorNo2, List<ClassContactT> contactTList) {
        for(ClassContactT contact : contactTList.stream().filter(x -> x.getInstructorNo() == instructorNo1).collect(Collectors.toList())) {
            if(contact.getType().equals(ContactType.P.getKey())) instructorContact1.setPhoneNo(contact.getContact());
            else if(contact.getType().equals(ContactType.K.getKey())) instructorContact1.setKakaoTalk(contact.getContact());
        }

        if(instructorNo2 != null) {
            for(ClassContactT contact : contactTList.stream().filter(x -> x.getInstructorNo() == instructorNo2).collect(Collectors.toList())) {
                if(contact.getType().equals(ContactType.P.getKey())) instructorContact2.setPhoneNo(contact.getContact());
                else if(contact.getType().equals(ContactType.K.getKey())) instructorContact2.setKakaoTalk(contact.getContact());
            }
        }

        for(ClassContactT classContactT : contactTList.stream().filter(x -> (x.getInstructorNo() == null && x.getType() == null)).collect(Collectors.toList())) {
            this.getContactList().add(classContactT.getContact());
        }
    }
}
