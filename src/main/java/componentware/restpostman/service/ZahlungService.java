package componentware.restpostman.service;

import componentware.restpostman.model.Zahlung;
import componentware.restpostman.model.Zahlungsart;
import componentware.restpostman.repo.ZahlungRepo;
import componentware.restpostman.repo.ZahlungsartRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZahlungService {

    private final ZahlungRepo zahlungRepo;
    private final ZahlungsartRepo zahlungsartRepo;

    public ZahlungService(ZahlungRepo zahlungRepo, ZahlungsartRepo zahlungsartRepo) {
        this.zahlungRepo = zahlungRepo;
        this.zahlungsartRepo = zahlungsartRepo;
    }

    public List<Zahlung> getAllPayments() {
        return this.zahlungRepo.findAll();
    }

    public Zahlung savePayment(int zahlungsartId, Zahlung zahlung) {
        Zahlungsart zahlungsart = zahlungsartRepo.getById(zahlungsartId);
        zahlung.setZahlungsart(zahlungsart);
        return zahlungRepo.save(zahlung);
    }
}
