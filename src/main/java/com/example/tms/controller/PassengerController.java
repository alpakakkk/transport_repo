<<<<<<< HEAD
package com.example.tms.controller;

import com.example.tms.entity.Passenger;
import com.example.tms.service.TransportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    private final TransportService service;

    public PassengerController(TransportService service) {
        this.service = service;
    }

    // request body для создания/обновления пассажира
    public static class PassengerRequest {
        public String fullName;
        public Long busId;
    }

    @PostMapping
    public Passenger create(@RequestBody PassengerRequest req) {
        return service.createPassenger(req.fullName, req.busId);
    }

    @GetMapping
    public List<Passenger> getAll() {
        return service.getAllPassengers();
    }

    @PutMapping("/{id}")
    public Passenger update(@PathVariable Long id, @RequestBody PassengerRequest req) {
        return service.updatePassenger(id, req.fullName, req.busId);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deletePassenger(id);
        return "Passenger deleted: " + id;
    }
=======
package com.example.transport.controller;

public class PassengerController {
>>>>>>> edf3098242461726d6e47f864ae7dc1a0d1bba05
}
