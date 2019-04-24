package Browny.All.Repository;

import Browny.All.Entity.UserT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserT, Long> {
}
