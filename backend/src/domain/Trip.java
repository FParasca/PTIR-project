package domain;

public class Trip {
    private String startAddress;
    private String endAddress;
    private String startTime;
    private String endTime;
    private int numClients;
    private float travelledDistance;
    private float price;
    public Trip() {}

    public Trip(String startAddress, String endAddress, String startTime, String endTime, int numClients,
            float travelledDistance, float price) {
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numClients = numClients;
        this.travelledDistance = travelledDistance;
        this.price = price;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getNumClients() {
        return numClients;
    }

    public void setNumClients(int numClients) {
        this.numClients = numClients;
    }

    public float getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(float travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
