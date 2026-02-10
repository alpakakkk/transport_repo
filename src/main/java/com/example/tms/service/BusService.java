package com.example.tms.service;

import com.example.tms.controller.ApiNotFoundException;
import com.example.tms.entity.Bus;
import com.example.tms.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {

    private final BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public List<Bus> getAll() {
        return busRepository.findAll();
    }

    public Bus getById(Long id) {
        return busRepository.findById(id)
                .orElseThrow(() -> new ApiNotFoundException("Bus not found: " + id));
    }

    public Bus create(Bus bus) {
        return busRepository.save(bus);
    }

    public Bus update(Long id, Bus body) {
        Bus existing = getById(id);
        existing.setBusNumber(body.getBusNumber());
        existing.setCapacity(body.getCapacity());
        return busRepository.save(existing);
    }

    public void delete(Long id) {
        if (!busRepository.existsById(id)) {
            throw new ApiNotFoundException("Bus not found: " + id);
        }
        busRepository.deleteById(id);
    }
}
