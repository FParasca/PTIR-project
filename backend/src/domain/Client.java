package domain;

import enums.Gender;

public class Client {

    private String name;
    private String NIF;
    private Gender gender;
    private String password;

    public Client(String name, String NIF, Gender gender, String password) {
        this.name = name;
        this.NIF = NIF;
        this.gender = gender;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF2) {
        this.NIF = NIF2;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
