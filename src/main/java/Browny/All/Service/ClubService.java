package Browny.All.Service;

import Browny.All.Entity.ClubT;
import Browny.All.Model.ClubM;
import Browny.All.Repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;

    @Transactional
    public ClubM GetClub(long clubNo) {
        ClubT clubT = clubRepository.findById(clubNo).get();
        return new ClubM(clubT);
    }
}
