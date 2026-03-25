package domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import enums.ComfortLevel;
import enums.MotorType;

@Entity
@DiscriminatorValue("ELECTRIC")
public class ElectricSupply extends Supply {

    @Column(nullable = false)
    private float kwh;

    public ElectricSupply() {
        super();
    }

    public ElectricSupply(float kwh, LocalDateTime timeStart, LocalDateTime timeEnd,
            float cost, float totalKmTaxi, Shift shift) {
        super(timeStart, timeEnd, cost, totalKmTaxi, shift);
        this.kwh = kwh;
    }

    public float getKwh() {
        return kwh;
    }

    public void setKwh(float kwh) {
        this.kwh = kwh;
    }

}
