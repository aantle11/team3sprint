package airlineapi.controller;

import airlineapi.model.Airport;
import airlineapi.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {
    private final AirportService service;

    public AirportController(AirportService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airport> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Airport getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Airport create(@RequestBody Airport airport) { return service.create(airport); }

    @PutMapping("/{id}")
    public Airport update(@PathVariable Long id, @RequestBody Airport details) { return service.update(id, details); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
