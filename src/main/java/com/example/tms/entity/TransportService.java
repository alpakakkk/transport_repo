package com.example.tms.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transport_services")
public class TransportService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    @Column(nullable = false)
    private String fromLocation;

    @Column(nullable = false)
    private String toLocation;

    @Column(nullable = false)
    private LocalDateTime departureTime;

    public TransportService() {}

    public Long getId() { return id; }
    public Bus getBus() { return bus; }
    public Passenger getPassenger() { return passenger; }
    public String getFromLocation() { return fromLocation; }
    public String getToLocation() { return toLocation; }
    public LocalDateTime getDepartureTime() { return departureTime; }

    public void setId(Long id) { this.id = id; }
    public void setBus(Bus bus) { this.bus = bus; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }
    public void setFromLocation(String fromLocation) { this.fromLocation = fromLocation; }
    public void setToLocation(String toLocation) { this.toLocation = toLocation; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }
}
