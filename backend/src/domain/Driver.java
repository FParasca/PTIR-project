package domain;

import enums.Gender;

public class Driver {

    private String name;
    private String nif;
    private Gender gender;
    private String driversLicenseNumber;
    private int birthYear;
    private String adress;
    private String password;

    public Driver(String name, String nif, Gender gender, String driversLicenseNumber, int birthYear, String adress,
            String password) {
        this.name = name;
        this.nif = nif;
        this.gender = gender;
        this.driversLicenseNumber = driversLicenseNumber;
        this.birthYear = birthYear;
        this.adress = adress;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDriversLicenseNumber() {
        return driversLicenseNumber;
    }

    public void setDriversLicenseNumber(String driversLicenseNumber) {
        this.driversLicenseNumber = driversLicenseNumber;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
