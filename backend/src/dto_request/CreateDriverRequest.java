package dto_request;

public class CreateDriverRequest {

    private String nif;
    private String name;
    private String gender;
    private int birthYear;
    private String address;
    private String postalCode;
    private String licenseNumber;
    private String password;

    public CreateDriverRequest() {}

    public String getNif() { return nif; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public int getBirthYear() { return birthYear; }
    public String getAddress() { return address; }
    public String getPostalCode() { return postalCode; }
    public String getLicenseNumber() { return licenseNumber; }
    public String getPassword() { return password; }
    public void setNif(String nif) { this.nif = nif; }
    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setBirthYear(int birthYear) { this.birthYear = birthYear; }
    public void setAddress(String address) { this.address = address; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
    public void setPassword(String password) { this.password = password; }
}