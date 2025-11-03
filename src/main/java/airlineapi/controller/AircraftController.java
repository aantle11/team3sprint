package airlineapi.controller;

import airlineapi.model.Aircraft;
import airlineapi.model.Airport;
import airlineapi.service.AircraftService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aircraft")
public class AircraftController {
    private final AircraftService service;

    public AircraftController(AircraftService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aircraft> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Aircraft getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Aircraft create(@RequestBody Aircraft aircraft) { return service.create(aircraft); }

    @PutMapping("/{id}")
    public Aircraft update(@PathVariable Long id, @RequestBody Aircraft details) { return service.update(id, details); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    // Q3: What airports do aircraft take off from and land at?
    @GetMapping("/{id}/airports")
    public List<Airport> airportsForAircraft(@PathVariable Long id) {
        return service.getById(id).getAirports();
    }
}
