package componentware.restpostman.repo;

import componentware.restpostman.model.Bestellung;
import componentware.restpostman.model.BestellungId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BestellungRepo extends JpaRepository<Bestellung, BestellungId> {
    List<Bestellung> findAllByBestellungId_Kunde_Id(int id);
}
