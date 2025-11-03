package airlineapi.controller;

import airlineapi.model.Airport;
import airlineapi.model.City;
import airlineapi.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    private final CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping
    public List<City> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public City getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public City create(@RequestBody City city) { return service.create(city); }

    @PutMapping("/{id}")
    public City update(@PathVariable Long id, @RequestBody City details) { return service.update(id, details); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    // Q1: What airports are there in each city?
    @GetMapping("/{id}/airports")
    public List<Airport> airportsInCity(@PathVariable Long id) {
        return service.getById(id).getAirports();
    }
}
