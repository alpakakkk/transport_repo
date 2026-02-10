package com.example.tms.service;

import com.example.tms.controller.ApiNotFoundException;
import com.example.tms.entity.Passenger;
import com.example.tms.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<Passenger> getAll() {
        return passengerRepository.findAll();
    }

    public Passenger getById(Long id) {
        return passengerRepository.findById(id)
                .orElseThrow(() -> new ApiNotFoundException("Passenger not found: " + id));
    }

    public Passenger create(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger update(Long id, Passenger body) {
        Passenger existing = getById(id);
        existing.setFullName(body.getFullName());
        return passengerRepository.save(existing);
    }

    public void delete(Long id) {
        if (!passengerRepository.existsById(id)) {
            throw new ApiNotFoundException("Passenger not found: " + id);
        }
        passengerRepository.deleteById(id);
    }
}
