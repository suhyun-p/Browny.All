package Browny.All.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "class_contact")
public class ClassContactT {
    @Id // javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false)
    private Long seq;

    @Column(name = "class_no", nullable = false)
    private Long classNo;

    @Column(name = "instructor_no")
    private Long instructorNo;

    @Column(name = "type")
    private String type;

    @Column(name = "contact")
    private String contact;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "create_id", nullable = false)
    private String createId;

    public ClassContactT() {
        this.setCreateDate(LocalDateTime.now());
        this.setCreateId("Admin");
    }

    public ClassContactT(long classNo) {
        this.setClassNo(classNo);
        this.setCreateDate(LocalDateTime.now());
        this.setCreateId("Admin");
    }
}
