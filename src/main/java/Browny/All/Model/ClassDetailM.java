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
    private String genre;
    private String region;
    private String type;
    private boolean typeExpose;
    private String only;
    private boolean onlyExpose;
    private String title;
    private String classImage;
    private String instructor;
    private Long instructorNo1;
    private String instructorName1;
    private Long instructorNo2;
    private String instructorName2;
    private boolean instructor2;
    private String date;
    private String dateSummary;
    private String time;
    private String location;
    private String price;
    private EarlybirdM earlybird;
    private String payment;
    private List<String> contactList = new ArrayList<>();
    private String instructorKakao1;
    private String instructorKakao2;
    private List<String> dateOptionList = new ArrayList<>();
    private List<String> priceOptionList = new ArrayList<>();

    public ClassDetailM(ClassDetailT t) {
        this.setClassNo(t.getClassNo());
        this.setGenre(String.format("#%s", Genre.valueOf(t.getGenre()).getValue()));
        this.setRegion(String.format("#%s", Region.valueOf(t.getRegion()).getValue()));

        if(!ClassType.valueOf(t.getType()).equals(ClassType.N)) {
            this.setType(String.format("#%s", ClassType.valueOf(t.getType()).getValue()));
            this.setTypeExpose(true);
        }

        if(t.getOnly() != null) {
            this.setOnly(String.format("#%s", Only.valueOf(t.getOnly()).getValue()));
            this.setOnlyExpose(true);
        }

        this.setInstructorNo1(t.getInstructor1().getUserNo());
        this.setInstructorName1(String.format("#%s", t.getInstructor1().getNickname()));

        if(t.getInstructor2() != null) {
            this.setInstructorNo2(t.getInstructor2().getUserNo());
            this.setInstructorName2(String.format("#%s", t.getInstructor2().getNickname()));
            this.setInstructor2(true);
        }

        this.setTitle(t.getTitle());
        this.setClassImage(String.format("http://localhost:8080/assets/images/%s", t.getClassImage()));

        if(t.getInstructor2() != null) {
            this.setInstructor(String.format("%s, %s", t.getInstructor1().getNickname(), t.getInstructor2().getNickname()));
        }
        else {
            this.setInstructor(String.format("%s", t.getInstructor1().getNickname()));
        }

        this.setDate(String.format("%s ~ %s", t.getStartDate(), t.getEndDate()));
        this.setDateSummary(String.format("(%s)", t.getDateSummary()));
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

        if(t.getOnly()== null)
            this.setPrice(String.format("남자 %s / 여자 %s",Integer.toString(t.getMalePrice()), Integer.toString(t.getFemalePrice())));
        else {
            if(Only.valueOf(t.getOnly()).equals(Only.F))
                this.setPrice(Integer.toString(t.getFemalePrice()));
            else if(Only.valueOf(t.getOnly()).equals(Only.M))
                this.setPrice(Integer.toString(t.getMalePrice()));
        }

        this.setPriceOptionList(t.getPriceOptionList());

        if (t.getPaymentType().equals("1"))
            this.setPayment(t.getInstructor1().getAccount());
        else if (t.getPaymentType().equals("2"))
            this.setPayment(t.getInstructor2().getAccount());
        else if (t.getPaymentType().equals("3"))
            this.setPayment(t.getPayment());

        this.contactList.add(String.format("%s %s", t.getInstructor1().getNickname(), t.getInstructor1().getPhoneNo()));
        if(t.getInstructor2() != null) {
            if(t.getInstructor2().getPhoneNo() != null) this.contactList.add(String.format("%s %s", t.getInstructor2().getNickname(), t.getInstructor2().getPhoneNo()));
        }
    }
}
