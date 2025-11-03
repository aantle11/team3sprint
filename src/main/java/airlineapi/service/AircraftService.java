package airlineapi.service;

import airlineapi.model.Aircraft;
import airlineapi.repository.AircraftRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftService {
    private final AircraftRepository repo;

    public AircraftService(AircraftRepository repo) {
        this.repo = repo;
    }

    public List<Aircraft> getAll() { return repo.findAll(); }
    public Aircraft getById(Long id) { return repo.findById(id).orElseThrow(); }
    public Aircraft create(Aircraft a) { return repo.save(a); }
    public Aircraft update(Long id, Aircraft details) {
        Aircraft x = getById(id);
        x.setType(details.getType());
        x.setAirlineName(details.getAirlineName());
        x.setNumberOfPassengers(details.getNumberOfPassengers());
        x.setAirports(details.getAirports());
        return repo.save(x);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
