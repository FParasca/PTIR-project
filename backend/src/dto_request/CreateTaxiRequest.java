package dto_request;

public class CreateTaxiRequest {
    
    private String licensePlate;
    private int yearOfPurchase;
    private String brand;
    private String model;
    private String comfortLevel;
    private String motorType;

    public CreateTaxiRequest() {}

    public String getLicensePlate() { return licensePlate; }
    public int getYearOfPurchase() { return yearOfPurchase; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getComfortLevel() { return comfortLevel; }
    public String getMotorType() { return motorType; }

    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
    public void setYearOfPurchase(int yearOfPurchase) { this.yearOfPurchase = yearOfPurchase; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setModel(String model) { this.model = model; }
    public void setComfortLevel(String comfortLevel) { this.comfortLevel = comfortLevel; }
    public void setMotorType(String motorType) { this.motorType = motorType; }
}