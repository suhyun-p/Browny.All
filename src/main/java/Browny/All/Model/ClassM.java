package Browny.All.Model;

import Browny.All.Enum.ClassType;
import Browny.All.Enum.Genre;
import Browny.All.Enum.Only;
import Browny.All.Enum.Region;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class ClassM {
    private Long classNo;
    private Genre genre;
    private Region region;
    private ClassType type;
    private Only only;
    private String title;
    private String instructor1;
    private String instructor2;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private String location;
    private int malePrice;
    private int femalePrice;
    private String payment;
    private List<InstructorContactM> contactList  = new ArrayList<>();
}
