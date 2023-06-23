package bookingSystem;

public class Passenger {
	
	private int id;
	private String name;
	private int passengerPhoneNo;
	private String passengerCurrentLocation;
	private String passengerDestination;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassengerPhoneNo() {
		return passengerPhoneNo;
	}
	public void setPassengerPhoneNo(int passengerPhoneNo) {
		this.passengerPhoneNo = passengerPhoneNo;
	}
	public String getPassengerCurrentLocation() {
		return passengerCurrentLocation;
	}
	public void setPassengerCurrentLocation(String passengerCurrentLocation) {
		this.passengerCurrentLocation = passengerCurrentLocation;
	}
	public String getPassengerDestination() {
		return passengerDestination;
	}
	public void setPassengerDestination(String passengerDestination) {
		this.passengerDestination = passengerDestination;
	}
	public Passenger() {
		super();
		
	}
	public Passenger(int id, String name, int passengerPhoneNo, String passengerCurrentLocation,
			String passengerDestination) {
		super();
		this.id = id;
		this.name = name;
		this.passengerPhoneNo = passengerPhoneNo;
		this.passengerCurrentLocation = passengerCurrentLocation;
		this.passengerDestination = passengerDestination;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Passenger [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", passengerPhoneNo=");
		builder.append(passengerPhoneNo);
		builder.append(", passengerCurrentLocation=");
		builder.append(passengerCurrentLocation);
		builder.append(", passengerDestination=");
		builder.append(passengerDestination);
		builder.append("]");
		return builder.toString();
	}
	
	
}
