package Browny.All.Entity;

import Browny.All.Enum.ClassType;
import Browny.All.Enum.Genre;
import Browny.All.Enum.Only;
import Browny.All.Enum.Region;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ClassSimpleT {
    private Long classNo;
    private Genre genre;
    private Region region;
    private ClassType type;
    private Only only;
    private String title;
    private String classImage;

    public ClassSimpleT() {

    }

    public ClassSimpleT(ClassT classT) {
        this.setClassNo(classT.getClassNo());
        this.setGenre(Genre.valueOf(classT.getGenre()));
        this.setRegion(Region.valueOf(classT.getRegion()));
        this.setType(classT.getType().equals(ClassType.N.getKey()) ? null : ClassType.valueOf(classT.getType()));
        this.setOnly(classT.getOnly() == null ? null : Only.valueOf(classT.getOnly()));
        this.setTitle(classT.getTitle());
        this.setClassImage(classT.getClassImage());
    }
}
