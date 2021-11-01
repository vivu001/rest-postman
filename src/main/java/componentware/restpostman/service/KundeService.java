package componentware.restpostman.service;

import componentware.restpostman.model.Kunde;
import componentware.restpostman.repo.KundeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KundeService {

    private final KundeRepo kundeRepo;

    public KundeService(KundeRepo kundeRepo) {
        this.kundeRepo = kundeRepo;
    }

    public List<Kunde> getAllCustomers() {
        return kundeRepo.findAll();
    }

    public List<Kunde> getCustomerByLastName(String nachname) {
        return kundeRepo.findAllByNachname(nachname);
    }

    public Kunde createCustomer(Kunde kunde) {
        return kundeRepo.save(kunde);
    }
}
