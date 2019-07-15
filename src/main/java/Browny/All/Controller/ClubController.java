package Browny.All.Controller;

import Browny.All.Model.ClassSimpleM;
import Browny.All.Model.ClubM;
import Browny.All.Service.ClassService;
import Browny.All.Service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/club")
public class ClubController {
    @Autowired
    ClubService clubService;

    @RequestMapping(value = "/getClubByClubNo", method = RequestMethod.GET)
    public ResponseEntity<ClubM> getClubByClubNo(@RequestParam("clubNo") Long clubNo) {
        ClubM club = clubService.GetClub(clubNo);
        return new ResponseEntity(club, OK);
    }
}
