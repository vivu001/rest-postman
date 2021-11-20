package componentware.restpostman.controller;

import componentware.restpostman.model.Bestellung;
import componentware.restpostman.service.BestellungService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class BestellungController {

    private final BestellungService bestellungService;

    public BestellungController(BestellungService bestellungService) {
        this.bestellungService = bestellungService;
    }

    @GetMapping("bestellungen")
    public ResponseEntity<List<Bestellung>> getAllBookings() {
        return new ResponseEntity<>(this.bestellungService.findAllBookings(), HttpStatus.OK);
    }

    @GetMapping("bestellungen/kunden/{kundeId}")
    public ResponseEntity<List<Bestellung>> getBookingsByCustomer(@PathVariable int kundeId) {
        return new ResponseEntity<>(this.bestellungService.findAllByKundeId(kundeId), HttpStatus.OK);
    }

    @PostMapping("/kunden/{kundeId}/autos/{autoId}/zahlungen/{zahlungId}/bestellungen")
    public ResponseEntity<Bestellung> createBooking(@PathVariable("kundeId") int kundeId,
                                    @PathVariable("autoId") int autoId,
                                    @PathVariable("zahlungId") int zahlungId,
                                    @RequestBody Bestellung bestellung) {
        return new ResponseEntity<>(this.bestellungService.saveBooking(kundeId, autoId, zahlungId, bestellung), HttpStatus.CREATED);
    }

    @PutMapping("/kunden/{kundeId}/autos/{autoId}/zahlungen/{zahlungId}/bestellungen")
    public ResponseEntity<Bestellung> modifyBooking(@PathVariable("kundeId") int kundeId,
                                    @PathVariable("autoId") int autoId,
                                    @PathVariable("zahlungId") int zahlungId,
                                    @RequestBody Bestellung bestellung) {
        return new ResponseEntity<>(this.bestellungService.changeBooking(kundeId, autoId, zahlungId, bestellung), HttpStatus.OK);
    }

    @DeleteMapping("/kunden/{kundeId}/autos/{autoId}/zahlungen/{zahlungId}/bestellungen")
    public ResponseEntity<Bestellung> deleteBooking(@PathVariable("kundeId") int kundeId,
                                    @PathVariable("autoId") int autoId,
                                    @PathVariable("zahlungId") int zahlungId) {
        return new ResponseEntity<>(this.bestellungService.deleteBooking(kundeId, autoId, zahlungId), HttpStatus.OK);
    }


}
