package componentware.restpostman.controller;

import componentware.restpostman.model.Bestellung;
import componentware.restpostman.service.BestellungService;
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
    public List<Bestellung> getAllBookings() {
        return this.bestellungService.findAllBookings();
    }

    @GetMapping("bestellungen/kunden/{kundeId}")
    public List<Bestellung> getBookingsByCustomer(@PathVariable int kundeId) {
        return this.bestellungService.findAllByKundeId(kundeId);
    }

    @PostMapping("/kunden/{kundeId}/autos/{autoId}/zahlungen/{zahlungId}/bestellungen")
    public Bestellung createBooking(@PathVariable("kundeId") int kundeId,
                                    @PathVariable("autoId") int autoId,
                                    @PathVariable("zahlungId") int zahlungId,
                                    @RequestBody Bestellung bestellung) {
        return this.bestellungService.saveBooking(kundeId, autoId, zahlungId, bestellung);
    }

}
