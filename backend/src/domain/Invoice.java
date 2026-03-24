package domain;

import enums.Gender;

public class Invoice {

    private long serialNumber;
    private String date;
    private String clientNif;
    private String clientNumber;
    private Gender clientGender;

    public Invoice(long serialNumber, String date, String clientNif, String clientNumber, Gender clientGender) {
        this.serialNumber = serialNumber;
        this.date = date;
        this.clientNif = clientNif;
        this.clientNumber = clientNumber;
        this.clientGender = clientGender;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClientNif() {
        return clientNif;
    }

    public void setClientNif(String clientNif) {
        this.clientNif = clientNif;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public Gender getClientGender() {
        return clientGender;
    }

    public void setClientGender(Gender clientGender) {
        this.clientGender = clientGender;
    }
}
