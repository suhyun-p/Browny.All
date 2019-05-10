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
public class ClassSimpleM {
    private Long classNo;
    private String genre;
    private String region;
    private String type;
    private String only;
    private String title;
    private Long instructorNo1;
    private String instructorNick1;
    private Long instructorNo2;
    private String instructorNick2;
    private String date;
    private String time;
    private String price;
    private String classImage;
}
