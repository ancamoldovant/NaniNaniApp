package NaniNaniApp.NaniNaniApp.repo;

import NaniNaniApp.NaniNaniApp.model.InfoSleepSchedule;
import NaniNaniApp.NaniNaniApp.model.OptimalSleepSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaInfoSleepScheduleRepository extends JpaRepository <InfoSleepSchedule, String> {
    List<InfoSleepSchedule> findByTitle (String title);

}
