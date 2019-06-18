package Browny.All.Model;

import Browny.All.Entity.*;
import Browny.All.Enum.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
    private boolean dateSummaryExpose;
    private String time;
    private String location;
    private String price;
    private EarlybirdM earlybird;
    private String payment;
    private List<String> contactList = new ArrayList<>();
    private String contact;
    private boolean contactExpose;
    private List<String> dateOptionList = new ArrayList<>();
    private List<String> priceOptionList = new ArrayList<>();

    public ClassDetailM(ClassDetailT t) {
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

        this.setInstructorNo1(t.getInstructorNo1());
        this.setInstructorNickname1(String.format("#%s", t.getInstructorNickname1()));

        if(t.getInstructorNo2() != null) {
            this.setInstructorNo2(t.getInstructorNo2());
            this.setInstructorNickname2(String.format("#%s", t.getInstructorNickname1()));
        }

        this.setTitle(t.getTitle());
        this.setClassImage(String.format("http://localhost:8080/assets/images/%s", t.getClassImage()));

        if(t.getInstructorNo2() != null) this.setInstructor(String.format("%s, %s", t.getInstructorNickname1(), t.getInstructorNickname2()));
        else this.setInstructor(String.format("%s", t.getInstructorNickname1()));

        if(t.getStartDate().equals(t.getEndDate())) this.setDate(String.format("%s", t.getStartDate()));
        else this.setDate(String.format("%s ~ %s", t.getStartDate(), t.getEndDate()));

        if(t.getDateSummary() != null) {
            this.setDateSummary(String.format("(%s)", t.getDateSummary()));
            this.setDateSummaryExpose(true);
        }
        else this.setDateSummaryExpose(false);

        this.setDateOptionList(t.getDateOptionList());

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
                this.setPrice(String.format("%s",Integer.toString(t.getMalePrice())));
            }
            else {
                this.setPrice(String.format("남자 %s / 여자 %s",Integer.toString(t.getMalePrice()), Integer.toString(t.getFemalePrice())));
            }
        }
        else {
            if(Only.valueOf(t.getOnly()).equals(Only.F))
                this.setPrice(Integer.toString(t.getFemalePrice()));
            else if(Only.valueOf(t.getOnly()).equals(Only.M))
                this.setPrice(Integer.toString(t.getMalePrice()));
        }

        this.setPriceOptionList(t.getPriceOptionList());
        this.setPayment(t.getPayment());

        /*if(t.getInstructor1() != null) {
            if(t.getInstructor1().getPhoneNo() != null || t.getInstructor1().getKakaoTalk() != null) {
                if(t.getInstructor1().getPhoneNo() != null && t.getInstructor1().getKakaoTalk() != null)
                    this.contactList.add(String.format("%s %s (카톡 %s)", t.getInstructor1().getNickname(), t.getInstructor1().getPhoneNo(), t.getInstructor1().getKakaoTalk()));
                else if(t.getInstructor1().getPhoneNo() != null)
                    this.contactList.add(String.format("%s %s", t.getInstructor1().getNickname(), t.getInstructor1().getPhoneNo()));
            }
        }

        if(t.getInstructor2() != null) {
            if(t.getInstructor2().getPhoneNo() != null || t.getInstructor2().getKakaoTalk() != null) {
                if(t.getInstructor2().getPhoneNo() != null && t.getInstructor2().getKakaoTalk() != null)
                    this.contactList.add(String.format("%s %s (카톡 %s)", t.getInstructor2().getNickname(), t.getInstructor2().getPhoneNo(), t.getInstructor2().getKakaoTalk()));
                else if(t.getInstructor2().getPhoneNo() != null)
                    this.contactList.add(String.format("%s %s", t.getInstructor2().getNickname(), t.getInstructor2().getPhoneNo()));
            }
        }

        this.setContact(t.getContact());*/

        if(this.getContactList().size() > 0 || this.getContact() != null) {
            this.setContactExpose(true);
        }
        else {
            this.setContactExpose(false);
        }
    }
}
