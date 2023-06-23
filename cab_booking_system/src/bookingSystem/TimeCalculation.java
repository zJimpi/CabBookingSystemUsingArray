package bookingSystem;

import static bookingSystem.DriverPanel.*;

public class TimeCalculation {
	static final String[] destination = {"des1","des2","des3","des4","des5","des6","des7","des8","des9","des10"};
	static final int[] timediff = {10,20,40,10,20,30,10,40,10};
	
//for testing only 
	public static void printCarLocation(Driver[] d) {
		for(int i=0;i<d.length;i++) {
			System.out.println(d[i]);
		}
	}
	
	public static int calculateTime(String cLoc, String des){
		int dropofftime=0;
		
		int start=calculateIndexOfDestinationArray(cLoc);
		int end=calculateIndexOfDestinationArray(des);
		
		//calculating total time
		if(start == end) {
			dropofftime=0;
		}
		else if(start<end) {
			for(int i=start;i<end;i++) {
				dropofftime += timediff[i];
			}
			
		}
		else {
			for(int i=(start-1);i>=end;i--) {
				dropofftime += timediff[i];
			}
			
		}
		return dropofftime;
	}
	
	
	public static Driver calculateNearestCar(Driver[] arr,String pLoc){
		
		int count=0;
		int fTime=1000;
		int bTime=1000;
		int startIndex=calculateIndexOfDestinationArray(pLoc);
		
		if(carLocation[startIndex]!=null)
		{
			return arr[startIndex];
		}
		else {
		for(count=1;count<arr.length;count++){
			//backward
			if(count%2==0 ) {
				startIndex -= count;
				if(startIndex<0)
					break;
				//System.out.println(arr[startIndex]);
				bTime = calculateTime(pLoc, destination[startIndex]);
				
				
			}
			//forward
			else  {
				startIndex += count;
				if(startIndex>arr.length-1)
					break;
				//System.out.println(arr[startIndex]);
				fTime = calculateTime(pLoc, destination[startIndex]);
			}
			
			if(fTime<bTime && arr[startIndex] !=null) {
				return arr[startIndex];
			}
			else if(fTime>bTime && arr[startIndex] !=null) {
				return arr[startIndex];
			}
			else if(fTime==bTime && arr[startIndex] !=null) {
				return arr[startIndex];
			}
			
		}
		
		//forward line
		if(startIndex ==-1) {
			while(count <arr.length) {
				//System.out.println(arr[count]);
				if(arr[count] !=null) {
					return arr[count];
					}
				count++;
			}
		}
		
		//backward line
		if(startIndex ==arr.length) {
			int j=arr.length - count-1;
			while(j>=0) {
				//System.out.println(arr[j]);
				if(arr[j] !=null) {
					return arr[j];
					}
				j--;
			}//end of inner while
		}//end of if
		}//end of else
		
		return null;
		
	}//end of method
	
	public static int calculateIndexOfDestinationArray(String loc) {
		
		for(int i=0;i<10;i++) {
			if(destination[i].equals(loc))
			{
				return i;
			
			}
		}
		
		return 0;
	}//end of method

}
