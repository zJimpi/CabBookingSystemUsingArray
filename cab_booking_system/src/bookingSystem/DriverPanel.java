package bookingSystem;

import java.util.Scanner;
import static bookingSystem.CarPanel.*;
import static bookingSystem.MainPanel.*;
import static bookingSystem.PassengerPanel.*;
import static bookingSystem.TimeCalculation.*;

public class DriverPanel {
	
	static Scanner sc=new Scanner(System.in);
	static Driver[] driv=new Driver[10];
	static int drivIndex=0;
	
	static Driver[] carLocation=new Driver[destination.length];//Initialized with null

	static Driver nearestDriver;
	static int driverId =0;
	static int countDriver=0;
	static int genrateDriverId() {
		driverId++;
		countDriver++;
		return driverId;
	}
	
	public static void addDriver(Driver d1) {
		driv[drivIndex++]=d1;
		System.out.println("Driver added sussesfully!!");
	}
	public static Driver createDriver(){
		
		int dId = DriverPanel.genrateDriverId();
		System.out.println("==========Driver details ===============");
		//sc.nextLine();
		System.out.println("Enter your name: ");
		String dName=sc.nextLine();
		
		System.out.println("Enter your phone number: ");
		int dPh=sc.nextInt();
		
		//car addition
		System.out.println("~~~~~~~~car details~~~~~~~~~~");
		Car car=createCarDetails();
		sc.nextLine();
		
		System.out.println("Enter your car location: ");
		String dLoc=sc.nextLine();
		
		System.out.println("===========================================");
		Driver d1=new Driver(dId, dName, dPh, car,dLoc);
		initializingCarLocationArray(d1);
		return d1;
	}
	
	public static void initializingCarLocationArray(Driver d) {
		
		int index=0;
		
		for(int i=0;i<destination.length;i++) {
			if(destination[i].equalsIgnoreCase(d.getDriverLocation())) {
				index=i;
				break;
			}
		}
		
		carLocation[index]=d;
		
	}
	public static void DriverOperation(){

		//calculateNearestCar();
		Driver d;
		int choice;
		
		while(true) {
			System.out.println("=========================");
			System.out.println("Press 1: Add Driver details\n"+
						       "Press 2: Show Driver details\n"+
						       "Press 3: Show passenger availability\n"+
							   "Press 4: back to main menu");
			
			System.out.println("=========================");
			System.out.println("Enter choice: ");
			System.out.println("=========================");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			
			case 1:
				d=createDriver();
				addDriver(d);
				break;
			
			case 2:
				showDriverDetails(driv);
				System.out.println("=========================");
				break;
			
			case 3:
				showPassengerAvailabilty();
			case 4:
				allPanel();
				break;
			}//end of switch

		}//end of while
	}//end of method

	

	public static void showDriverDetails(Driver[] d) {
		for (int i=0;i<drivIndex;i++) {
			System.out.println(d[i]);
		}
		
	}
	
	public static void showPassengerAvailabilty() {
		nearestDriver=calculateNearestCar(carLocation,pasen[pasenIndex-1].getPassengerCurrentLocation());

		if(nearestDriver==null) {
			
			System.out.println("driver not available");
		}
		else {
		System.out.println("~~~~ Notification for driver: "+nearestDriver.getDriverId() +"~~~~~");
		genratePassengerDetails();
		
		//sc.nextLine();
		System.out.println("confirm? y/n");
		String c=sc.nextLine();
		if(c.equalsIgnoreCase("y")) {
			genrateAcceptedDriverDetails();
			allPanel();
		}
		else {
			System.out.println("driver: "+nearestDriver.getDriverId()+" did not accept");
			removeUnacceptedCarLocation(nearestDriver.getDriverLocation());
			showPassengerAvailabilty();
		}
		}//end of outer else	
		
	}
	public static void removeUnacceptedCarLocation(String loc) {
		
		int index = calculateIndexOfDestinationArray(loc);
		
		carLocation[index]=null;
		
	}

	public static void genrateAcceptedDriverDetails(){
		
		System.out.println("=======================================");
		System.out.println("~~~~~~~Driver details~~~~~~~~~");
		System.out.println("Driver name:"+nearestDriver.getDriverName());
		System.out.println("Driver phone no:"+nearestDriver.getDriverPhoneNo());
		System.out.println("Car license no: "+nearestDriver.getCar().getCarLicenseNo());
		System.out.println("Car color:"+nearestDriver.getCar().getCarColor());
		System.out.println("Car Model:"+nearestDriver.getCar().getCarModel());
		
	}
}





