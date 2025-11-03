package airlineapi.service;

import airlineapi.model.City;
import airlineapi.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository repo;

    public CityService(CityRepository repo) {
        this.repo = repo;
    }

    public List<City> getAll() { return repo.findAll(); }
    public City getById(Long id) { return repo.findById(id).orElseThrow(); }
    public City create(City c) { return repo.save(c); }
    public City update(Long id, City details) {
        City x = getById(id);
        x.setName(details.getName());
        x.setState(details.getState());
        x.setPopulation(details.getPopulation());
        return repo.save(x);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
