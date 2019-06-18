package Browny.All.Entity;

import Browny.All.Enum.*;
import Browny.All.Model.EarlybirdM;
import Browny.All.Model.InstructorContactM;
import Browny.All.Model.UserM;
import io.swagger.models.Contact;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
public class ClassDetailT {
    private Long classNo;
    private String genre;
    private String region;
    private String type;
    private String only;
    private String title;
    private String classImage;
    private Long instructorNo1;
    private Long instructorNo2;
    private String instructorNickname1;
    private String instructorNickname2;
    private String startDate;
    private String endDate;
    private String dateSummary;
    private String startTime;
    private String endTime;
    private String location;
    private int malePrice;
    private int femalePrice;
    private EarlybirdM earlybird;
    private String paymentType;
    private String payment;
    private List<InstructorContactM> contactList = new ArrayList<>();
    private List<String> dateOptionList = new ArrayList<>();
    private List<String> priceOptionList = new ArrayList<>();

    private ClassDetailT() {

    }

    public ClassDetailT(ClassT classT) {
        this.setClassNo(classT.getClassNo());
        this.setGenre(classT.getGenre());
        this.setRegion(classT.getRegion());
        this.setType(classT.getType());
        this.setOnly(classT.getOnly());
        this.setTitle(classT.getTitle());
        this.setClassImage(classT.getClassImage());
        this.setInstructorNo1(classT.getInstructor1().getUserNo());
        this.setInstructorNickname1(classT.getInstructor1().getNickname());

        if(classT.getInstructor2() != null) {
            this.setInstructorNo2(classT.getInstructor2().getUserNo());
            this.setInstructorNickname2(classT.getInstructor2().getNickname());
        }

        this.setStartDate(classT.getStartDate().toString());
        this.setEndDate(classT.getEndDate().toString());
        this.setDateSummary(classT.getDateSummary());
        this.setStartTime(classT.getStartTime());
        this.setEndTime(classT.getEndTime());
        this.setLocation(classT.getLocation());
        this.setMalePrice(classT.getMalePrice());
        this.setFemalePrice(classT.getFemalePrice());
        this.setPayment(classT.getPayment());

        if(classT.getClassDateOptionTList() != null) {
            for(ClassDateOptionT dateOption : classT.getClassDateOptionTList()) {
                this.getDateOptionList().add(dateOption.getOpt());
            }
        }

        if(classT.getClassPriceOptionTList() != null) {
            for(ClassPriceOptionT priceOption : classT.getClassPriceOptionTList()) {
                this.getPriceOptionList().add(priceOption.getOpt());
            }
        }

        for(ClassContactT t :classT.getClassContactTList()) {
            this.getContactList().add(new InstructorContactM(t.getInstructorNo(), ContactType.valueOf(t.getType()), t.getContact()));
        }
    }
}
