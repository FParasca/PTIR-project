package domain;

public class EletricSuply extends Supply {

    private float KWH;

    public EletricSuply(float KWH, String timeStart, String timeEnd, int cost, float totalKmTaxi) {
        super(timeStart, timeEnd, cost, totalKmTaxi);
        this.KWH = KWH;
    }

    public float getKWH() {
        return KWH;
    }

    public void setKWH(float KWH) {
        this.KWH = KWH;
    }
}
