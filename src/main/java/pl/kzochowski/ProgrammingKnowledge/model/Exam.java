package pl.kzochowski.ProgrammingKnowledge.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String header;

    @NotNull
    private String description;

    //todo cascading
    @NotNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;

    //todo cascading
    @NotNull
    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private List<Question> questionList;

    public Exam() {
    }

    public Exam(String header, String description, Category category) {
        this.header = header;
        this.description = description;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String name) {
        this.header = name;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return id == exam.id &&
                Objects.equals(header, exam.header) &&
                Objects.equals(description, exam.description) &&
                Objects.equals(category, exam.category) &&
                Objects.equals(questionList, exam.questionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, header, description, category, questionList);
    }
}
