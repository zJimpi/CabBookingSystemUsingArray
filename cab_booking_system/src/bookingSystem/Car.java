package bookingSystem;

public class Car {
	
	private String carLicenseNo;
	private String carColor;
	private String carModel;
	
	public String getCarLicenseNo() {
		return carLicenseNo;
	}
	public void setCarLicenseNo(String carLicenseNo) {
		this.carLicenseNo = carLicenseNo;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public Car(String carLicenseNo, String carColor, String carModel) {
		super();
		this.carLicenseNo = carLicenseNo;
		this.carColor = carColor;
		this.carModel = carModel;
	}
	public Car() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [carLicenseNo=");
		builder.append(carLicenseNo);
		builder.append(", carColor=");
		builder.append(carColor);
		builder.append(", carModel=");
		builder.append(carModel);
		builder.append("]");
		return builder.toString();
	}
	
	

}
