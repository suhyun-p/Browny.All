package Browny.All.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ClassContactM {
    private Long instructorNo;
    private String type;
    private String contact;

    public ClassContactM(long instructorNo, String type, String contact) {
        this.setInstructorNo(instructorNo);
        this.setType(type);
        this.setContact(contact);
    }
}
