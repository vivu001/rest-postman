package componentware.restpostman.service;

import componentware.restpostman.model.Auto;
import componentware.restpostman.repo.AutoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService {

    private final AutoRepo autoRepo;

    public AutoService(AutoRepo autoRepo) {
        this.autoRepo = autoRepo;
    }

    public List<Auto> getAllAutos() {
        return this.autoRepo.findAll();
    }

    public Auto getAutoById(int id) {
        return this.autoRepo.findById(id).orElse(null);
    }

    public Auto addAuto(Auto auto) {
        return this.autoRepo.save(auto);
    }
}
