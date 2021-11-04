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

    public List<Auto> getCarByHersteller(String hersteller) {
        return this.autoRepo.getAllByHerstellerIgnoreCase(hersteller);
    }

    public Auto addCar(Auto auto) {
        Auto toAddAuto = this.autoRepo.findByHerstellerIgnoreCaseAndModelIgnoreCaseAndSitzplaetzen(auto.getHersteller(), auto.getModel(), auto.getSitzplaetzen())
                .stream()
                .peek((existingAuto) -> {
                    existingAuto.setAnzahl(existingAuto.getAnzahl() + auto.getAnzahl());
                    existingAuto.setVerfuegbar(existingAuto.getVerfuegbar() + auto.getAnzahl());
                })
                .findFirst()
                .orElse(new Auto(auto.getHersteller(), auto.getModel(), auto.getSitzplaetzen(), auto.getAnzahl()));
        return this.autoRepo.save(toAddAuto);
    }

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
