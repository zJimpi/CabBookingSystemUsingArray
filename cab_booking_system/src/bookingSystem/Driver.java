package bookingSystem;

public class Driver {
	
	private int driverId;
	private String driverName;
	private int driverPhoneNo;
	//entity reference
	private Car car;
	private String driverLocation;
	
	
	public String getDriverLocation() {
		return driverLocation;
	}
	public void setDriverLocation(String driverLocation) {
		this.driverLocation = driverLocation;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public int getDriverPhoneNo() {
		return driverPhoneNo;
	}
	public void setDriverPhoneNo(int driverPhoneNo) {
		this.driverPhoneNo = driverPhoneNo;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Driver() {
		super();
	}
	public Driver(int driverId, String driverName, int driverPhoneNo, Car car,String driverLocation) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.driverPhoneNo = driverPhoneNo;
		this.car = car;
		this.driverLocation=driverLocation;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Driver [driverId=");
		builder.append(driverId);
		builder.append(", driverName=");
		builder.append(driverName);
		builder.append(", driverPhoneNo=");
		builder.append(driverPhoneNo);
		builder.append(", car=");
		builder.append(car);
		builder.append(", driverLocation=");
		builder.append(driverLocation);
		builder.append("]");
		return builder.toString();
	}
	
	

}
