package NaniNaniApp.NaniNaniApp.repo;

import NaniNaniApp.NaniNaniApp.model.OptimalSleepSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface JpaChildWithSleepScheduleRepository extends JpaRepository<OptimalSleepSchedule, UUID>{
    @Query(value="SELECT s FROM OptimalSleepSchedule s WHERE ?1 BETWEEN from_month AND to_month")
    OptimalSleepSchedule findByMonth(Integer month);

}
