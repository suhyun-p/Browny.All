package Browny.All.Model;

import Browny.All.Entity.ClassContactT;
import Browny.All.Entity.InstructorContactT;
import Browny.All.Enum.ContactType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class InstructorContactM {
    private String phoneNo;
    private String kakaoTalk;
    private String facebook;
    private String instagram;
    private String youtube;
    private String youtubeURL;
    private String daumCafe;
    private String daumCafeURL;
    private String naverCafe;
    private String naverCafeURL;
    private String naverBand;
    private String naverBandURL;

    public InstructorContactM() {

    }

    public InstructorContactM(List<InstructorContactT> list) {
        for(InstructorContactT t : list){
            switch (t.getType()) {
                case "P":
                    this.setPhoneNo(t.getContact());
                    break;
                case "K":
                    this.setKakaoTalk(t.getContact());
                    break;
                case "F":
                    this.setFacebook(t.getContact());
                    break;
                case "I":
                    this.setInstagram(t.getContact());
                    break;
                case "Y":
                    this.setYoutube(t.getName());
                    this.setYoutubeURL(t.getContact());
                    break;
                case "DC":
                    this.setDaumCafe(t.getName());
                    this.setDaumCafeURL(t.getContact());
                    break;
                case "NC":
                    this.setNaverCafe(t.getName());
                    this.setNaverCafeURL(t.getContact());
                    break;
                case "NB":
                    this.setNaverBand(t.getName());
                    this.setNaverBandURL(t.getContact());
                    break;
            }
        }
    }
}
