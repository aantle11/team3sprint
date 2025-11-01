package AirlineApi.service;

import AirlineApi.model.Passenger;
import AirlineApi.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Optional<Passenger> getPassengerById(Long id) {
        return passengerRepository.findById(id);
    }

    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger details) {
        Passenger passenger = passengerRepository.findById(id).orElseThrow();
        passenger.setFirstName(details.getFirstName());
        passenger.setLastName(details.getLastName());
        passenger.setPhoneNumber(details.getPhoneNumber());
        passenger.setCity(details.getCity());
        return passengerRepository.save(passenger);
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
