public class RentalSystemService {
	public static void main(String[] args) {
		CarRentalSystem carRentalMain = new CarRentalSystem();
		Car car1 = new Car("C1", "TATA", "Punch", 1000, true);
		Car car2 = new Car("C2", "Toyota", "Innova", 2000, true);
		carRentalMain.addCar(car1);
		carRentalMain.addCar(car2);
		carRentalMain.getMenu();
	}
}
