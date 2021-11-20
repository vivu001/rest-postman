package componentware.restpostman.controller;


import componentware.restpostman.model.Auto;
import componentware.restpostman.service.AutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class AutoController {

    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping("autos")
    public ResponseEntity<List<Auto>> getAllCars() {
        return new ResponseEntity<>(this.autoService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("autos/{hersteller}")
    public ResponseEntity<List<Auto>> getCar(@PathVariable("hersteller") String hersteller) {
        return new ResponseEntity<>(this.autoService.getCarByHersteller(hersteller), HttpStatus.OK);
    }

    @PostMapping("autos")
    public ResponseEntity<Auto> addCar(@RequestBody Auto auto) {
        return new ResponseEntity<>(this.autoService.addCar(auto), HttpStatus.CREATED);
    }

    @PutMapping("autos/{id}")
    public ResponseEntity<Auto> modifyCar(@PathVariable("id") int id, @RequestBody Auto newAuto) {
        return new ResponseEntity<>(this.autoService.modifyCar(id, newAuto), HttpStatus.OK);
    }

    @DeleteMapping("autos/{id}")
    public ResponseEntity<Auto> deleteCar(@PathVariable("id") int id) {
        return new ResponseEntity<>(this.autoService.deleteCar(id), HttpStatus.OK);
    }

}
