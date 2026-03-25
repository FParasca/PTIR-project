package domain;

import enums.Gender;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import enums.ComfortLevel;
import enums.MotorType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 9)
    private String nif;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<TaxiRequest> taxiRequests = new ArrayList<>();

    public Client() {}

    public Client(String name, String nif, Gender gender) {
        this.name = name;
        this.nif = nif;
        this.gender = gender;
    }

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNif() { return nif; }
    public void setNif(String nif) { this.nif = nif; }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    public List<TaxiRequest> getTaxiRequests() { return taxiRequests; }
    public void setTaxiRequests(List<TaxiRequest> taxiRequests) { this.taxiRequests = taxiRequests; }
}