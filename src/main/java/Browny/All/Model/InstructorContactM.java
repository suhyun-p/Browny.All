package Browny.All.Model;

import Browny.All.Entity.ClassContactT;
import Browny.All.Entity.InstructorContactT;
import Browny.All.Enum.ContactType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class InstructorContactM {
    private String type;
    private String name;
    private String contact;

    public InstructorContactM(String type, String name, String contact) {
        this.setType(type);
        this.setName(name);
        this.setContact(contact);
    }
}
