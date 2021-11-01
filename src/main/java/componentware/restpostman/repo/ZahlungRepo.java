package componentware.restpostman.repo;

import componentware.restpostman.model.Zahlung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZahlungRepo extends JpaRepository<Zahlung, Integer> {
}
