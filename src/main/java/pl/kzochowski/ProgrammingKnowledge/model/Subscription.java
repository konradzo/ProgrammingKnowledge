package pl.kzochowski.ProgrammingKnowledge.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @OneToOne(mappedBy = "subscription", cascade = CascadeType.ALL)
    private User user;

    @NotNull
    private LocalDateTime activeFrom;

    @NotNull
    private LocalDateTime activeUntil;

    public Subscription(){}

    public Subscription(User user, LocalDateTime activeFrom, LocalDateTime activeUntil){
        this.user = user;
        this.activeFrom = activeFrom;
        this.activeUntil = activeUntil;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getActiveFrom() {
        return activeFrom;
    }

    public void setActiveFrom(LocalDateTime activeFrom) {
        this.activeFrom = activeFrom;
    }

    public LocalDateTime getActiveUntil() {
        return activeUntil;
    }

    public void setActiveUntil(LocalDateTime activeUntil) {
        this.activeUntil = activeUntil;
    }


}
