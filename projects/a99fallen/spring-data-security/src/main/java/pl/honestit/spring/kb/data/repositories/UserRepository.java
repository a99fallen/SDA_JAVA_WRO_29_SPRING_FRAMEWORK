package pl.honestit.spring.kb.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import pl.honestit.spring.kb.data.model.User;

import java.util.Optional;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    User getUserByLoginAndPassword(String login, String password);
}
