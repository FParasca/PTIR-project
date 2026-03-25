package domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shifts")
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime shiftStart;

    @Column(nullable = false)
    private LocalDateTime shiftFinish;

    @ManyToOne(optional = false)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @ManyToOne(optional = false)
    @JoinColumn(name = "taxi_id", nullable = false)
    private Taxi taxi;

    @OneToMany(mappedBy = "shift", cascade = CascadeType.ALL)
    private List<Trip> trips = new ArrayList<>();

    @OneToMany(mappedBy = "shift", cascade = CascadeType.ALL)
    private List<Supply> supplies = new ArrayList<>();

    public Shift() {}

    public Shift(LocalDateTime shiftStart, LocalDateTime shiftFinish, Driver driver, Taxi taxi) {
        this.shiftStart = shiftStart;
        this.shiftFinish = shiftFinish;
        this.driver = driver;
        this.taxi = taxi;
    }

    public Long getId() { return id; }

    public LocalDateTime getShiftStart() { return shiftStart; }
    public void setShiftStart(LocalDateTime shiftStart) { this.shiftStart = shiftStart; }

    public LocalDateTime getShiftFinish() { return shiftFinish; }
    public void setShiftFinish(LocalDateTime shiftFinish) { this.shiftFinish = shiftFinish; }

    public Driver getDriver() { return driver; }
    public void setDriver(Driver driver) { this.driver = driver; }

    public Taxi getTaxi() { return taxi; }
    public void setTaxi(Taxi taxi) { this.taxi = taxi; }

    public List<Trip> getTrips() { return trips; }
    public void setTrips(List<Trip> trips) { this.trips = trips; }

    public List<Supply> getSupplies() { return supplies; }
    public void setSupplies(List<Supply> supplies) { this.supplies = supplies; }
}