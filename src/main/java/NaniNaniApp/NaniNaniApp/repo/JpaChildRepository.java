package NaniNaniApp.NaniNaniApp.repo;

import NaniNaniApp.NaniNaniApp.model.Child;
import NaniNaniApp.NaniNaniApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public interface JpaChildRepository extends JpaRepository<Child, UUID> {
    @Query(value = "SELECT c FROM Child c WHERE c.user = :user")
    List<Child> findAllChildrenByUser(User user);


    @Query("SELECT u FROM Child u WHERE u.name = ?1")
    User findByName(String name);
}
