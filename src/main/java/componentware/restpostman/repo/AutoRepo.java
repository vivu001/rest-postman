package componentware.restpostman.repo;

import componentware.restpostman.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutoRepo extends JpaRepository<Auto, Integer> {
    List<Auto> getAllByHerstellerIgnoreCase(String hersteller);

    Optional<Auto> findByHerstellerIgnoreCaseAndModelIgnoreCaseAndSitzplaetzen(String hersteller, String model, int plaetze);
}

