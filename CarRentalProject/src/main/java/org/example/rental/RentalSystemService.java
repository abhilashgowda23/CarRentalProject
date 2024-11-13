package org.example.rental;


import org.example.car.Car;
import org.example.customer.Customer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


class CarRentalSystem {
	private List<Car> carList;
	private List<Customer> customerList;
	private List<Rental> rentalList;

	public CarRentalSystem() {
		carList = new ArrayList<>();
		customerList = new ArrayList<>();
		rentalList = new ArrayList<>();
	}

	public void addCar(Car car) {
		carList.add(car);

	}

	public void addCustomer(Customer customer) {
		customerList.add(customer);

	}

	public void addRental(Rental rental) {
		rentalList.add(rental);

	}

	public void returnCar(Car car) {
		car.returnCar();
		Rental rentalToRemove = null;
		for (Rental rental : rentalList) {
			if (rental.getCar().equals(car)) {
				rentalToRemove = rental;
				break;
			}
		}
		if (rentalToRemove != null) {
			rentalList.remove(rentalToRemove);
		} else {
			System.out.println("not rented oops!!");
		}
	}

	public void getMenu() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("****Car Rental Service****\n");
			System.out.println("1. Rent car");
			System.out.println("2. return the car");
			System.out.println("3. Exit");
			System.out.println("Enter your choice : ");
			int choice = 0;
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Enter valid number choice (allows numbers only)");
			}

			scanner.nextLine();
			switch (choice) {

				case 1:
					System.out.println("****Rent a car****");
					System.out.println("Enter your name");
					String customerName = scanner.next();
					System.out.println("***Available cars***");
					System.out.println("-------------------------");
					System.out.println("CarID--Carbrand--Carmodel");
					System.out.println("--------------------------");
					for (Car car : carList) {
						if (car.isAvailable()) {

							System.out.println(car.getCarId() + "--" + car.getBrand() + "--" + car.getModel());
						}
					}
					System.out.println("\nEnter the car ID to rent: ");
					String cardID = scanner.next();

					System.out.println("\nEnter no of days to rent: ");
					int rentDays = 0;
					try {
						rentDays = scanner.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Enter valid number choice (allows numbers only)");
					}

					scanner.nextLine();

					Customer newCustomer = new Customer("C" + (customerList.size() + 1), customerName);
					addCustomer(newCustomer);

					Car selectCar = null;
					for (Car car : carList) {
						if (car.getCarId().equalsIgnoreCase(cardID)) {
							selectCar = car;
						}
					}
					if (selectCar != null) {
						double totalPrice = selectCar.calculatePrice(rentDays);
						System.out.println("***Rental Information***");
						System.out.println("Customer name- " + newCustomer.getName() + "CustomerID- " + newCustomer.getCustomerID());
						System.out.println("Car name " + selectCar.getBrand() + " Model name" + selectCar.getModel());
						System.out.println("Rental days chosen - " + rentDays);
						System.out.println("Total price-" + totalPrice);
						System.out.println("\nPls confirm rental Y/N");
						String confirm = scanner.nextLine();
						if (confirm.equalsIgnoreCase("Y")) {
							rentCar(selectCar, newCustomer, rentDays);
						} else {
							System.out.println("Not Rented... Thank you for checking!!");
						}
					} else {
						System.out.println("\nInvalid car selection");
					}
					break;

				case 2:
					System.out.println("\n***Return Car***\n");
					System.out.println("Enter the Car ID you want to return : ");

					String carID = null;
					try {
						carID = scanner.next();
					} catch (InputMismatchException e) {
						System.out.println("Enter valid characters (allows characters) only)");
					}

					Car carToReturn = null;
					for (Car car : carList) {
						if (car.getCarId().equalsIgnoreCase(carID)) {
							carToReturn = car;
							break;
						}
					}
					if (carToReturn != null) {
						Customer customerTodelete = null;
						for (Rental rental : rentalList) {
							if (rental.getCar() == carToReturn) {
								customerTodelete = rental.getCustomer();
								break;
							}
						}
						if (customerTodelete != null) {
							returnCar(carToReturn);
							System.out.println("Returned successfully " + customerTodelete.getName());
						} else {
							System.out.println("Not Rented");
						}
					} else {
						System.out.println("Inlaid Id");
					}
					break;

				case 3:
					System.exit(1);
				default:
					System.out.println("Invalid choice Retry!!!!!");
			}

		}
	}

}


public class RentalSystemService {
	public static void main(String[] args) {
		CarRentalSystem carRentalMain = new CarRentalSystem();
		Car car1 = new Car("C1", "TATA", "Punch", 1000, true);
		Car car2 = new Car("C2", "Toyota", "Innova", 2000, true);
		Car car3 = new Car("C3", "BMW", "Q3", 10000, true);
		carRentalMain.addCar(car1);
		carRentalMain.addCar(car2);
		carRentalMain.addCar(car3);
		carRentalMain.getMenu();
	}
}
