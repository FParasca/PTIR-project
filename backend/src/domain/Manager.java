package domain;

import enums.Gender;

public class Manager {

    private String name;
    private String nif;
    private String password;
    private Gender gender;

    public Manager() {}
    
    public Manager(String name, String nif, String password) {
        this.name = name;
        this.nif = nif;
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

    public void setnif(String nif) {
        this.nif = nif;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
