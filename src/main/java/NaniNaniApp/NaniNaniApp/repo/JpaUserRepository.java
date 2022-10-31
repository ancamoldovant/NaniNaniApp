package NaniNaniApp.NaniNaniApp.repo;

import NaniNaniApp.NaniNaniApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<User, UUID> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUsername(String username);
}
