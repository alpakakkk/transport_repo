package com.example.tms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    public Passenger() {}

    public Passenger(String fullName, Bus bus) {
        this.fullName = fullName;
        this.bus = bus;
    }

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public Bus getBus() { return bus; }

    public void setId(Long id) { this.id = id; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setBus(Bus bus) { this.bus = bus; }
}
