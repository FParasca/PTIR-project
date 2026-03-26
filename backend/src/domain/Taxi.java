package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import enums.ComfortLevel;
import enums.MotorType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "taxis")
public class Taxi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String licensePlate;

    @Column(nullable = false)
    private int yearOfPurchase;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ComfortLevel comfortLevel;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MotorType motorType;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;


    @OneToMany(mappedBy = "taxi", cascade = CascadeType.ALL)
    private List<Shift> shifts = new ArrayList<>();

    public Taxi() {}

    public Taxi(String licensePlate, int yearOfPurchase, String brand, String model,
                ComfortLevel comfortLevel, MotorType motorType) {
        this.licensePlate = licensePlate;
        this.yearOfPurchase = yearOfPurchase;
        this.brand = brand;
        this.model = model;
        this.comfortLevel = comfortLevel;
        this.motorType = motorType;
        this.createdAt = LocalDateTime.now();
    }


    public Long getId() { return id; }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public int getYearOfPurchase() { return yearOfPurchase; }
    public void setYearOfPurchase(int yearOfPurchase) { this.yearOfPurchase = yearOfPurchase; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public ComfortLevel getComfortLevel() { return comfortLevel; }
    public void setComfortLevel(ComfortLevel comfortLevel) { this.comfortLevel = comfortLevel; }

    public MotorType getMotorType() { return motorType; }
    public void setMotorType(MotorType motorType) { this.motorType = motorType; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<Shift> getShifts() { return shifts; }
    public void setShifts(List<Shift> shifts) { this.shifts = shifts; }
}