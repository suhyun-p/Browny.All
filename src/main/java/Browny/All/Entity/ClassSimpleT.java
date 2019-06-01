package Browny.All.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ClassSimpleT {
    private Long classNo;
    private String genre;
    private String region;
    private String type;
    private String only;
    private String title;
    private String classImage;

    public ClassSimpleT() {

    }

    public ClassSimpleT(ClassT classT) {
        this.setClassNo(classT.getClassNo());
        this.setGenre(classT.getGenre());
        this.setRegion(classT.getRegion());
        this.setType(classT.getType());
        this.setOnly(classT.getOnly());
        this.setTitle(classT.getTitle());
        this.setClassImage(classT.getClassImage());
    }
}
