package airlineapi.service;

import airlineapi.model.Airport;
import airlineapi.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    private final AirportRepository repo;

    public AirportService(AirportRepository repo) {
        this.repo = repo;
    }

    public List<Airport> getAll() { return repo.findAll(); }
    public Airport getById(Long id) { return repo.findById(id).orElseThrow(); }
    public Airport create(Airport a) { return repo.save(a); }
    public Airport update(Long id, Airport details) {
        Airport x = getById(id);
        x.setName(details.getName());
        x.setCode(details.getCode());
        x.setCity(details.getCity());
        x.setAircraft(details.getAircraft());
        return repo.save(x);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
