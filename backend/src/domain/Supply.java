package domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "supplies")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "supply_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime timeStart;

    @Column(nullable = false)
    private LocalDateTime timeEnd;

    @Column(nullable = false)
    private float cost;

    @Column(nullable = false)
    private float totalKmTaxi;

    @ManyToOne(optional = false)
    @JoinColumn(name = "shift_id", nullable = false)
    private Shift shift;

    public Supply() {}

    public Supply(LocalDateTime timeStart, LocalDateTime timeEnd,
                  float cost, float totalKmTaxi, Shift shift) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.cost = cost;
        this.totalKmTaxi = totalKmTaxi;
        this.shift = shift;
    }

    public Long getId() { return id; }

    public LocalDateTime getTimeStart() { return timeStart; }
    public void setTimeStart(LocalDateTime timeStart) { this.timeStart = timeStart; }

    public LocalDateTime getTimeEnd() { return timeEnd; }
    public void setTimeEnd(LocalDateTime timeEnd) { this.timeEnd = timeEnd; }

    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }

    public float getTotalKmTaxi() { return totalKmTaxi; }
    public void setTotalKmTaxi(float totalKmTaxi) { this.totalKmTaxi = totalKmTaxi; }

    public Shift getShift() { return shift; }
    public void setShift(Shift shift) { this.shift = shift; }
}