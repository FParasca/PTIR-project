package domain;

import enums.Gender;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int serialNumber;

    @Column(nullable = false)
    private int serialYear;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false, length = 9)
    private String clientNif;

    @Column(nullable = false)
    private String clientName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender clientGender;

    @OneToOne(optional = false)
    @JoinColumn(name = "trip_id", nullable = false, unique = true)
    private Trip trip;

    public Invoice() {}

    public Invoice(int serialNumber, int serialYear, LocalDateTime date,
                   String clientNif, String clientName, Gender clientGender, Trip trip) {
        this.serialNumber = serialNumber;
        this.serialYear = serialYear;
        this.date = date;
        this.clientNif = clientNif;
        this.clientName = clientName;
        this.clientGender = clientGender;
        this.trip = trip;
    }

    public Long getId() { return id; }

    public int getSerialNumber() { return serialNumber; }
    public void setSerialNumber(int serialNumber) { this.serialNumber = serialNumber; }

    public int getSerialYear() { return serialYear; }
    public void setSerialYear(int serialYear) { this.serialYear = serialYear; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public String getClientNif() { return clientNif; }
    public void setClientNif(String clientNif) { this.clientNif = clientNif; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public Gender getClientGender() { return clientGender; }
    public void setClientGender(Gender clientGender) { this.clientGender = clientGender; }

    public Trip getTrip() { return trip; }
    public void setTrip(Trip trip) { this.trip = trip; }
}