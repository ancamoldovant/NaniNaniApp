package NaniNaniApp.NaniNaniApp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;
@Entity
public class InfoSleepSchedule {
    @Id
    @Column(name = "infoSleepSchedule_id")
    private UUID id;
    private Integer fromMonth;
    private Integer toMonth;
    private String title;
    private String describingInfoSleepSchedule;

    public InfoSleepSchedule(UUID id, Integer fromMonth, Integer toMonth, String title, String describingInfoSleepSchedule) {
        this.id = id;
        this.fromMonth = fromMonth;
        this.toMonth = toMonth;
        this.title= title;
        this.describingInfoSleepSchedule= describingInfoSleepSchedule;
    }
    public InfoSleepSchedule() {
    }

    public UUID getId() {
        return id;
    }

    public Integer getFromMonth() {
        return fromMonth;
    }

    public int getToMonth() {
        return toMonth;
    }
    public String getTitle() {
        return title;
    }

    public String getDescribingInfoSleepSchedule() {
        return describingInfoSleepSchedule;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescribingInfoSleepSchedule(String describingInfoSleepSchedule) {
        this.describingInfoSleepSchedule = describingInfoSleepSchedule;
    }
}
