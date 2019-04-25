package Browny.All.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "class_earlybird")
public class ClassEarlybirdT {
    @Id // javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false)
    private Long seq;

    @Column(name = "class_no", nullable = false)
    private Long classNo;

    @Column(name = "deadline", nullable = false)
    private LocalDate deadline;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "create_id", nullable = false)
    private String createId;

    public ClassEarlybirdT() {
        this.setCreateDate(LocalDateTime.now());
        this.setCreateId("Admin");
    }

    public ClassEarlybirdT(long classNo) {
        this.setClassNo(classNo);
        this.setCreateDate(LocalDateTime.now());
        this.setCreateId("Admin");
    }
}