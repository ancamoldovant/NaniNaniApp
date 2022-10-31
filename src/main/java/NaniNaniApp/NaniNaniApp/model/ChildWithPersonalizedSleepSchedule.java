package NaniNaniApp.NaniNaniApp.model;

import java.time.LocalTime;

public class ChildWithPersonalizedSleepSchedule {
    private Child child;
    private LocalTime morningWakeUp;

    public ChildWithPersonalizedSleepSchedule(LocalTime morningWakeUp) {
        this.morningWakeUp = morningWakeUp;
    }
}
