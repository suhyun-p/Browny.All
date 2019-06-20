package Browny.All.Model;

import lombok.Data;

import java.util.List;

@Data
public class ClassContactM {
    public String instructorPhoneNo1;
    public String instructorKakaoTalk1;
    public String instructorPhoneNo2;
    public String instructorKakaoTalk2;
    public List<String> contactList;

    public ClassContactM() {

    }
}
