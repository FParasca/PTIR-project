package dto_response;

import java.time.LocalDateTime;

public class DriverResponse {

    private Long id;
    private String nif;
    private String name;
    private String gender;
    private int birthYear;
    private String address;
    private String licenseNumber;
    private LocalDateTime createdAt;

    public DriverResponse() {}

    public DriverResponse(Long id, String nif, String name, String gender, int birthYear, String address, String licenseNumber, LocalDateTime createdAt) {
        this.id = id;
        this.nif = nif;
        this.name = name;
        this.gender = gender;
        this.birthYear = birthYear;
        this.address = address;
        this.licenseNumber = licenseNumber;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getNif() { return nif; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public int getBirthYear() { return birthYear; }
    public String getAddress() { return address; }
    public String getLicenseNumber() { return licenseNumber; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setNif(String nif) { this.nif = nif; }
    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setBirthYear(int birthYear) { this.birthYear = birthYear; }
    public void setAddress(String address) { this.address = address; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}