package NaniNaniApp.NaniNaniApp.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
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


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
