package Browny.All.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.Optional;

@Data
@NoArgsConstructor
public class ClassContactM {
    @Nullable private Long instructorNo;
    @Nullable private String type;
    private String contact;

    public ClassContactM(Long instructorNo, String type, String contact) {
        this.setInstructorNo(instructorNo);
        this.setType(type);
        this.setContact(contact);
    }
}
