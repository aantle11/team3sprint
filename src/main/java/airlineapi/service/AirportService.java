package airlineapi.service;

import airlineapi.model.Airport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportService {
    private final List<Airport> airports = new ArrayList<>();

    public List<Airport> getAllAirports() {
        return airports;
    }

    public Airport getAirportById(Long id) {
        return airports.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Airport addAirport(Airport airport) {
        airports.add(airport);
        return airport;
    }

    public Airport updateAirport(Long id, Airport updated) {
        for (int i = 0; i < airports.size(); i++) {
            if (airports.get(i).getId().equals(id)) {
                airports.set(i, updated);
                return updated;
            }
        }
        return null;
    }

    public void deleteAirport(Long id) {
        airports.removeIf(a -> a.getId().equals(id));
    }
}