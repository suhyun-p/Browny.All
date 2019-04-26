package Browny.All.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "class_price_option")
public class ClassPriceOptionT {
    @Id // javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false)
    private Long seq;

    @Column(name = "class_no", nullable = false)
    private long classNo;

    @Column(name = "opt")
    private String opt;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "create_id", nullable = false)
    private String createId;

    public ClassPriceOptionT() {
        this.setCreateDate(LocalDateTime.now());
        this.setCreateId("Admin");
    }

    public ClassPriceOptionT(long classNo) {
        this.setClassNo(classNo);
        this.setCreateDate(LocalDateTime.now());
        this.setCreateId("Admin");
    }
}