package Browny.All.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "class")
public class ClassT {
    @Id // javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_no", nullable = false)
    private Long classNo;

    @Column(name = "genre")
    private String genre;

    @Column(name = "region")
    private String region;

    @Column(name = "type")
    private String type;

    @Column(name = "only")
    private String only;

    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_no_1")
    private UserT instructor1;

    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_no_2")
    private UserT instructor2;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "start_time", nullable = false)
    private String startTime;

    @Column(name = "end_time", nullable = false)
    private String endTime;

    @Column(name = "male_price", nullable = false)
    private int malePrice;

    @Column(name = "female_price")
    private int femalePrice;

    @Column(name = "payment_type", nullable = false)
    private int paymentType;

    @Column(name = "payment")
    private String payment;

    @Column(name = "level")
    private Integer level;

    @Column(name = "recruitment_type")
    private String recruitmentType;

    @Column(name = "recruitment_number")
    private Integer recruitmentNumber;

    @Column(name = "contents")
    private String contents;

    @Column(name = "class_image")
    private String classImage;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "create_id", nullable = false)
    private String createId;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "update_id")
    private String updateId;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="class_no")
    private List<ClassDateOptionT> classDateOptionTList;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="class_no")
    private List<ClassPriceOptionT> classPriceOptionTList;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="class_no")
    private List<ClassContactT> classContactTList;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="class_no")
    private List<ClassEarlybirdT> classEarlybirdTList;

    public ClassT() {
        this.setCreateDate(LocalDateTime.now());
        this.setCreateId("Admin");
    }
}
