package id.mhafizsir.quranannotation.repository;

import id.mhafizsir.quranannotation.dao.UserProfile;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, UUID> {

  Optional<UserProfile> findByRefreshToken(String refreshToken);
}
