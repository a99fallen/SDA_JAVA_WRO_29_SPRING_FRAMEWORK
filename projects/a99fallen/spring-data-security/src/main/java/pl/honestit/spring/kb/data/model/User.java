package pl.honestit.spring.kb.data.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity // Wskazanie klasy jako encji
@Table(name = "users") // Określenie nazwy tabeli
public class User {

    @Id // Wskazanie pola klucza głównego
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Wskazanie sposobu generowania automatycznej wartości klucza głównego w oparciu o bazę danych
    private Long id;
    @Column(unique = true, nullable = false) // Określenie kolumny login jako unikalnej i wymaganej
    private String login;
    @Column(nullable = false) // Określenie kolumny password jako wymaganej
    private String password;
    @Column(name = "first_name")
    // Określenie nazwy kolumny dla pola firstName (zgodnej z konwencją SQL)
    private String firstName;
    @Column(name = "last_name")
    // Określenie nazwy kolumny dla pola lastName (zgodnej z konwencją SQL)
    private String lastName;

    @ManyToMany // Wskazanie relacji wiele do wielu między użytkownikami, a źródłami wiedzy
    @JoinTable(name = "users_known_sources", // Wskazanie wprost nazwy tabeli mapującej
            joinColumns = @JoinColumn(name = "user_id"), // nazwy kolumny referencji do encji User
            inverseJoinColumns = @JoinColumn(name = "source_id") // oraz nazwy kolumny referencji do encji KnowledgeSource
    )
    private Set<KnowledgeSource> knownSources = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<KnowledgeSource> getKnownSources() {
        return knownSources;
    }

    public void setKnownSources(Set<KnowledgeSource> knownSources) {
        this.knownSources = knownSources;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}