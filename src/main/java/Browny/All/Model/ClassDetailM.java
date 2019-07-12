package Browny.All.Model;

import Browny.All.Entity.*;
import Browny.All.Enum.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Null;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Data
public class ClassDetailM {
    private Long classNo;
    private String genre;
    private String region;
    private String type;
    private String only;
    private String title;
    private String classImage;
    private Long instructorNo1;
    private Long instructorNo2;
    private String startDate;
    private String endDate;
    private String dateSummary;
    private List<String> dateOptionList = new ArrayList<>();
    private String startTime;
    private String endTime;
    private String location;
    private int malePrice;
    private int femalePrice;
    private List<String> priceOptionList = new ArrayList<>();
    private String payment;
    private List<ClassContactM> classContactList = new ArrayList<>();

    public ClassDetailM(ClassT t) {
        this.setClassNo(t.getClassNo());
        this.setGenre(t.getGenre());
        this.setRegion(t.getRegion());
        this.setType(t.getType());
        this.setOnly(t.getOnly());
        this.setTitle(t.getTitle());
        this.setClassImage(String.format("http://localhost:8080/assets/images/%s", t.getClassImage()));
        this.setInstructorNo1(t.getInstructor1().getUserNo());
        if(t.getInstructor2() != null) this.setInstructorNo2(t.getInstructor2().getUserNo());
        this.setStartDate(t.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        this.setEndDate(t.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        this.setDateSummary(t.getDateSummary());
        if(t.getClassDateOptionTList() != null && !t.getClassDateOptionTList().isEmpty()) {
            for(ClassDateOptionT dateOption : t.getClassDateOptionTList()) {
                this.getDateOptionList().add(dateOption.getOpt());
            }
        }
        this.setStartTime(t.getStartTime());
        this.setEndTime(t.getEndTime());
        this.setLocation(t.getLocation());
        this.setMalePrice(t.getMalePrice());
        this.setFemalePrice(t.getFemalePrice());
        if(t.getClassPriceOptionTList() != null && !t.getClassPriceOptionTList().isEmpty()) {
            for(ClassPriceOptionT priceOption : t.getClassPriceOptionTList()) {
                this.getPriceOptionList().add(priceOption.getOpt());
            }
        }
        this.setPayment(t.getPayment());
        if(t.getClassContactTList() != null && t.getClassContactTList().isEmpty()) {
            for(ClassContactT contact : t.getClassContactTList()) {
                this.getClassContactList().add(new ClassContactM(contact.getInstructorNo(), contact.getType(), contact.getContact()));
            }
        }
    }
}
