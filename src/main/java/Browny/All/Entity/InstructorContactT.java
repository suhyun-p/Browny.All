package Browny.All.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "instructor_contact")
public class InstructorContactT {
    @Id // javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false)
    private Long seq;

    @Column(name = "instructor_no", nullable = false)
    private Long instructorNo;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "contact")
    private String contact;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "create_id", nullable = false)
    private String createId;

    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @Column(name = "update_id", nullable = false)
    private String updateId;


    public InstructorContactT() {
        this.setCreateDate(LocalDateTime.now());
        this.setCreateId("Admin");
    }

    public InstructorContactT(Long instructorNo, String type, String name, String contact) {
        this.setInstructorNo(instructorNo);
        this.setType(type);
        this.setName(name);
        this.setContact(contact);
        this.setCreateDate(LocalDateTime.now());
        this.setCreateId("Admin");
    }
}
