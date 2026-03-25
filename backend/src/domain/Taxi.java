package domain;

import enums.ComfortLevel;
import enums.MotorType;

import java.time.LocalDateTime;

public class Taxi {

    private String licensePlate;
    private int yearofPursage;
    private String brand;
    private String model;
    private ComfortLevel comfortLevel;
    private MotorType motorType;
    private LocalDateTime createdAt;

    public Taxi(){}
    
    public Taxi(String licenseplate, int yearofpursage, String brand, String model, ComfortLevel comfortlevel,
            MotorType motorType) {
        this.licensePlate = licenseplate;
        this.yearofPursage = yearofpursage;
        this.brand = brand;
        this.model = model;
        this.comfortLevel = comfortlevel;
        this.motorType = motorType;
        this.createdAt = LocalDateTime.now();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licenseplate) {
        this.licensePlate = licenseplate;
    }

    public int getYearofPursage() {
        return yearofPursage;
    }

    public void setYearofPursage(int yearofpursage) {
        this.yearofPursage = yearofpursage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    public void setComfortLevel(ComfortLevel comfortlevel) {
        this.comfortLevel = comfortlevel;
    }

    public MotorType getMotorType() {
        return motorType;
    }

    public void setMotorType(MotorType motorType) {
        this.motorType = motorType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
