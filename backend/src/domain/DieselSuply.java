package domain;

public class DieselSuply extends Supply {

    private float liters;

    public DieselSuply(){
        super()
    }
    public DieselSuply(float liters, String timeStart, String timeEnd, int cost, float totalKmTaxi) {
        super(timeStart, timeEnd, cost, totalKmTaxi);
        this.liters = liters;
    }

    public float getLiters() {
        return liters;
    }

    public void setLiters(float liters) {
        this.liters = liters;   
    }
}
