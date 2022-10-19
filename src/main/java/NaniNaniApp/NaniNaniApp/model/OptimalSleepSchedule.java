package NaniNaniApp.NaniNaniApp.model;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;
@Entity
public class OptimalSleepSchedule {
    @Id
    @Column(name = "optimalSleepSchedule_id")
       private UUID id;
       private int fromMonth;
       private int toMonth;
       private int wakingPeriodMin;
       private int wakingPeriodMax;
       private int daytimeNapsMin;
       private int daytimeNapsMax;
       private int totalHoursOfSleepMin;
       private int totalHoursOfSleepMax;

   // @OneToMany (mappedBy="optimalSleepSchedule")
  //  private Set<Child> childSet;
    public OptimalSleepSchedule(){}
    public OptimalSleepSchedule(UUID id, int fromMonth, int toMonth, int wakingPeriodMin, int wakingPeriodMax, int daytimeNapsMin, int daytimeNapsMax, int totalHoursOfSleepMin, int totalHoursOfSleepMax) {
        this.id = id;
        this.fromMonth = fromMonth;
        this.toMonth = toMonth;
        this.wakingPeriodMin = wakingPeriodMin;
        this.wakingPeriodMax = wakingPeriodMax;
        this.daytimeNapsMin = daytimeNapsMin;
        this.daytimeNapsMax = daytimeNapsMax;
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

    public int getWakingPeriodMax() {
        return wakingPeriodMax;
    }

    public int getDaytimeNapsMin() {
        return daytimeNapsMin;
    }

    public int getDaytimeNapsMax() {
        return daytimeNapsMax;
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

    public void setDaytimeNapsMin(int daytimeNapsMin) {
        this.daytimeNapsMin = daytimeNapsMin;
    }

    public void setDaytimeNapsMax(int daytimeNapsMax) {
        this.daytimeNapsMax = daytimeNapsMax;
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
