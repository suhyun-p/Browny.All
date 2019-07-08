package Browny.All.Repository;

import Browny.All.Entity.ClassContactT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassContactRepository extends JpaRepository<ClassContactT, Long> {
    void deleteAllByClassNo(Long classNo);
}
