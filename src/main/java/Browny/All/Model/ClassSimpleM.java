package Browny.All.Model;

import Browny.All.Entity.ClassSimpleT;
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

    public ClassSimpleM(ClassSimpleT t) {
        this.setClassNo(t.getClassNo());
        this.setGenreText(String.format("#%s", t.getGenre().getValue()));
        this.setGenreCode(t.getGenre().getKey());
        this.setRegionText(String.format("#%s", t.getRegion().getValue()));
        this.setRegionCode(t.getRegion().getKey());

        if(t.getType() != null) {
            this.setTypeText(String.format("#%s", t.getType().getValue()));
            this.setTypeCode(t.getType().getKey());
        }
        if(t.getOnly() != null) {
            this.setOnlyText(String.format("#%s", t.getOnly().getValue()));
            this.setOnlyCode(t.getOnly().getKey());
        }

        this.setTitle(t.getTitle());
        this.setClassImage(String.format("http://localhost:8080/assets/images/%s",t.getClassImage()));
    }
}
