package pl.kzochowski.ProgrammingKnowledge.model;

import java.util.List;
import java.util.Objects;

public class Exam {
    private int id;
    private Category category;
    private String name;
    private List<Question> questionList;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Objects.equals(id, exam.id) &&
                Objects.equals(category, exam.category) &&
                Objects.equals(name, exam.name) &&
                Objects.equals(questionList, exam.questionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, name, questionList);
    }
}
