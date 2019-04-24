package Browny.All.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Data
@Table(name = "instructor_career")
public class InstructorCareerT {
    @Id // javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false)
    private Long seq;

    @Column(name = "instructor_no", nullable = false)
    private Long instructorNo;

    @Column(name = "career")
    private String career;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "create_id", nullable = false)
    private String createId;

    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @Column(name = "update_id", nullable = false)
    private String updateId;

    public InstructorCareerT() {
    }

    public InstructorCareerT(Long instructorNo) {
        this.setInstructorNo(instructorNo);
        this.setCreateDate(LocalDateTime.now());
        this.setCreateId("Admin");
    }
}
