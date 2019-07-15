package Browny.All.Repository;

import Browny.All.Entity.ClassT;
import Browny.All.Entity.ClubT;
import Browny.All.Entity.UserT;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ClassRepository extends JpaRepository<ClassT, Long> {
    List<ClassT> findAllByOrderByStartDateDesc();
    List<ClassT> findAllByGenreIsOrderByStartDateDesc(String genre);
    List<ClassT> findAllByRegionIsOrderByStartDateDesc(String region);
    List<ClassT> findAllByTypeIsOrderByStartDateDesc(String type);
    List<ClassT> findAllByOnlyIsOrderByStartDateDesc(String only);
    List<ClassT> findAllByInstructor1OrInstructor2OrderByStartDateDesc(UserT instructor1, UserT instructor2);
    List<ClassT> findAllByClubOrderByStartDateDesc(ClubT club);

    List<ClassT> findAllByEndDateIsGreaterThanEqualOrderByStartDateDesc(LocalDate today);
    List<ClassT> findAllByGenreIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(String genre, LocalDate today);
    List<ClassT> findAllByRegionIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(String region, LocalDate today);
    List<ClassT> findAllByTypeIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(String type, LocalDate today);
    List<ClassT> findAllByOnlyIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(String only, LocalDate today);
    List<ClassT> findAllByInstructor1AndEndDateIsGreaterThanEqualOrInstructor2AndEndDateIsGreaterThanEqualOrderByStartDateDesc(UserT instructor1, LocalDate today1, UserT instructor2, LocalDate today2);
    List<ClassT> findAllByInstructor1AndEndDateIsLessThanOrInstructor2AndEndDateIsLessThanOrderByStartDateDesc(UserT instructor1, LocalDate today1, UserT instructor2, LocalDate today2);
    List<ClassT> findAllByClubAndEndDateIsGreaterThanEqualOrderByStartDateDesc(ClubT club, LocalDate today);
}
