package com.example.tms.controller;

import com.example.tms.service.TransportServiceManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/services")
public class TransportServiceController {

    private final TransportServiceManager transportServiceManager;

    public TransportServiceController(TransportServiceManager transportServiceManager) {
        this.transportServiceManager = transportServiceManager;
    }

    @GetMapping
    public List<TransportServiceResponse> list() {
        return transportServiceManager.getAll();
    }

    @GetMapping("/{id}")
    public TransportServiceResponse get(@PathVariable Long id) {
        return transportServiceManager.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransportServiceResponse create(@RequestBody TransportServiceRequest req) {
        return transportServiceManager.create(req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        transportServiceManager.delete(id);
    }

    // DTOs (чтобы не создавать отдельный пакет)
    public static class TransportServiceRequest {
        public Long busId;
        public Long passengerId;
        public String fromLocation;
        public String toLocation;
        public LocalDateTime departureTime;
    }

    public static class TransportServiceResponse {
        public Long id;
        public Long busId;
        public String busNumber;
        public Long passengerId;
        public String passengerName;
        public String fromLocation;
        public String toLocation;
        public LocalDateTime departureTime;
    }
}
