package NaniNaniApp.NaniNaniApp.repo;

import NaniNaniApp.NaniNaniApp.model.ChildWithPersonalizedSleepSchedule;
import NaniNaniApp.NaniNaniApp.model.OptimalSleepSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface JpaChildWithPersonalizedSleepScheduleRepository extends JpaRepository<OptimalSleepSchedule, UUID>{


}
