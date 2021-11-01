package componentware.restpostman.controller;

import componentware.restpostman.model.Kunde;
import componentware.restpostman.service.KundeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class KundeController {

    private final KundeService kundeService;

    public KundeController(KundeService kundeService) {
        this.kundeService = kundeService;
    }

    @GetMapping("kunden")
    public List<Kunde> getAllCustomers() {
        return this.kundeService.getAllCustomers();
    }

    @GetMapping("kunden/{nachname}")
    public List<Kunde> getCustomer(@PathVariable("nachname") String nachname) {
        return this.kundeService.getCustomerByLastName(nachname);
    }

    @PostMapping("kunden")
    public Kunde createCustomer(@RequestBody Kunde kunde) {
        return this.kundeService.createCustomer(kunde);
    }
}
