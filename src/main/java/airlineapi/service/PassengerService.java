package airlineapi.service;

import airlineapi.model.Passenger;
import airlineapi.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    private final PassengerRepository repo;

    public PassengerService(PassengerRepository repo) {
        this.repo = repo;
    }

    public List<Passenger> getAll() { return repo.findAll(); }
    public Passenger getById(Long id) { return repo.findById(id).orElseThrow(); }
    public Passenger create(Passenger p) { return repo.save(p); }
    public Passenger update(Long id, Passenger details) {
        Passenger x = getById(id);
        x.setFirstName(details.getFirstName());
        x.setLastName(details.getLastName());
        x.setPhoneNumber(details.getPhoneNumber());
        x.setCity(details.getCity());
        x.setAircraft(details.getAircraft());
        return repo.save(x);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
