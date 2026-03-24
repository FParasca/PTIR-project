package domain;

public class Supply {

    private String timeStart;
    private String timeEnd;
    private int cost;
    private float totalKmTaxi;

    public Supply(String timeStart, String timeEnd, int cost, float totalKmTaxi) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.cost = cost;
        this.totalKmTaxi = totalKmTaxi;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public float getTotalKmTaxi() {
        return totalKmTaxi;
    }

    public void setTotalKmTaxi(float totalKmTaxi) {
        this.totalKmTaxi = totalKmTaxi;
    }
}