package Browny.All.Entity;

import Browny.All.Enum.ContactType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class InstructorT {
    private Long userNo;
    private String nickname;
    private String account;
    private String phoneNo;
    private String kakaoTalk;

    public InstructorT() {

    }

    public InstructorT(UserT t) {
        this.setUserNo(t.getUserNo());
        this.setNickname(t.getNickname());
        this.setAccount(t.getAccount());

        for(InstructorContactT c : t.getInstructorContactTList()) {
            if(ContactType.valueOf(c.getType()).equals(ContactType.P)) this.setPhoneNo(c.getContact());
            else if (ContactType.valueOf(c.getType()).equals(ContactType.K)) this.setKakaoTalk(c.getContact());
        }
    }
}
