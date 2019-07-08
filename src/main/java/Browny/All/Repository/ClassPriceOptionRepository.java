package Browny.All.Repository;

import Browny.All.Entity.ClassPriceOptionT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassPriceOptionRepository extends JpaRepository<ClassPriceOptionT, Long> {
    void deleteAllByClassNo(Long classNo);
}
