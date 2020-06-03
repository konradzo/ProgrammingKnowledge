package pl.kzochowski.ProgrammingKnowledge.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class ExamApproach {
    private int id;
    private User user;
    private Category category;
    private int points;
    private LocalDateTime approachDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public LocalDateTime getApproachDate() {
        return approachDate;
    }

    public void setApproachDate(LocalDateTime approachDate) {
        this.approachDate = approachDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamApproach that = (ExamApproach) o;
        return id == that.id &&
                points == that.points &&
                Objects.equals(user, that.user) &&
                Objects.equals(category, that.category) &&
                Objects.equals(approachDate, that.approachDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, category, points, approachDate);
    }
}
