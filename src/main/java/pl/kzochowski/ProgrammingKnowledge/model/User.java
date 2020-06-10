package pl.kzochowski.ProgrammingKnowledge.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String username;

    @NotNull
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    //todo cascading
    @OneToMany(mappedBy = "user")
    private List<ExamApproach> examApproachList;

    public User() {
    }

    public User(String name, String surname, String username, String email) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(subscription, user.subscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, username, email, subscription);
    }
}
