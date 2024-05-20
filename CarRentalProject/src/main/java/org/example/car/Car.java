package org.example.car;

public class Car {
	private String carId;
	private String brand;
	private String model;
	private double basePricePerDay;
	private boolean isAvailable;

	public Car(String carId, String brand, String model, double basePricePerDay, boolean isAvailable) {
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.basePricePerDay = basePricePerDay;
		this.isAvailable = true;

	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getBasePricePerDay() {
		return basePricePerDay;
	}

	public void setBasePricePerDay(double basePricePerDay) {
		this.basePricePerDay = basePricePerDay;
	}

	public boolean isAvailablee() {
		return isAvailable;
	}

	public void setAvailable(boolean available) {
		isAvailable = available;
	}

	public double calculatePrice(int rentaldays) {
		return basePricePerDay * rentaldays;
	}

	public void rent() {
		isAvailable = false;
	}

	public void returnCar() {
		isAvailable = true;
	}

	public boolean isAvailable() {
		return isAvailable;
	}


}
