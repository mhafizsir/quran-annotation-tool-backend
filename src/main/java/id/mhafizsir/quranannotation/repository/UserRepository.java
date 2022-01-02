package id.mhafizsir.quranannotation.repository;

import id.mhafizsir.quranannotation.dao.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

  @Query(value = "select u from User u "
      + "where u.username = :username "
      + "or u.email = :username ")
  User findByUsernameOrEmail(@Param("username") String username);

  Boolean existsByUsernameOrEmail(String username, String email);

}
