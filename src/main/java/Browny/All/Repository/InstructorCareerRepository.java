package Browny.All.Repository;

import Browny.All.Entity.InstructorCareerT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorCareerRepository extends JpaRepository<InstructorCareerT, Long> {
    void deleteAllByInstructorNo(Long instructorNo);
}
