package NaniNaniApp.NaniNaniApp.model;

import javax.persistence.Entity;
import java.time.LocalTime;
import java.util.UUID;

import static java.lang.String.format;

public class ChildWithPersonalizedSleepSchedule {
    private Child child;
    private OptimalSleepSchedule optimalSleepSchedule;
    private UUID id;
    private LocalTime wakeUpTime;

    public int getNextSleepTime() {
        return nextSleepTime;
    }

    private int nextSleepTime;

    public ChildWithPersonalizedSleepSchedule(Child child, OptimalSleepSchedule optimalSleepSchedule, UUID id, LocalTime wakeUpTime, int nextSleepTime) {
        this.child = child;
        this.optimalSleepSchedule = optimalSleepSchedule;
        this.id = id;
        this.wakeUpTime = wakeUpTime;
        this.nextSleepTime = nextSleepTime;
    }

    public Child getChild() {
        return child;
    }

    public OptimalSleepSchedule getOptimalSleepSchedule() {
        return optimalSleepSchedule;
    }

    public UUID getId() {
        return id;
    }

    public LocalTime getWakeUpTime() {
        return wakeUpTime;
    }

}


