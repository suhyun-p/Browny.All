package Browny.All.Repository;

import Browny.All.Entity.ClassEarlybirdT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassEarlybirdRepository extends JpaRepository<ClassEarlybirdT, Long> {
    void deleteAllByClassNo(Long classNo);
}
