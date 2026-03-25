package domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import enums.ComfortLevel;
import enums.MotorType;
import domain.Shift;

@Entity
@DiscriminatorValue("DIESEL")
public class DieselSupply extends Supply {

    // restrição 22 — litros positivos
    @Column(nullable = false)
    private float liters;

    public DieselSupply() {
        super();
    }

    public DieselSupply(float liters, LocalDateTime timeStart, LocalDateTime timeEnd,
                        float cost, float totalKmTaxi, Shift shift) {
        super(timeStart, timeEnd, cost, totalKmTaxi, shift);
        this.liters = liters;
    }

    public float getLiters() { return liters; }
    public void setLiters(float liters) { this.liters = liters; }
}