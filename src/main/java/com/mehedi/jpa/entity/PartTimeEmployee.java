package com.mehedi.jpa.entity;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee{

    private double hourlyRate;

    public PartTimeEmployee(String name, double hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
    }

    public PartTimeEmployee() {
    }
}
