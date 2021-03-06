package pl.kzochowski.ProgrammingKnowledge.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Objects;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //todo cascading
    @NotNull
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    //todo how to handle it?
    private Map<String,String> answers;

    @NotNull
    private String correctAnswer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, String> answers) {
        this.answers = answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id &&
                Objects.equals(answers, question.answers) &&
                Objects.equals(correctAnswer, question.correctAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, answers, correctAnswer);
    }
}
