package com.example.tms.controller;

import com.example.tms.entity.Bus;
import com.example.tms.service.TransportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    private final TransportService service;

    public BusController(TransportService service) {
        this.service = service;
    }

    @PostMapping
    public Bus create(@RequestBody Bus bus) {
        return service.createBus(bus);
    }

    @GetMapping
    public List<Bus> getAll() {
        return service.getAllBuses();
    }

    @PutMapping("/{id}")
    public Bus update(@PathVariable Long id, @RequestBody Bus bus) {
        return service.updateBus(id, bus);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteBus(id);
        return "Bus deleted: " + id;
    }
}
