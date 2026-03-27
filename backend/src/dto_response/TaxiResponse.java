package dto_response;

import java.time.LocalDateTime;

public class TaxiResponse {

    private Long id;
    private String licensePlate;
    private int yearOfPurchase;
    private String brand;
    private String model;
    private String comfortLevel;
    private String motorType;
    private LocalDateTime createdAt;

    public TaxiResponse() {}

    public TaxiResponse(Long id, String licensePlate, int yearOfPurchase, String brand, String model, String comfortLevel, String motorType, LocalDateTime createdAt) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.yearOfPurchase = yearOfPurchase;
        this.brand = brand;
        this.model = model;
        this.comfortLevel = comfortLevel;
        this.motorType = motorType;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getLicensePlate() { return licensePlate; }
    public int getYearOfPurchase() { return yearOfPurchase; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getComfortLevel() { return comfortLevel; }
    public String getMotorType() { return motorType; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}