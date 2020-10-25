package pl.honestit.spring.kb.data.model;

import javax.persistence.*;
import java.util.Objects;

@Entity // Oznaczamy, że klasa jest encją
@Table(name = "skills") // Dostosowujemy nazwę tabeli dla naszej encji
public class Skill {

    @Id // Wskazuje pole klucza głównego
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Wskazujemy aby baza danych dobrała mechanizm generowania wartości klucza głównego
    private Long id;
    @Column(unique = true, nullable = false)
    // Określamy aby nazwa umiejętności była unikalna i wymagana
    private String name;
    @Column(nullable = false) // Określamy aby nazwa kategorii dla umiejętności była wymagana
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(id, skill.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}