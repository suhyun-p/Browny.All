package Browny.All.Model;

import Browny.All.Enum.ContactType;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InstructorContactM {
    private ContactType type;
    private String contact;
}
