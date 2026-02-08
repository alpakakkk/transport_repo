package com.example.tms.service;

import com.example.tms.entity.Bus;
import com.example.tms.entity.Passenger;
import com.example.tms.repository.BusRepository;
import com.example.tms.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportService {

    private final BusRepository busRepository;
    private final PassengerRepository passengerRepository;

    public TransportService(BusRepository busRepository, PassengerRepository passengerRepository) {
        this.busRepository = busRepository;
        this.passengerRepository = passengerRepository;
    }

    // BUS CRUD
    public Bus createBus(Bus bus) {
        return busRepository.save(bus);
    }

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public Bus updateBus(Long id, Bus newData) {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus not found: " + id));
        bus.setNumberPlate(newData.getNumberPlate());
        bus.setCapacity(newData.getCapacity());
        return busRepository.save(bus);
    }

    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }

    // PASSENGER CRUD
    public Passenger createPassenger(String fullName, Long busId) {
        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new RuntimeException("Bus not found: " + busId));
        Passenger p = new Passenger(fullName, bus);
        return passengerRepository.save(p);
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger updatePassenger(Long id, String fullName, Long busId) {
        Passenger p = passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found: " + id));

        p.setFullName(fullName);

        if (busId != null) {
            Bus bus = busRepository.findById(busId)
                    .orElseThrow(() -> new RuntimeException("Bus not found: " + busId));
            p.setBus(bus);
        }

        return passengerRepository.save(p);
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
