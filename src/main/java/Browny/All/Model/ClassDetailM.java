package Browny.All.Model;

import Browny.All.Entity.*;
import Browny.All.Enum.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Getter
@Setter
@Data
public class ClassDetailM {
    private Long classNo;
    private String genreText;
    private String genreCode;
    private String regionText;
    private String regionCode;
    private String typeText;
    private String typeCode;
    private String onlyText;
    private String onlyCode;
    private String title;
    private String classImage;
    private String instructor;
    private Long instructorNo1;
    private String instructorNickname1;
    private Long instructorNo2;
    private String instructorNickname2;
    private String date;
    private String dateSummary;
    private String time;
    private String location;
    private String price;
    private String payment;
    private ClassContactM classContact;
    private List<String> dateOptionList = new ArrayList<>();
    private List<String> priceOptionList = new ArrayList<>();

    public ClassDetailM(){

    }

    public ClassDetailM(ClassT t) {
        this.setClassNo(t.getClassNo());
        this.setGenreText(String.format("#%s", Genre.valueOf(t.getGenre()).getValue()));
        this.setGenreCode(t.getGenre());
        this.setRegionText(String.format("#%s", Region.valueOf(t.getRegion()).getValue()));
        this.setRegionCode(t.getRegion());

        if(!ClassType.valueOf(t.getType()).equals(ClassType.N)) {
            this.setTypeText(String.format("#%s", ClassType.valueOf(t.getType()).getValue()));
            this.setTypeCode(t.getType());
        }

        if(t.getOnly() != null) {
            this.setOnlyText(String.format("#%s", Only.valueOf(t.getOnly()).getValue()));
            this.setOnlyCode(t.getOnly());
        }

        this.setInstructorNo1(t.getInstructor1().getUserNo());
        this.setInstructorNickname1(String.format("#%s", t.getInstructor1().getNickname()));

        if(t.getInstructor2() != null) {
            this.setInstructorNo2(t.getInstructor2().getUserNo());
            this.setInstructorNickname2(String.format("#%s", t.getInstructor2().getNickname()));
        }

        this.setTitle(t.getTitle());
        this.setClassImage(String.format("http://localhost:8080/assets/images/%s", t.getClassImage()));

        if(t.getInstructor2() != null) this.setInstructor(String.format("%s, %s", t.getInstructor1().getNickname(), t.getInstructor2().getNickname()));
        else this.setInstructor(String.format("%s", t.getInstructor1().getNickname()));

        if(t.getStartDate().equals(t.getEndDate())) this.setDate(String.format("%s", t.getStartDate()));
        else this.setDate(String.format("%s ~ %s", t.getStartDate(), t.getEndDate()));

        this.setDateSummary(t.getDateSummary());

        if(t.getClassDateOptionTList() != null) {
            for(ClassDateOptionT dateOption : t.getClassDateOptionTList()) {
                this.getDateOptionList().add(dateOption.getOpt());
            }
        }

        long minDiff = 0;
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.KOREA);
            long diff = format.parse(t.getEndTime()).getTime() - format.parse(t.getStartTime()).getTime();
            minDiff = diff / (1000 * 60);
        }
        catch (Exception e) {
        }

        if(minDiff == 0) this.setTime(String.format("%s ~ %s", t.getStartTime(), t.getEndTime()));
        else this.setTime(String.format("%s ~ %s (%s분)", t.getStartTime(), t.getEndTime(), minDiff));

        this.setLocation(t.getLocation());

        if(t.getOnly()== null) {
            if(t.getMalePrice() == t.getFemalePrice()) {
                this.setPrice(String.format("%s",Integer.toString(t.getMalePrice()).replaceAll("0000$", "만원")));
            }
            else {
                this.setPrice(String.format("남자 %s / 여자 %s",Integer.toString(t.getMalePrice()).replaceAll("0000$", "만원"), Integer.toString(t.getFemalePrice()).replaceAll("0000$", "만원")));
            }
        }
        else {
            if(Only.valueOf(t.getOnly()).equals(Only.F))
                this.setPrice(Integer.toString(t.getFemalePrice()).replaceAll("0000$", "만원"));
            else if(Only.valueOf(t.getOnly()).equals(Only.M))
                this.setPrice(Integer.toString(t.getMalePrice()).replaceAll("0000$", "만원"));
        }

        if(t.getClassPriceOptionTList() != null) {
            for(ClassPriceOptionT priceOption : t.getClassPriceOptionTList()) {
                this.getPriceOptionList().add(priceOption.getOpt());
            }
        }

        this.setPayment(t.getPayment());

        if(t.getClassContactTList() != null) {
            this.setClassContact(new ClassContactM(t.getInstructor1().getUserNo(), t.getInstructor2() == null ? null : t.getInstructor2().getUserNo(), t.getClassContactTList()));
        }


        /*
        if(t.getClassContact().getInstructorPhoneNo1() != null || t.getClassContact().getInstructorKakaoTalk1() != null){
            if(t.getClassContact().getInstructorPhoneNo1() != null && t.getClassContact().getInstructorKakaoTalk1() != null)
                this.contactList.add(String.format("%s %s (카톡 %s)", t.getInstructorNickname1(), t.getClassContact().getInstructorPhoneNo1(), t.getClassContact().getInstructorKakaoTalk1()));
            else if(t.getClassContact().getInstructorPhoneNo1() != null)
                this.contactList.add(String.format("%s %s", t.getInstructorNickname1(), t.getClassContact().getInstructorPhoneNo1()));
            else if(t.getClassContact().getInstructorKakaoTalk1() != null)
                this.contactList.add(String.format("%s (카톡 %s)", t.getInstructorNickname1(), t.getClassContact().getInstructorKakaoTalk1()));
        }

        if(t.getClassContact().getInstructorPhoneNo2() != null || t.getClassContact().getInstructorKakaoTalk2() != null){
            if(t.getClassContact().getInstructorPhoneNo2() != null && t.getClassContact().getInstructorKakaoTalk2() != null)
                this.contactList.add(String.format("%s %s (카톡 %s)", t.getInstructorNickname2(), t.getClassContact().getInstructorPhoneNo2(), t.getClassContact().getInstructorKakaoTalk2()));
            else if(t.getClassContact().getInstructorPhoneNo2() != null)
                this.contactList.add(String.format("%s %s", t.getInstructorNickname2(), t.getClassContact().getInstructorPhoneNo2()));
            else if(t.getClassContact().getInstructorKakaoTalk2() != null)
                this.contactList.add(String.format("%s (카톡 %s)", t.getInstructorNickname2(), t.getClassContact().getInstructorKakaoTalk2()));
        }

        if(t.getClassContact().getContactList() != null) {
            for(String contact : t.getClassContact().getContactList()) {
                this.contactList.add(contact);
            }
        }
        */
    }
}
