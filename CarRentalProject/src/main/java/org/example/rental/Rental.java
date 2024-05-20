package org.example.rental;

import org.example.car.Car;
import org.example.customer.Customer;

public class Rental {
	public Rental(Car car, Customer customer, int days) {
		this.car = car;
		this.customer = customer;
		this.days = days;
	}

	private Car car;
	private Customer customer;
	private int days;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
}
