package bookingSystem;

import java.util.Scanner;

public class CarPanel {
	
	static Car c1;
	
	public static Car createCarDetails() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter car lisence No: ");
		String cLicenseNo=sc.nextLine();
		
		System.out.println("Enter car color : ");
		String cColor=sc.nextLine();
		
		System.out.println("Enter car model : ");
		String cModel=sc.nextLine();
	
		c1=new Car(cLicenseNo, cColor, cModel);
		return c1;
		
	}
	
	

}
