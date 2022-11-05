package NaniNaniApp.NaniNaniApp.model;

import javax.persistence.*;
import java.util.UUID;

import static java.lang.String.format;

@Entity
public class OptimalSleepSchedule {
    @Id
    @Column(name = "optimalSleepSchedule_id")
       private UUID id;
       private int fromMonth;
       private int toMonth;
       private int wakingPeriodMin;
       private int wakingPeriodMax;
       private int dayTimeNapsMin;
       private int dayTimeNapsMax;
       private int totalHoursOfSleepMin;
       private int totalHoursOfSleepMax;

   // @OneToMany (mappedBy="optimalSleepSchedule")
  //  private Set<Child> childSet;
    public OptimalSleepSchedule(){}
    public OptimalSleepSchedule(UUID id, int fromMonth, int toMonth, int wakingPeriodMin, int wakingPeriodMax, int dayTimeNapsMin, int dayTimeNapsMax, int totalHoursOfSleepMin, int totalHoursOfSleepMax) {
        this.id = id;
        this.fromMonth = fromMonth;
        this.toMonth = toMonth;
        this.wakingPeriodMin = wakingPeriodMin;
        this.wakingPeriodMax = wakingPeriodMax;
        this.dayTimeNapsMin = dayTimeNapsMin;
        this.dayTimeNapsMax = dayTimeNapsMax;
        this.totalHoursOfSleepMin = totalHoursOfSleepMin;
        this.totalHoursOfSleepMax = totalHoursOfSleepMax;
    }
    public UUID getId() {
        return id;
    }

    public int getFromMonth() {
        return fromMonth;
    }

    public int getToMonth() {
        return toMonth;
    }
    public int getWakingPeriodMin() {
        return wakingPeriodMin;
    }
    public String getWakingPeriodMinAsString() {
        return timeMinAsString(wakingPeriodMin);
    }
    public String getWakingPeriodMaxAsString() {
        return timeMaxAsString(wakingPeriodMax);
    }
    private String timeMinAsString(int wakingPeriodMin) {
        int minutes = wakingPeriodMin / 60;
        int seconds = wakingPeriodMin % 60;
        return format("%02d:%02d", minutes, seconds);
    }
    private String timeMaxAsString(int wakingPeriodMax) {
        int minutes = wakingPeriodMax / 60;
        int seconds = wakingPeriodMax % 60;
        return format("%02d:%02d", minutes, seconds);
    }

    public int getDayTimeNapsMin() {
        return dayTimeNapsMin;
    }

    public int getDayTimeNapsMax() {
        return dayTimeNapsMax;
    }

    public int getTotalHoursOfSleepMin() {
        return totalHoursOfSleepMin;
    }

    public int getTotalHoursOfSleepMax() {
        return totalHoursOfSleepMax;
    }

    public void setFromMonth(int fromMonth) {
        this.fromMonth = fromMonth;
    }

    public void setToMonth(int toMonth) {
        this.toMonth = toMonth;
    }

    public void setWakingPeriodMin(int wakingPeriodMin) {
        this.wakingPeriodMin = wakingPeriodMin;
    }

    public void setWakingPeriodMax(int wakingPeriodMax) {
        this.wakingPeriodMax = wakingPeriodMax;
    }

    public void setDayTimeNapsMin(int dayTimeNapsMin) {
        this.dayTimeNapsMin = dayTimeNapsMin;
    }

    public void setDayTimeNapsMax(int dayTimeNapsMax) {
        this.dayTimeNapsMax = dayTimeNapsMax;
    }

    public void setTotalHoursOfSleepMin(int totalHoursOfSleepMin) {
        this.totalHoursOfSleepMin = totalHoursOfSleepMin;
    }

    public void setTotalHoursOfSleepMax(int totalHoursOfSleepMax) {
        this.totalHoursOfSleepMax = totalHoursOfSleepMax;
    }

    public void setIdOss(UUID id) {
        this.id = id;
    }
}
