package AirlineApi.service;

import AirlineApi.model.Aircraft;
import AirlineApi.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    public List<Aircraft> getAllAircraft() {
        return aircraftRepository.findAll();
    }

    public Optional<Aircraft> getAircraftById(Long id) {
        return aircraftRepository.findById(id);
    }

    public Aircraft addAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    public Aircraft updateAircraft(Long id, Aircraft details) {
        Aircraft aircraft = aircraftRepository.findById(id).orElseThrow();
        aircraft.setType(details.getType());
        aircraft.setAirlineName(details.getAirlineName());
        aircraft.setNumberOfPassengers(details.getNumberOfPassengers());
        return aircraftRepository.save(aircraft);
    }

    public void deleteAircraft(Long id) {
        aircraftRepository.deleteById(id);
    }
}

