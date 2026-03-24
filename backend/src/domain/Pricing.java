package domain;

public class Pricing {
    private float pricePerMinBasic;
    private float pricePerMinLuxurious;
    private float nightlySurchargePercent;

    public Pricing(float pricePerMinBasic, float pricePerMinLuxurious, float nightlySurchargePercent) {
        this.pricePerMinBasic = pricePerMinBasic;
        this.pricePerMinLuxurious = pricePerMinLuxurious;
        this.nightlySurchargePercent = nightlySurchargePercent;
    }

    public float getPricePerMinBasic() {
        return pricePerMinBasic;
    }

    public void setPricePerMinBasic(float pricePerMinBasic) {
        this.pricePerMinBasic = pricePerMinBasic;
    }

    public float getPricePerMinLuxurious() {
        return pricePerMinLuxurious;
    }

    public void setPricePerMinLuxurious(float pricePerMinLuxurious) {
        this.pricePerMinLuxurious = pricePerMinLuxurious;
    }

    public float getNightlySurchargePercent() {
        return nightlySurchargePercent;
    }

    public void setNightlySurchargePercent(float nightlySurchargePercent) {
        this.nightlySurchargePercent = nightlySurchargePercent;
    }

}
