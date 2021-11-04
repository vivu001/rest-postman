package componentware.restpostman.service;

import componentware.restpostman.model.*;
import componentware.restpostman.repo.AutoRepo;
import componentware.restpostman.repo.BestellungRepo;
import componentware.restpostman.repo.KundeRepo;
import componentware.restpostman.repo.ZahlungRepo;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class BestellungService {

    private final BestellungRepo bestellungRepo;
    private final KundeRepo kundeRepo;
    private final AutoRepo autoRepo;
    private final ZahlungRepo zahlungRepo;

    public BestellungService(BestellungRepo bestellungRepo,
                             KundeRepo kundeRepo,
                             AutoRepo autoRepo,
                             ZahlungRepo zahlungRepo) {
        this.bestellungRepo = bestellungRepo;
        this.kundeRepo = kundeRepo;
        this.autoRepo = autoRepo;
        this.zahlungRepo = zahlungRepo;
    }

    public List<Bestellung> findAllBookings() {
        return this.bestellungRepo.findAll();
    }

    public List<Bestellung> findAllByKundeId(int id) {
        return this.bestellungRepo.findAllByBestellungId_Kunde_Id(id);
    }

    public Bestellung saveBooking(int kundeId, int autoId, int zahlungId, Bestellung bestellung) {
        bestellung.setBestellungId(mapBestellungId(kundeId, autoId, zahlungId));
        return this.bestellungRepo.save(bestellung);
    }

    public Bestellung changeBooking(int kundeId, int autoId, int zahlungId, Bestellung bestellung) {
        Bestellung existierteBestellung = this.bestellungRepo.findById(mapBestellungId(kundeId, autoId, zahlungId))
                .orElseThrow(() -> new InvalidParameterException("Die Bestellung existiert nicht."));

        existierteBestellung.setDauer(bestellung.getDauer());
        existierteBestellung.setStartdatum(bestellung.getStartdatum());

        return this.bestellungRepo.save(existierteBestellung);
    }

    public Bestellung deleteBooking(int kundeId, int autoId, int zahlungId) {

        Bestellung toDeleteBestellung = this.bestellungRepo.findById(mapBestellungId(kundeId, autoId, zahlungId))
                .orElseThrow(() -> new InvalidParameterException("Die Bestellung existiert nicht."));

        this.bestellungRepo.delete(toDeleteBestellung);
        return toDeleteBestellung;
    }

    private BestellungId mapBestellungId(int kundeId, int autoId, int zahlungId) {
        Kunde kunde = this.kundeRepo.getById(kundeId);
        Auto auto = this.autoRepo.getById(autoId);
        Zahlung zahlung = this.zahlungRepo.getById(zahlungId);

        return new BestellungId(kunde, auto, zahlung);
    }
}
