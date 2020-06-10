package pl.kzochowski.ProgrammingKnowledge.model;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    //todo cascading
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Exam> examList;

    //todo cascading
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<ExamApproach> examApproaches;

    public Category() {
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(name, category.name) &&
                Objects.equals(description, category.description) &&
                Objects.equals(examList, category.examList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, examList);
    }
}
