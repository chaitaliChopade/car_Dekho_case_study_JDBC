package carDekho_JDBC.operation;

import java.util.List;
import java.util.Scanner;



public class CarMain {
  
	public static void main(String[] args) {
		CarJDBC jdbc=new CarJDBC();
		Scanner scanner=new Scanner(System.in);
		System.out.println("============Car_Dekho==============="
				+ "\nWelcome to Car_Dekho Application"
				+ "\nEnter 1 to Get Menu Card"
				+ "\nEnter 2 to Exist Car_Dekho Application"
				+ "\n====================================");
		int select =scanner.nextInt();
		
	switch (select) {
	case 1:

		System.out.println("============================ \nEnter 1 to add Car. \nEnter 2 to get all Car. \nEnter 3 to delete car. \nEnter 4 to update car"
				+ "\nEnter 5 to search car. \nEnter 6 to Exist. \n============================");
		int choice=scanner.nextInt();
	  switch (choice) {
	case 1:
		  Car car=new Car();
		  System.out.println("Enter car id");
		  car.setCar_id(scanner.nextInt());
		  scanner.nextLine();
		  System.out.println("Enter car name");  
		  car.setName(scanner.nextLine());
		  System.out.println("Enter car brand");
		  car.setBrand(scanner.nextLine());
		  System.out.println("Enter car fuel_type");
		  car.setFuel_type(scanner.nextLine());
		  System.out.println("Enter car price");
		  car.setPrice(scanner.nextDouble());
		  jdbc.addCar(car);
		break;
	case 2:
		List<Car> car1= jdbc.getAllCar();
		 for ( Car c:car1) {
			 System.out.println(c);
		 }
		 break;
	case 3: 
		System.out.println("Enter car id");
		jdbc.deleteCar(scanner.nextInt());
	case 4:
		System.out.println("Enter car id");
		jdbc.updateCar(scanner.nextInt(), scanner);
		break;
	case 5:
		  System.out.println("========Search Car==========="
		  		             + "\nEnter 1 get Car By Id. \nEnter 2 get Car By Name. \nEnter 3 get Car By Brand.\nEnter 4 get Car By Fuel_Type.\nEnter 5 get car price "
		  		         + "\n============================= ");
	       int choice2=scanner.nextInt();
		  switch (choice2) {
			case 1:
				System.out.println("Enter car id");
				Car c=jdbc.getCarById(scanner.nextInt());
				System.out.println(c);
				break;
			case 2: 
				System.out.println("Enter car name");
                Car c1=jdbc.getCarByName();
                System.out.println(c1);
                break;
			case 3:
				System.out.println("Enter car brand");
				Car c2=jdbc.getCarByBrand();
				System.out.println(c2);
			     break;
			case 4:
				System.out.println("Enter car Fuel_type");
				Car c3=jdbc.getCarByFuelType();
				System.out.println(c3);
				
				break;
			case 5:
				System.out.println("Enter car price");
				Car c4=jdbc.getCarByPrice();
				System.out.println(c4);
			default:
				System.out.println("invalid choice");
				break;
			}
	case 6:
		System.out.println("Thank You!");
		break;
	default:
		System.out.println("Invalid choice");
		break;
	}
	case 2:
		System.out.println("Thank you");

		
	}
	
	
	}
   

}
