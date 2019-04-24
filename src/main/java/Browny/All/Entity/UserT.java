package Browny.All.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user")
public class UserT {

    @Id // javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no", nullable = false)
    private Long userNo;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "instructor")
    private Boolean instructor;

    @Column(name = "account")
    private String account;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "create_id", nullable = false)
    private String createId;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "update_id")
    private String updateId;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_no")
    private List<InstructorCareerT> instructorCareerTList = new ArrayList<>();

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_no")
    private List<InstructorContactT> instructorContactTList = new ArrayList<>();

    public UserT() {
        this.setCreateDate(LocalDateTime.now());
        this.setCreateId("Admin");
    }
}
