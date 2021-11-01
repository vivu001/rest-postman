package componentware.restpostman.repo;

import componentware.restpostman.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepo extends JpaRepository<Auto, Integer> {
}
