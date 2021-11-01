package componentware.restpostman.repo;

import componentware.restpostman.model.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KundeRepo extends JpaRepository<Kunde, Integer> {
    List<Kunde> findAllByNachname(String nachname);
}
