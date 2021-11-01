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
    public List<Auto> getAllAutos() {
        return this.autoService.getAllAutos();
    }

    @GetMapping("autos/{id}")
    public Auto getAuto(@PathVariable("id") int id) {
        return this.autoService.getAutoById(id);
    }

    @PostMapping("autos")
    public Auto addAuto(@RequestBody Auto auto) {
        return this.autoService.addAuto(auto);
    }
}
