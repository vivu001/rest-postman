package componentware.restpostman.service;

import componentware.restpostman.model.Kunde;
import componentware.restpostman.repo.KundeRepo;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
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
        return kundeRepo.findAllByNachnameIgnoreCase(nachname);
    }

    public Kunde createCustomer(Kunde kunde) {
        return kundeRepo.save(kunde);
    }

    public Kunde changeCustomer(int id, Kunde kunde) {
        Kunde toChangeCustomer = this.kundeRepo.findById(id).orElseThrow(() -> new InvalidParameterException("Der Kunde mit id " + id + " existiert nicht."));

        toChangeCustomer.setNachname(kunde.getNachname());
        toChangeCustomer.setVorname(kunde.getVorname());
        toChangeCustomer.setEmail(kunde.getEmail());
        toChangeCustomer.setGeburtsdatum(kunde.getGeburtsdatum());

        return this.kundeRepo.save(toChangeCustomer);
    }

    public Kunde deleteCustomer(int id) {
        Kunde toDeleteCustomer = this.kundeRepo.findById(id).orElseThrow(() -> new InvalidParameterException("Der Kunde mit id " + id + " existiert nicht."));
        this.kundeRepo.delete(toDeleteCustomer);

        return toDeleteCustomer;
    }
}
