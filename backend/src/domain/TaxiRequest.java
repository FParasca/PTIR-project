package domain;

import enums.ComfortLevel;
import enums.RequestStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "taxi_requests")
public class TaxiRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String startAddress;

    @Column(nullable = false)
    private String endAddress;

    // coordenadas para cálculo de distância (US6, US7)
    private double startLatitude;
    private double startLongitude;
    private double endLatitude;
    private double endLongitude;

    // restrição 18 — entre 1 e 4 pessoas
    @Column(nullable = false)
    private int numClients;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ComfortLevel desiredComfortLevel;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public TaxiRequest() {}

    public TaxiRequest(String startAddress, String endAddress,
                       double startLatitude, double startLongitude,
                       double endLatitude, double endLongitude,
                       int numClients, ComfortLevel desiredComfortLevel,
                       Client client) {
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.startLatitude = startLatitude;
        this.startLongitude = startLongitude;
        this.endLatitude = endLatitude;
        this.endLongitude = endLongitude;
        this.numClients = numClients;
        this.desiredComfortLevel = desiredComfortLevel;
        this.status = RequestStatus.PENDING;
        this.createdAt = LocalDateTime.now();
        this.client = client;
    }

    public Long getId() { return id; }

    public String getStartAddress() { return startAddress; }
    public void setStartAddress(String startAddress) { this.startAddress = startAddress; }

    public String getEndAddress() { return endAddress; }
    public void setEndAddress(String endAddress) { this.endAddress = endAddress; }

    public double getStartLatitude() { return startLatitude; }
    public void setStartLatitude(double startLatitude) { this.startLatitude = startLatitude; }

    public double getStartLongitude() { return startLongitude; }
    public void setStartLongitude(double startLongitude) { this.startLongitude = startLongitude; }

    public double getEndLatitude() { return endLatitude; }
    public void setEndLatitude(double endLatitude) { this.endLatitude = endLatitude; }

    public double getEndLongitude() { return endLongitude; }
    public void setEndLongitude(double endLongitude) { this.endLongitude = endLongitude; }

    public int getNumClients() { return numClients; }
    public void setNumClients(int numClients) { this.numClients = numClients; }

    public ComfortLevel getDesiredComfortLevel() { return desiredComfortLevel; }
    public void setDesiredComfortLevel(ComfortLevel desiredComfortLevel) { this.desiredComfortLevel = desiredComfortLevel; }

    public RequestStatus getStatus() { return status; }
    public void setStatus(RequestStatus status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
}