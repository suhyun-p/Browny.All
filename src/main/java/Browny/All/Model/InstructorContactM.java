package Browny.All.Model;

import Browny.All.Enum.ContactType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class InstructorContactM {
    private String instructor;
    private ContactType type;
    private String contact;

    public InstructorContactM() {

    }

    public InstructorContactM(String instructor, ContactType type, String contact) {
        this.setInstructor(instructor);
        this.setType(type);
        this.setContact(contact);
    }
}
