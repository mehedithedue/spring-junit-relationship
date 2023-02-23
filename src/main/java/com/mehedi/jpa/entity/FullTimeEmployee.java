package com.mehedi.jpa.entity;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee{

    public FullTimeEmployee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    private double salary;

    public FullTimeEmployee() {

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
