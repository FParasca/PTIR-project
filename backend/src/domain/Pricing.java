package domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import enums.ComfortLevel;
import enums.MotorType;


@Entity
@Table(name = "pricing")
public class Pricing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private float pricePerMinBasic;

    @Column(nullable = false)
    private float pricePerMinLuxurious;

    @Column(nullable = false)
    private float nightlySurchargePercent;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Pricing() {}

    public Pricing(float pricePerMinBasic, float pricePerMinLuxurious, float nightlySurchargePercent) {
        this.pricePerMinBasic = pricePerMinBasic;
        this.pricePerMinLuxurious = pricePerMinLuxurious;
        this.nightlySurchargePercent = nightlySurchargePercent;
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }

    public float getPricePerMinBasic() { return pricePerMinBasic; }
    public void setPricePerMinBasic(float pricePerMinBasic) { this.pricePerMinBasic = pricePerMinBasic; }

    public float getPricePerMinLuxurious() { return pricePerMinLuxurious; }
    public void setPricePerMinLuxurious(float pricePerMinLuxurious) { this.pricePerMinLuxurious = pricePerMinLuxurious; }

    public float getNightlySurchargePercent() { return nightlySurchargePercent; }
    public void setNightlySurchargePercent(float nightlySurchargePercent) { this.nightlySurchargePercent = nightlySurchargePercent; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
}