package com.example.tms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "buses")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberPlate;
    private int capacity;

    public Bus() {}

    public Bus(String numberPlate, int capacity) {
        this.numberPlate = numberPlate;
        this.capacity = capacity;
    }

    public Long getId() { return id; }
    public String getNumberPlate() { return numberPlate; }
    public int getCapacity() { return capacity; }

    public void setId(Long id) { this.id = id; }
    public void setNumberPlate(String numberPlate) { this.numberPlate = numberPlate; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}
