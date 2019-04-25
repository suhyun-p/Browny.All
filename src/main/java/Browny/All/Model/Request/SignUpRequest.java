package Browny.All.Model.Request;

import lombok.Data;

import java.util.List;

@Data
public class SignUpRequest {
    private String nickname;
    private String sex;
    private Boolean instructor;
    private String account;
    private List<String> careerList;
    private List<InstructorContactRequest> contactList;
}
