package pl.kzochowski.ProgrammingKnowledge.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Subscription {
    private int id;
    private int userId;
    private LocalDateTime activeFrom;
    private LocalDateTime activeUntil;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return id == that.id &&
                userId == that.userId &&
                Objects.equals(activeFrom, that.activeFrom) &&
                Objects.equals(activeUntil, that.activeUntil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, activeFrom, activeUntil);
    }
}
