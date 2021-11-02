package componentware.restpostman.controller;

import componentware.restpostman.model.Zahlung;
import componentware.restpostman.model.Zahlungsart;
import componentware.restpostman.repo.ZahlungRepo;
import componentware.restpostman.repo.ZahlungsartRepo;
import componentware.restpostman.service.ZahlungService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ZahlungController {

    private final ZahlungService zahlungService;
    private final ZahlungsartRepo zahlungsartRepo;

    public ZahlungController(ZahlungService zahlungService, ZahlungsartRepo zahlungsartRepo) {
        this.zahlungService = zahlungService;
        this.zahlungsartRepo = zahlungsartRepo;
    }

    @GetMapping("zahlungen")
    public List<Zahlung> getPayments() {
        return this.zahlungService.getAllPayments();
    }

//    @GetMapping("zahlungen/{bestellungId}")
//    public List<Zahlung> getPaymentOfBooking(int bestellungId) {
//        return this.zahlungRepo.findAll();
//    }

    @PostMapping("zahlungsarten/{id}/zahlungen")
    public Zahlung createPayment(@PathVariable("id") int zahlungsartId,@RequestBody Zahlung zahlung) {
        return this.zahlungService.savePayment(zahlungsartId, zahlung);
    }

    @GetMapping("zahlungsarten")
    public List<Zahlungsart> getAllCustomers() {
        return this.zahlungsartRepo.findAll();
    }

    @PostMapping("zahlungsarten")
    public Zahlungsart createPayment(@RequestBody Zahlungsart zahlungsart) {
        return this.zahlungsartRepo.save(zahlungsart);
    }
}
