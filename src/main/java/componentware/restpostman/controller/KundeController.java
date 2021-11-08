package componentware.restpostman.controller;

import componentware.restpostman.model.Kunde;
import componentware.restpostman.service.KundeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Kunde>> getAllCustomers() {
        return new ResponseEntity<>(this.kundeService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("kunden/{nachname}")
    public ResponseEntity<List<Kunde>> getCustomers(@PathVariable("nachname") String nachname) {
        return new ResponseEntity<>(this.kundeService.getCustomerByLastName(nachname), HttpStatus.OK);
    }

    @PostMapping("kunden")
    public ResponseEntity<Kunde> createCustomer(@RequestBody Kunde kunde) {
        return new ResponseEntity<>(this.kundeService.createCustomer(kunde), HttpStatus.CREATED);
    }

    @PutMapping("kunden/{id}")
    public ResponseEntity<Kunde> modifyCustomer(@PathVariable int id, @RequestBody Kunde kunde) {
        return new ResponseEntity<>(this.kundeService.changeCustomer(id, kunde), HttpStatus.OK);
    }

    @DeleteMapping("kunden/{id}")
    public ResponseEntity<Kunde> deleteCustomer(@PathVariable int id) {
        return new ResponseEntity<>(this.kundeService.deleteCustomer(id), HttpStatus.OK);
    }
}
