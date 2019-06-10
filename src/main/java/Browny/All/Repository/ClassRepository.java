package Browny.All.Repository;

import Browny.All.Entity.ClassT;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ClassRepository extends JpaRepository<ClassT, Long> {
    List<ClassT>  findAllByOrderByStartDateDesc();
    List<ClassT>  findAllByEndDateIsGreaterThanEqualOrderByStartDateDesc(LocalDate today);
}
