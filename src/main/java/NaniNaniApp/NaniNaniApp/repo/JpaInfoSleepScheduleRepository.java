package NaniNaniApp.NaniNaniApp.repo;

import NaniNaniApp.NaniNaniApp.model.InfoSleepSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JpaInfoSleepScheduleRepository extends JpaRepository <InfoSleepSchedule, String> {
    List<InfoSleepSchedule> findByTitle (String title);

    List<InfoSleepSchedule> findAllByOrderByFromMonthAsc();

    @Query(value= "SELECT d FROM InfoSleepSchedule d WHERE from_month IS NOT NULL ORDER BY from_month ASC")
     InfoSleepSchedule findAllByOrderByFromMonthAscNotNull();

}
