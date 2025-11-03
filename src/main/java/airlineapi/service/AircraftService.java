package airlineapi.service;

import airlineapi.model.Aircraft;
import airlineapi.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    // Get all aircraft
    public List<Aircraft> getAllAircraft() {
        return aircraftRepository.findAll();
    }

    // Get aircraft by ID (unwraps Optional)
    public Aircraft getAircraftById(Long id) {
        return aircraftRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aircraft not found with id " + id));
    }

    // Create (add) a new aircraft
    public Aircraft createAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    // Update an existing aircraft
    public Aircraft updateAircraft(Long id, Aircraft details) {
        Aircraft aircraft = getAircraftById(id); // reuse method above
        aircraft.setType(details.getType());
        aircraft.setAirlineName(details.getAirlineName());
        aircraft.setNumberOfPassengers(details.getNumberOfPassengers());
        return aircraftRepository.save(aircraft);
    }

    // Delete aircraft
    public void deleteAircraft(Long id) {
        aircraftRepository.deleteById(id);
    }
}