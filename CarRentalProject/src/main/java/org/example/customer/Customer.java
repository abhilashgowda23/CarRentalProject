package org.example.customer;

public class Customer {
	private String customerID;
	private String name;

	public Customer(String customerID, String name) {
		this.customerID = customerID;
		this.name = name;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void rentCar(Car car, Customer customer, int days, CarRentalSystem crs) {
		if (car.isAvailable()) {
			car.rent();
			crs.addRental(new Rental(car, customer, days));
			System.out.println("Rented Successfully.. Thank you!!\n");
		} else {
			System.out.println("Car is not Available!!!! Pls try with other vehicle");
		}
	}
}
