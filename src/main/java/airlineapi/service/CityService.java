package airlineapi.service;

import airlineapi.model.City;
import airlineapi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    // Get all cities
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    // Get city by ID (unwrap Optional)
    public City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found with id " + id));
    }

    // Create new city
    public City createCity(City city) {
        return cityRepository.save(city);
    }

    // Update city
    public City updateCity(Long id, City details) {
        City city = getCityById(id); // reuse method above
        city.setName(details.getName());
        city.setCountry(details.getCountry());
        return cityRepository.save(city);
    }

    // Delete city
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}