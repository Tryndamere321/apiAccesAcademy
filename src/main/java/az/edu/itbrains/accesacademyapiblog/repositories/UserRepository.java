package az.edu.itbrains.accesacademyapiblog.repositories;

import az.edu.itbrains.accesacademyapiblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
