package Browny.All.Entity;

import Browny.All.Model.ClubM;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "club")
public class ClubT {
    @Id // javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_no", nullable = false)
    private Long clubNo;

    @Column(name = "name")
    private String name;

    public ClubT() {

    }

    public ClubT(ClubM req) {
        this.setName(req.getClubName());
    }
}
