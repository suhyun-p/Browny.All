package Browny.All.Model;

import Browny.All.Enum.ContactType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class InstructorContactM {
    private Long instructorNo;
    private ContactType type;
    private String contact;

    public InstructorContactM() {

    }

    public InstructorContactM(Long instructorNo, ContactType type, String contact) {
        this.setInstructorNo(instructorNo);
        this.setType(type);
        this.setContact(contact);
    }
}
