package az.edu.itbrains.accesacademyapiblog.repositories;

import az.edu.itbrains.accesacademyapiblog.models.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {
    Optional<RefreshToken> findByToken(String token);
    Optional<RefreshToken> findByUserId(Long id);
}
