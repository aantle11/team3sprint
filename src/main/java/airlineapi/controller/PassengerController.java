package airlineapi.controller;

import airlineapi.model.Aircraft;
import airlineapi.model.Airport;
import airlineapi.model.Passenger;
import airlineapi.service.PassengerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {
    private final PassengerService service;

    public PassengerController(PassengerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Passenger> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Passenger getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Passenger create(@RequestBody Passenger passenger) { return service.create(passenger); }

    @PutMapping("/{id}")
    public Passenger update(@PathVariable Long id, @RequestBody Passenger details) { return service.update(id, details); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    // Q2: What aircraft has each passenger flown on?
    @GetMapping("/{id}/aircraft")
    public List<Aircraft> aircraftForPassenger(@PathVariable Long id) {
        return service.getById(id).getAircraft();
    }

    // Q4: What airports have passengers used?
    @GetMapping("/{id}/airports")
    public Set<Airport> airportsUsedByPassenger(@PathVariable Long id) {
        Passenger p = service.getById(id);
        return p.getAircraft().stream()
                .flatMap(a -> a.getAirports().stream())
                .collect(Collectors.toSet());
    }
}
