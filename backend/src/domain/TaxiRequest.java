package domain;

import enums.ComfortLevel;
import enums.RequestStatus;

public class TaxiRequest {

    private String startAddress;
    private String endAddress;
    private int numClients;
    private ComfortLevel desiredComfortLevel;
    private RequestStatus status;

    public TaxiRequest(String startAddress, String endAddress, int numClients, ComfortLevel desiredComfortLevel,
            RequestStatus status) {
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.numClients = numClients;
        this.desiredComfortLevel = desiredComfortLevel;
        this.status = status;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public int getNumClients() {
        return numClients;
    }

    public void setNumClients(int numClients) {
        this.numClients = numClients;
    }

    public ComfortLevel getDesiredComfortLevel() {
        return desiredComfortLevel;
    }

    public void setDesiredComfortLevel(ComfortLevel desiredComfortLevel) {
        this.desiredComfortLevel = desiredComfortLevel;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}
