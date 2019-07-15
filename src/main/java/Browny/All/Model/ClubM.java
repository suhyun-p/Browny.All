package Browny.All.Model;

import Browny.All.Entity.ClubT;
import lombok.*;

@Data
@NoArgsConstructor
public class ClubM {
    private Long clubNo;
    private String clubName;

    public ClubM(ClubT t) {
        this.setClubNo(t.getClubNo());
        this.setClubName(t.getName());
    }
}
