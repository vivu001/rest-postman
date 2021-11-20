package componentware.restpostman.controller;

import componentware.restpostman.model.Zahlung;
import componentware.restpostman.model.Zahlungsart;
import componentware.restpostman.repo.ZahlungsartRepo;
import componentware.restpostman.service.ZahlungService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
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
    public ResponseEntity<List<Zahlung>> getPayments() {
        return new ResponseEntity<>(this.zahlungService.getAllPayments(), HttpStatus.OK);
    }

//    @GetMapping("zahlungen/{bestellungId}")
//    public List<Zahlung> getPaymentOfBooking(int bestellungId) {
//        return this.zahlungRepo.findAll();
//    }

    @PostMapping("zahlungsarten/{id}/zahlungen")
    public ResponseEntity<Zahlung> createPayment(@PathVariable("id") int zahlungsartId, @RequestBody Zahlung zahlung) {
        return new ResponseEntity<>(this.zahlungService.savePayment(zahlungsartId, zahlung), HttpStatus.CREATED);
    }

    @PutMapping("zahlungsarten/{zahlungsartId}/zahlungen/{zahlungId}")
    public ResponseEntity<Zahlung> modifyPayment(@PathVariable("zahlungsartId") int zahlungsartId,
                                 @PathVariable("zahlungId") int zahlungId,
                                 @RequestBody Zahlung zahlung) {
        return new ResponseEntity<>(this.zahlungService.changePayment(zahlungsartId, zahlungId, zahlung), HttpStatus.OK);
    }

    @DeleteMapping("zahlungen/{id}")
    public ResponseEntity<Zahlung> deletePayment(@PathVariable int id) {
        return new ResponseEntity<>(this.zahlungService.deletePayment(id), HttpStatus.OK);
    }

    @GetMapping("zahlungsarten")
    public ResponseEntity<List<Zahlungsart>> getAllPaymentMethods() {
        return new ResponseEntity<>(this.zahlungsartRepo.findAll(), HttpStatus.OK);
    }

    @PostMapping("zahlungsarten")
    public ResponseEntity<Zahlungsart> createPaymentMethod(@RequestBody Zahlungsart zahlungsart) {
        return new ResponseEntity<>(this.zahlungsartRepo.save(zahlungsart), HttpStatus.CREATED);
    }

    @DeleteMapping("zahlungsarten/{id}")
    public ResponseEntity<Zahlungsart> deletePaymentMethod(@PathVariable int id) {
        Zahlungsart toDeletePaymentMethod = this.zahlungsartRepo.findById(id)
                .orElseThrow(() -> new InvalidParameterException("Die Zahlungsart mit id " + id + " existiert nicht."));
        this.zahlungsartRepo.deleteById(id);
        return new ResponseEntity<>(toDeletePaymentMethod, HttpStatus.OK);
    }
}
