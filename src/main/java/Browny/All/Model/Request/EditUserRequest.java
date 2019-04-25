package Browny.All.Model.Request;

import lombok.Data;

import java.util.List;

@Data
public class EditUserRequest {
    private Long userNo;
    private String nickname;
    private String sex;
    private Boolean instructor;
    private String account;
    private List<String> careerList;
    private List<InstructorContactRequest> contactList;
}

/*
{
  "account": "TestBank 000-00-000000 TestUser",
  "careerList": [
    "TestCareer1",
    "TestCareer2"
  ],
  "contactList": [
    {
      "contact": "010-0000-0000",
      "type": "P"
    },
    {
      "contact": "Test KakaoId",
      "type": "K"
    }
  ],
  "instructor": true,
  "nickname": "TestUser",
  "sex": "M",
  "userNo": 4
}
 */