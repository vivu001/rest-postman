package componentware.restpostman.service;

import componentware.restpostman.model.Auto;
import componentware.restpostman.repo.AutoRepo;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class AutoService {

    private final AutoRepo autoRepo;

    public AutoService(AutoRepo autoRepo) {
        this.autoRepo = autoRepo;
    }

    public List<Auto> getAllCars() {
        return this.autoRepo.findAll();
    }

    public Auto getCarById(int id) {
        return this.autoRepo.findById(id).orElse(null);
    }

//    public Auto addCar(Auto auto) {
//        this.autoRepo.findById(auto.id).orElseThrow(() -> new InvalidParameterException("Es existiert kein Auto mit ID " + id));
//        return this.autoRepo.save(auto);
//    }

    public Auto modifyCar(int id, Auto newAuto) {
        this.autoRepo.findById(id).orElseThrow(() -> new InvalidParameterException("Es existiert kein Auto mit ID " + id));
        this.autoRepo.delete(newAuto);
        return newAuto;
    }

    public Auto deleteCar(int id) {
        Auto auto = this.autoRepo.findById(id).orElseThrow(() -> new InvalidParameterException("Es existiert kein Auto mit ID " + id));
        this.autoRepo.delete(auto);
        return auto;
    }


}
