package dto_response;

public class PricingDto {

    private Long id;
    private float pricePerMinBasic;
    private float pricePerMinLuxurious;
    private float nightlySurchargePercent;

    public PricingDto() {}

    public PricingDto(Long id, float pricePerMinBasic, float pricePerMinLuxurious, float nightlySurchargePercent) {
        this.id = id;
        this.pricePerMinBasic = pricePerMinBasic;
        this.pricePerMinLuxurious = pricePerMinLuxurious;
        this.nightlySurchargePercent = nightlySurchargePercent;
    }

    public Long getId() {
        return id;
    }
    public float getPricePerMinBasic() {
        return pricePerMinBasic;
    }
    public float getPricePerMinLuxurious() {
        return pricePerMinLuxurious;
    }
    public float getNightlySurchargePercent() {
        return nightlySurchargePercent;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public void setPricePerMinBasic(float pricePerMinBasic) {
        this.pricePerMinBasic = pricePerMinBasic;
    }
    public void setPricePerMinLuxurious(float pricePerMinLuxurious) {
        this.pricePerMinLuxurious = pricePerMinLuxurious;
    }
    public void setNightlySurchargePercent(float nightlySurchargePercent) {
        this.nightlySurchargePercent = nightlySurchargePercent;
    }
}