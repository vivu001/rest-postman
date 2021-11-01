package componentware.restpostman.service;

import componentware.restpostman.model.*;
import componentware.restpostman.repo.AutoRepo;
import componentware.restpostman.repo.BestellungRepo;
import componentware.restpostman.repo.KundeRepo;
import componentware.restpostman.repo.ZahlungRepo;
import org.springframework.stereotype.Service;

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
        Kunde kunde = this.kundeRepo.getById(kundeId);
        Auto auto = this.autoRepo.getById(autoId);
        Zahlung zahlung = this.zahlungRepo.getById(zahlungId);

        BestellungId bestellungId = new BestellungId(kunde, auto, zahlung);
        bestellung.setBestellungId(bestellungId);

        return this.bestellungRepo.save(bestellung);
    }
}
