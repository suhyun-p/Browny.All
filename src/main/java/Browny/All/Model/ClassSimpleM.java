package Browny.All.Model;

import Browny.All.Entity.ClassT;
import Browny.All.Enum.ClassType;
import Browny.All.Enum.Genre;
import Browny.All.Enum.Only;
import Browny.All.Enum.Region;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public ClassSimpleM(ClassT t) {
        this.setClassNo(t.getClassNo());
        this.setGenreText(String.format("#%s", Genre.valueOf(t.getGenre()).getValue()));
        this.setGenreCode(Genre.valueOf(t.getGenre()).getKey());
        this.setRegionText(String.format("#%s", Region.valueOf(t.getRegion()).getValue()));
        this.setRegionCode(Region.valueOf(t.getRegion()).getKey());

        if(!t.getType().equals(ClassType.N)) {
            this.setTypeText(String.format("#%s", ClassType.valueOf(t.getType()).getValue()));
            this.setTypeCode(ClassType.valueOf(t.getType()).getKey());
        }
        if(t.getOnly() != null) {
            this.setOnlyText(String.format("#%s", Only.valueOf(t.getOnly()).getValue()));
            this.setOnlyCode(Only.valueOf(t.getOnly()).getKey());
        }

        this.setTitle(t.getTitle());
        this.setClassImage(String.format("http://localhost:8080/assets/images/%s",t.getClassImage()));
    }
}
