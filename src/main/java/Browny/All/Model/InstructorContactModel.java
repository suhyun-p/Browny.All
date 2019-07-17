package Browny.All.Model;

import lombok.Data;

import java.util.List;

@Data
public class InstructorContactModel {
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

    public InstructorContactModel() {

    }

    public InstructorContactModel(List<InstructorContactM> list) {
        for (InstructorContactM m : list) {
            switch (m.getType()) {
                case "P":
                    this.setPhoneNo(m.getContact());
                    break;
                case "K":
                    this.setKakaoTalk(m.getContact());
                    break;
                case "F":
                    this.setFacebook(m.getContact());
                    break;
                case "I":
                    this.setInstagram(m.getContact());
                    break;
                case "Y":
                    this.setYoutube(m.getName());
                    this.setYoutubeURL(m.getContact());
                    break;
                case "DC":
                    this.setDaumCafe(m.getName());
                    this.setDaumCafeURL(m.getContact());
                    break;
                case "NC":
                    this.setNaverCafe(m.getName());
                    this.setNaverCafeURL(m.getContact());
                    break;
                case "NB":
                    this.setNaverBand(m.getName());
                    this.setNaverBandURL(m.getContact());
                    break;
            }
        }
    }
}
