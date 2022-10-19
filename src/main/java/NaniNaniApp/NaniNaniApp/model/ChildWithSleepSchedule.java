package NaniNaniApp.NaniNaniApp.model;

public class ChildWithSleepSchedule {
    private Child child;
    private OptimalSleepSchedule optimalSleepSchedule;

    public ChildWithSleepSchedule(Child child, OptimalSleepSchedule optimalSleepSchedule) {
        this.child = child;
        this.optimalSleepSchedule = optimalSleepSchedule;
    }

    public Child getChild() {
        return child;
    }

    public OptimalSleepSchedule getOptimalSleepSchedule() {
        return optimalSleepSchedule;
    }
}
