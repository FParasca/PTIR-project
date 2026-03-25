package domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String startAddress;

    @Column(nullable = false)
    private String endAddress;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private int numClients;

    @Column(nullable = false)
    private float travelledDistance;

    @Column(nullable = false)
    private float price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "shift_id", nullable = false)
    private Shift shift;

    @OneToOne(mappedBy = "trip", cascade = CascadeType.ALL)
    private Invoice invoice;

    public Trip() {}

    public Trip(String startAddress, String endAddress, LocalDateTime startTime,
                LocalDateTime endTime, int numClients, float travelledDistance,
                float price, Shift shift) {
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numClients = numClients;
        this.travelledDistance = travelledDistance;
        this.price = price;
        this.shift = shift;
    }

    public Long getId() { return id; }

    public String getStartAddress() { return startAddress; }
    public void setStartAddress(String startAddress) { this.startAddress = startAddress; }

    public String getEndAddress() { return endAddress; }
    public void setEndAddress(String endAddress) { this.endAddress = endAddress; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public int getNumClients() { return numClients; }
    public void setNumClients(int numClients) { this.numClients = numClients; }

    public float getTravelledDistance() { return travelledDistance; }
    public void setTravelledDistance(float travelledDistance) { this.travelledDistance = travelledDistance; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }

    public Shift getShift() { return shift; }
    public void setShift(Shift shift) { this.shift = shift; }

    public Invoice getInvoice() { return invoice; }
    public void setInvoice(Invoice invoice) { this.invoice = invoice; }
}