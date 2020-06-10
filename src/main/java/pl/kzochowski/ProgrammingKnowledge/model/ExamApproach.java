package pl.kzochowski.ProgrammingKnowledge.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class ExamApproach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //todo cascading
    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //todo cascading
    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    //todo cascading
    @NotNull
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @NotNull
    private int points;

    @NotNull
    private LocalDateTime approachDate;

    public ExamApproach() {
    }

    public ExamApproach(User user, Category category, Exam exam, int points) {
        this.user = user;
        this.category = category;
        this.exam = exam;
        this.points = points;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

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
                Objects.equals(exam, that.exam) &&
                Objects.equals(approachDate, that.approachDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, category, exam, points, approachDate);
    }
}
