package airlineapi.controller;

import airlineapi.model.Aircraft;
import airlineapi.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aircrafts")
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    // Get all aircraft
    @GetMapping
    public List<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    // Get aircraft by ID
    @GetMapping("/{id}")
    public Aircraft getAircraftById(@PathVariable Long id) {
        return aircraftService.getAircraftById(id);
    }

    // Create a new aircraft
    @PostMapping
    public Aircraft createAircraft(@RequestBody Aircraft aircraft) {
        return aircraftService.createAircraft(aircraft);
    }

    // Update existing aircraft
    @PutMapping("/{id}")
    public Aircraft updateAircraft(@PathVariable Long id, @RequestBody Aircraft aircraftDetails) {
        return aircraftService.updateAircraft(id, aircraftDetails);
    }

    // Delete aircraft
    @DeleteMapping("/{id}")
    public void deleteAircraft(@PathVariable Long id) {
        aircraftService.deleteAircraft(id);
    }
}