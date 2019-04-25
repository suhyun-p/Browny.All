package Browny.All.Repository;

import Browny.All.Entity.UserT;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserT, Long> {
    List<UserT> findAllByInstructorIsTrue();
}
