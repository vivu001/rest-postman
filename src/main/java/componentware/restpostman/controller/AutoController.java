package componentware.restpostman.controller;


import componentware.restpostman.model.Auto;
import componentware.restpostman.service.AutoService;
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
    public List<Auto> getAllCars() {
        return this.autoService.getAllCars();
    }

    @GetMapping("autos/{id}")
    public Auto getCar(@PathVariable("id") int id) {
        return this.autoService.getCarById(id);
    }

    @PostMapping("autos")
    public Auto addCar(@RequestBody Auto auto) {
//        return this.autoService.addCar(auto);
        return null;
    }

    @PutMapping("autos/{id}")
    public Auto modifyCar(@PathVariable("id") int id, @RequestBody Auto newAuto) {
        return this.autoService.modifyCar(id, newAuto);
    }


    @DeleteMapping("autos/{id}")
    public Auto deleteCar(@PathVariable("id") int id) {
        return this.autoService.deleteCar(id);
    }

}
