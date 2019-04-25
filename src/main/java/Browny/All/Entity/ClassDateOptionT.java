package Browny.All.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "class_date_option")
public class ClassDateOptionT {
    @Id // javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false)
    private Long seq;

    @Column(name = "class_no", nullable = false)
    private Long classNo;

    @Column(name = "\"option\"") // Annotation으로 Keyword로 지정된 단어 사용
    private String option;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "create_id", nullable = false)
    private String createId;

    public ClassDateOptionT() {
        this.setCreateDate(LocalDateTime.now());
        this.setCreateId("Admin");
    }

    public ClassDateOptionT(long classNo) {
        this.setClassNo(classNo);
        this.setCreateDate(LocalDateTime.now());
        this.setCreateId("Admin");
    }
}