package pl.honestit.spring.kb.data.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity // Oznaczamy, że klasa jest encją
@Table(name = "knowledge_sources") // Dodajemy informację o nazwie tabeli dla encji
public class KnowledgeSource {

    @Id // Wskazujemy pole klucza głównego
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // oraz strategię generowania wartości oparta na bazie danych
    private Long id;
    @Column(unique = true, nullable = false) // Określamy nazwę źródła jako unikalną i wymaganą
    private String name;
    @Column(columnDefinition = "TEXT")
    // Definiujemy docelowy typ kolumny jako TEXT zamiast domyślnego varchar(255)
    private String description;
    private String url;
    private Boolean active;

    @ManyToMany // Dostarczamy mapowanie wiele do wielu między źródłami wiedzy a umiejętnościami
    @JoinTable(name = "knowledge_sources_skills", // Wskazujemy wprost nazwę tabeli mapująej
            joinColumns = @JoinColumn(name = "source_id"), // nazwę pola referencji do encji KnowledgeSource
            inverseJoinColumns = @JoinColumn(name = "skill_id") // oraz nazwę pola referencji do encji Skill
    )
    private Set<Skill> connectedSkills = new HashSet<>();

    @ManyToMany(mappedBy = "knownSources")
    private Set<User> knowingUsers = new HashSet<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Skill> getConnectedSkills() {
        return connectedSkills;
    }

    public void setConnectedSkills(Set<Skill> connectedSkills) {
        this.connectedSkills = connectedSkills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KnowledgeSource that = (KnowledgeSource) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "KnowledgeSource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", active=" + active +
                '}';
    }

    public Set<User> getKnowingUsers() {
        return knowingUsers;
    }

    public void setKnowingUsers(Set<User> knowingUsers) {
        this.knowingUsers = knowingUsers;
    }
}