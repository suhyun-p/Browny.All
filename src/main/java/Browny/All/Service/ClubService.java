package Browny.All.Service;

import Browny.All.Entity.ClubT;
import Browny.All.Model.ClubM;
import Browny.All.Repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;

    @Transactional
    public List<ClubM> GetClubList() {
        List<ClubM> clubList = new ArrayList<>();
        List<ClubT> clubTList = clubRepository.findAll();
        for(ClubT clubT : clubTList)
            clubList.add(new ClubM(clubT));

        return clubList;
    }

    @Transactional
    public ClubM GetClub(long clubNo) {
        ClubT clubT = clubRepository.findById(clubNo).get();
        return new ClubM(clubT);
    }

    @Transactional
    public ClubM regClub(ClubM req) {
        ClubT clubT = clubRepository.save(new ClubT(req));
        clubRepository.save(clubT);

        return GetClub(clubT.getClubNo());
    }

    @Transactional
    public ClubM editClub(ClubM req) {
        ClubT clubT = clubRepository.findById(req.getClubNo()).get();
        clubT.setName(req.getClubName());
        clubRepository.save(clubT);

        return GetClub(clubT.getClubNo());
    }
}
