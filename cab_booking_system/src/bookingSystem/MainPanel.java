package bookingSystem;

import java.util.Scanner;
import static bookingSystem.PassengerPanel.*;
import static bookingSystem.DriverPanel.*;


public class MainPanel {
	
	
	public static void allPanel() {
		Scanner sc=new Scanner(System.in);
		int choice;
		
		while(true) {
			System.out.println("=========================");
			System.out.println("Press 1: Passenger panel\nPress 2: Driver panel\nPress 3: Quit");
			
			System.out.println("=========================");
			System.out.println("Enter choice: ");
			System.out.println("=========================");
			choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				passangerOperation();
				System.out.println("=========================");
				break;
			case 2:
				DriverOperation();
				System.out.println("=========================");
				break;
			
			case 3: System.exit(0);
			
			}//end of switch case

		}//end of while
	}//end of method

	public static void main(String[] args) {
		allPanel();

	}

}
