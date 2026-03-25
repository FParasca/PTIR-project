package dto_response;

import java.time.LocalDateTime;

import domain.Taxi;
import enums.ComfortLevel;
import enums.MotorType;

public class TaxiRequestResponse {

    private String licensePlate;
    private int yearOfPurchase;
    private String brand;
    private String model;
    private ComfortLevel comfortLevel;
    private MotorType motorType;
    private LocalDateTime createdAt;

    public TaxiRequestResponse() {
    }

    public static TaxiRequestResponse from(Taxi taxi) {
        TaxiRequestResponse response = new TaxiRequestResponse();
        response.licensePlate = taxi.getLicensePlate();
        response.yearOfPurchase = taxi.getYearOfPurchase();
        response.brand = taxi.getBrand();
        response.model = taxi.getModel();
        response.comfortLevel = taxi.getComfortLevel();
        response.motorType = taxi.getMotorType();
        response.createdAt = taxi.getCreatedAt();
        return response;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getYearOfPurchase() {
        return yearOfPurchase;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public ComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    public MotorType getMotorType() {
        return motorType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
