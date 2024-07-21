* The Car class represents a car in the rental system, with properties such as make, model, year, license plate number, rental price per day, and availability status.
* The Customer class represents a customer, with properties like name, contact information, and driver's license number.
* The Reservation class represents a reservation made by a customer for a specific car and date range. It includes properties such as reservation ID, customer, car, start date, end date, and total price.
* The PaymentProcessor interface defines the contract for payment processing, and the CreditCardPaymentProcessor and PayPalPaymentProcessor classes are concrete implementations of the payment processor.
* The RentalSystem class is the core of the car rental system and follows the Singleton pattern to ensure a single instance of the rental system.
* The RentalSystem class uses concurrent data structures (ConcurrentHashMap) to handle concurrent access to cars and reservations.
* The RentalSystem class provides methods for adding and removing cars, searching for available cars based on criteria, making reservations, canceling reservations, and processing payments.
* The CarRentalSystem class serves as the entry point of the application and demonstrates the usage of the car rental system.
* Covered OOPS Inheritance, Polymorphism, Encapsulation, and Abstraction.
