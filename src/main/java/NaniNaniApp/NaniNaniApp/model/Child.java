package NaniNaniApp.NaniNaniApp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
@Entity
public class Child {
@Id
@Column(name = "child_id")
    private UUID id;

    private String name;
    @Column(name = "dateOfBirth", columnDefinition = "DATE")
    private LocalDate dateOfBirth;

   public Child(){
  }

    public Child(UUID id, String name, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public int getMonths() {
        return (int) ChronoUnit.MONTHS.between(dateOfBirth, LocalDate.now());
    }
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }


}
