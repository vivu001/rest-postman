package componentware.restpostman.service;

import componentware.restpostman.model.Zahlung;
import componentware.restpostman.model.Zahlungsart;
import componentware.restpostman.repo.ZahlungRepo;
import componentware.restpostman.repo.ZahlungsartRepo;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
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

    public Zahlung deletePayment(int id) {
        Zahlung toDeleteZahlung = this.zahlungRepo.findById(id).orElseThrow(() -> new InvalidParameterException("Die Zahlung mit id " + id + " existiert nicht."));
        this.zahlungRepo.delete(toDeleteZahlung);

        return toDeleteZahlung;
    }

    public Zahlung changePayment(int zahlungsartId, int zahlungId, Zahlung zahlung) {
        Zahlungsart paymentMethod = this.zahlungsartRepo.findById(zahlungsartId).orElseThrow(() -> new InvalidParameterException("Die Zahlungsart mit id " + zahlungsartId + " existiert nicht."));
        Zahlung toChangePayment = this.zahlungRepo.findById(zahlungId).orElseThrow(() -> new InvalidParameterException("Die Zahlung mit id " + zahlungId + " existiert nicht."));

        toChangePayment.setBetrag(zahlung.getBetrag());
        toChangePayment.setBezahlt(zahlung.isBezahlt());
        toChangePayment.setZahlungsart(paymentMethod);

        return this.zahlungRepo.save(toChangePayment);
    }
}
