package Browny.All.Model;

import Browny.All.Entity.ClassContactT;
import Browny.All.Enum.*;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Data
public class ClassDetailModel {
    private Long classNo;
    private String genreCode;
    private String genreText;
    private String regionCode;
    private String regionText;
    private String typeCode;
    private String typeText;
    private String onlyCode;
    private String onlyText;
    private String title;
    private String classImage;
    private Long instructorNo1;
    private String instructorNickname1;
    private Long instructorNo2;
    private String instructorNickname2;
    private String instructor;
    private String date;
    private String dateSummary;
    private List<String> dateOptionList = new ArrayList<>();
    private String time;
    private String location;
    private String price;
    private List<String> priceOptionList = new ArrayList<>();
    private String payment;
    private List<String> classContactList = new ArrayList<>();

    public ClassDetailModel(ClassDetailM m) {
        this.setClassNo(m.getClassNo());

        this.setGenreCode(m.getGenre());
        this.setGenreText(Genre.valueOf(m.getGenre()).getValue());
        this.setRegionCode(m.getRegion());
        this.setRegionText(Region.valueOf(m.getRegion()).getValue());
        if(m.getType() != null && m.getType().equals("N")) {
            this.setTypeCode(m.getType());
            this.setTypeText(ClassType.valueOf(m.getType()).getValue());
        }
        if(m.getOnly() != null) {
            this.setOnlyCode(m.getOnly());
            this.setOnlyText(Only.valueOf(m.getOnly()).getValue());
        }

        this.setTitle(m.getTitle());
        this.setClassImage(String.format("http://localhost:8080/assets/images/%s", m.getClassImage()));

        this.setInstructorNo1(m.getInstructorNo1());
        this.setInstructorNickname1(m.getInstructorNickname1());
        if(m.getInstructorNo2() != null) {
            this.setInstructorNo2(m.getInstructorNo2());
            this.setInstructorNickname2(m.getInstructorNickname2());
        }

        if(m.getInstructorNo2() != null) this.setInstructor(String.format("%s, %s", m.getInstructorNickname1(), m.getInstructorNickname2()));
        else this.setInstructor(String.format("%s", m.getInstructorNickname1()));

        if(m.getStartDate().equals(m.getEndDate())) this.setDate(String.format("%s", m.getStartDate()));
        else this.setDate(String.format("%s ~ %s", m.getStartDate(), m.getEndDate()));

        this.setDateSummary(m.getDateSummary());

        if(m.getDateOptionList() != null && !m.getDateOptionList().isEmpty()) {
            for(String option : m.getDateOptionList()) {
                this.getDateOptionList().add(option);
            }
        }

        long minDiff = 0;
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.KOREA);
            long diff = format.parse(m.getEndTime()).getTime() - format.parse(m.getStartTime()).getTime();
            minDiff = diff / (1000 * 60);

            if(minDiff == 0) this.setTime(String.format("%s ~ %s", m.getStartTime(), m.getEndTime()));
            else this.setTime(String.format("%s ~ %s (%s분)", m.getStartTime(), m.getEndTime(), minDiff));
        }
        catch (Exception e) {
        }

        this.setLocation(m.getLocation());

        if(m.getOnly() == null) {
            if(m.getMalePrice() == m.getFemalePrice()) {
                this.setPrice(String.format("%s",Integer.toString(m.getMalePrice()).replaceAll("0000$", "만원")));
            }
            else {
                this.setPrice(String.format("남자 %s / 여자 %s",Integer.toString(m.getMalePrice()).replaceAll("0000$", "만원"), Integer.toString(m.getFemalePrice()).replaceAll("0000$", "만원")));
            }
        }
        else {
            if(Only.valueOf(m.getOnly()).equals(Only.F))
                this.setPrice(Integer.toString(m.getFemalePrice()).replaceAll("0000$", "만원"));
            else if(Only.valueOf(m.getOnly()).equals(Only.M))
                this.setPrice(Integer.toString(m.getMalePrice()).replaceAll("0000$", "만원"));
        }

        if(m.getPriceOptionList() != null && !m.getPriceOptionList().isEmpty()) {
            for(String option : m.getPriceOptionList()) {
                this.getPriceOptionList().add(option);
            }
        }

        this.setPayment(m.getPayment());

        if(m.getClassContactList() != null && !m.getClassContactList().isEmpty()) {
            String phoneNo = new String();
            String kakaoTalk = new String();
            for(ClassContactM contact : m.getClassContactList().stream().filter(x -> x.getInstructorNo() == instructorNo1).collect(Collectors.toList())) {
                if(contact.getType().equals(ContactType.P.getKey())) phoneNo = contact.getContact();
                else if(contact.getType().equals(ContactType.K.getKey())) kakaoTalk = contact.getContact();
            }

            if(!phoneNo.isEmpty() || !kakaoTalk.isEmpty()) {
                if(!phoneNo.isEmpty() && !kakaoTalk.isEmpty()) this.getClassContactList().add(String.format("%s %s (카톡) %s", m.getInstructorNickname1(), phoneNo, kakaoTalk));
                else if(!phoneNo.isEmpty()) this.getClassContactList().add(String.format("%s %s", m.getInstructorNickname1(), phoneNo));
                else if(!kakaoTalk.isEmpty()) this.getClassContactList().add(String.format("%s (카톡) %s", m.getInstructorNickname1(), kakaoTalk));
            }

            phoneNo = "";
            kakaoTalk = "";
            if(instructorNo2 != null) {
                for(ClassContactM contact : m.getClassContactList().stream().filter(x -> x.getInstructorNo() == instructorNo2).collect(Collectors.toList())) {
                    if(contact.getType().equals(ContactType.P.getKey())) phoneNo = contact.getContact();
                    else if(contact.getType().equals(ContactType.K.getKey())) kakaoTalk = contact.getContact();
                }
            }

            if(!phoneNo.isEmpty() || !kakaoTalk.isEmpty()) {
                if(!phoneNo.isEmpty() && !kakaoTalk.isEmpty()) this.getClassContactList().add(String.format("%s %s (카톡) %s", m.getInstructorNickname2(), phoneNo, kakaoTalk));
                else if(!phoneNo.isEmpty()) this.getClassContactList().add(String.format("%s %s", m.getInstructorNickname2(), phoneNo));
                else if(!kakaoTalk.isEmpty()) this.getClassContactList().add(String.format("%s (카톡) %s", m.getInstructorNickname2(), kakaoTalk));
            }

            for(ClassContactM classContactT : m.getClassContactList().stream().filter(x -> (x.getInstructorNo() == null && x.getType() == null )).collect(Collectors.toList())) {
                this.getClassContactList().add(classContactT.getContact());
            }
        }
    }
}
