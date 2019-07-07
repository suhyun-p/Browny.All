package Browny.All.Model.Request;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class RegClassRequest {
    private String genre;
    private String region;
    private String type;
    private String only;
    private Long instructorNo1;
    private Long instructorNo2;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private String dateSummary;
    private String startTime;
    private String endTime;
    private String location;
    private int malePrice;
    private int femalePrice;
    private String payment;
    private String classImage;
    private List<String> dateOptionList = new ArrayList<>();
    private List<String> priceOptionList = new ArrayList<>();
    private List<ClassContactRequest> contactList = new ArrayList<>();

}
