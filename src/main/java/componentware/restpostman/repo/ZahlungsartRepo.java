package componentware.restpostman.repo;

import componentware.restpostman.model.Zahlungsart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZahlungsartRepo extends JpaRepository<Zahlungsart, Integer> {
}
