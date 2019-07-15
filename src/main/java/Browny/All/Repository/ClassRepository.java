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

    List<ClassT> findAllByExposeYnIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(String ExposeYn, LocalDate today);
    List<ClassT> findAllByExposeYnIsAndGenreIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(String ExposeYn, String genre, LocalDate today);
    List<ClassT> findAllByExposeYnIsAndRegionIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(String ExposeYn, String region, LocalDate today);
    List<ClassT> findAllByExposeYnIsAndTypeIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(String ExposeYn, String type, LocalDate today);
    List<ClassT> findAllByExposeYnIsAndOnlyIsAndEndDateIsGreaterThanEqualOrderByStartDateDesc(String ExposeYn, String only, LocalDate today);
    List<ClassT> findAllByExposeYnIsAndInstructor1AndEndDateIsGreaterThanEqualOrExposeYnIsAndInstructor2AndEndDateIsGreaterThanEqualOrderByStartDateDesc(String ExposeYn1, UserT instructor1, LocalDate today1, String ExposeYn2, UserT instructor2, LocalDate today2);
    List<ClassT> findAllByExposeYnIsAndInstructor1AndEndDateIsLessThanOrExposeYnIsAndInstructor2AndEndDateIsLessThanOrderByStartDateDesc(String ExposeYn1, UserT instructor1, LocalDate today1, String ExposeYn2, UserT instructor2, LocalDate today2);
    List<ClassT> findAllByExposeYnIsAndClubAndEndDateIsGreaterThanEqualOrderByStartDateDesc(String ExposeYn, ClubT club, LocalDate today);
}
