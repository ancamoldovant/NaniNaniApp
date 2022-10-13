package NaniNaniApp.NaniNaniApp.model;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Child {

    private UUID id;

    private String name;

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

}
