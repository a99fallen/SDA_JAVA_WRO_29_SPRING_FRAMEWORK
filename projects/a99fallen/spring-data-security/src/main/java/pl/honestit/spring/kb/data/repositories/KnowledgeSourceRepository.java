package pl.honestit.spring.kb.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pl.honestit.spring.kb.data.model.KnowledgeSource;

@Component
public interface KnowledgeSourceRepository extends JpaRepository<KnowledgeSource, Long> {
}
