package bookingSystem;

import static bookingSystem.MainPanel.*;
import static bookingSystem.TimeCalculation.*;

import java.util.Scanner;

public class PassengerPanel {
	
	static Scanner sc=new Scanner(System.in);
	static Passenger[] pasen=new Passenger[10];
	static int pasenIndex=0;
	static int passId =0;
	static int genratePassengerId(){
		passId++;
		return passId;
	}
	
	public static void addPassenger(Passenger p1) {
		pasen[pasenIndex++]=p1;
		System.out.println("passenger added sussesfully!!");
	}
		
	public static Passenger createPassenger(){
		
		int pId = PassengerPanel.genratePassengerId();
		System.out.println("==========Passenger details ===============");
		sc.nextLine();
		System.out.println("Enter your name: ");
		String pName=sc.nextLine();
		
		System.out.println("Enter your phone number: ");
		int pPh=sc.nextInt();
		
		sc.nextLine();
		System.out.println("Enter your Destination: ");
		String pDes=sc.nextLine();
		
		System.out.println("Enter your Current Location: ");
		String pLoc=sc.nextLine();
		System.out.println("===========================================");
		Passenger p1=new Passenger(pId,pName, pPh, pLoc,pDes);
		return p1;
	}
	
	public static void showPassengerDetails(Passenger[] p) {
		for (int i=0;i<pasenIndex;i++) {
			System.out.println(p[i]);
		}
	}
	
	public static void calculateTimeAndPrice(String vehicle) {
		double price = 10.0;
		int dropOffTime=0;
		String cLoc = pasen[pasenIndex-1].getPassengerCurrentLocation();
		String des = pasen[pasenIndex-1].getPassengerDestination();
		dropOffTime = calculateTime(cLoc,des);
		
		price *= dropOffTime;
		
		if(vehicle.equalsIgnoreCase("Taxis/Auto")) {
			
			System.out.println("dropofftime: "+dropOffTime+"  mins");
			System.out.println("price: "+price+ " per head");
			System.out.println("=========================");
			
			System.out.println("confirm? (y/n)");
			sc.nextLine();
			String c= sc.nextLine();
			if(c.equalsIgnoreCase("y"))
				genrateBill("Taxis/Auto",price,dropOffTime);
			else
				listOfCarsAvailable();
		}
		if(vehicle.equalsIgnoreCase("Vans")) {
			price *=0.75;
			System.out.println("dropofftime: "+dropOffTime+" mins");
			System.out.println("price: "+price+ " per head");
			System.out.println("=========================");
			
			System.out.println("confirm? (y/n)");
			sc.nextLine();
			String c= sc.nextLine();
			if(c.equalsIgnoreCase("y"))
				genrateBill("Vans",price,dropOffTime);
			
			else
				listOfCarsAvailable();
			
		}
		
		if(vehicle.equalsIgnoreCase("Premium cars")) {
			price *=1.75;
			System.out.println("dropofftime: "+dropOffTime+" mins");
			System.out.println("price: "+price+ " per head");
			System.out.println("=========================");
			System.out.println("confirm? (y/n)");
			sc.nextLine();
			String c= sc.nextLine();
			if(c.equalsIgnoreCase("y"))
				genrateBill("Premium cars",price,dropOffTime);
			else
				listOfCarsAvailable();	
		}
		
	}
	
	public static void passangerOperation() {
		
		//PassengerPanel pass=new PassengerPanel();
		Passenger p;
		int choice;
		
		while(true) {
			System.out.println("=========================");
			System.out.println("Press 1: Add Passenger details\n"+
						       "Press 2: Show Passenger details\n"+
							   "Press 3: show list Cars Available\n"+
							   "Press 4: back to main menu");
			
			System.out.println("=========================");
			System.out.println("Enter choice: ");
			System.out.println("=========================");
			choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				p=createPassenger();
				addPassenger(p);
				break;
			
			case 2:
				showPassengerDetails(pasen);
				System.out.println("=========================");
				break;
			case 3:
				listOfCarsAvailable();
				System.out.println("=========================");
				break;
			
			case 4: 
				allPanel();
				break;
			}//end of switch

		}//end of while
	}//end of method

	public static  void listOfCarsAvailable() {
		//PassengerPanel p=new PassengerPanel();
		int choice;
		while(true) {
		System.out.println("press 1: Taxis/Auto   ||seating: 1-3\n"+
						   "press 2: Vans         ||seating: 1-6\n"+
						   "press 3: Premium cars ||seating: 1-3\n"+
						   "press 4: go back");
		System.out.println("=========================");
		System.out.println("Enter choice: ");
		System.out.println("=========================");
		choice = sc.nextInt();
		switch(choice) {
		
		case 1:
			calculateTimeAndPrice("Taxis/Auto");
			break;
		
		case 2:
			calculateTimeAndPrice("Vans");
			break;
			
		case 3:
			calculateTimeAndPrice("Premium cars");
			break;
		
		case 4: 
			passangerOperation();
			break;
		}//end of switch
		}//end of while
		
	}//end of method

	public static void genrateBill(String vehicle,double price,int dropOffTime) {
		System.out.println("===========Bill==============");
		System.out.println("vehicle type booked: "+vehicle);
		System.out.println("dropofftime: "+dropOffTime+" mins");
		System.out.println("price: "+price+ " per head");
		System.out.println("Your current location: "+pasen[pasenIndex-1].getPassengerCurrentLocation());
		System.out.println("Your destination:"+pasen[pasenIndex-1].getPassengerDestination());
		System.out.println("=========================");
		
		allPanel();
	}
	public  static void genratePassengerDetails(){
		
		System.out.println("~~~~~~~pasenger details~~~~~~~~~");
		System.out.println("Passenger name:"+pasen[pasenIndex-1].getName());
		System.out.println("Passenger phone no:"+pasen[pasenIndex-1].getPassengerPhoneNo());
		System.out.println("Passenger current location: "+pasen[pasenIndex-1].getPassengerCurrentLocation());
		System.out.println("Passenger destination:"+pasen[pasenIndex-1].getPassengerDestination());

		
	}
}
