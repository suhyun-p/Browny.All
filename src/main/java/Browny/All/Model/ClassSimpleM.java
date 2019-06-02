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
    private String genre;
    private String region;
    private String type;
    private boolean typeExpose;
    private String only;
    private boolean onlyExpose;
    private String title;
    private String classImage;

    public ClassSimpleM(ClassSimpleT t) {
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
        this.setTitle(t.getTitle());
        this.setClassImage(String.format("http://localhost:8080/assets/images/%s",t.getClassImage()));
    }
}
