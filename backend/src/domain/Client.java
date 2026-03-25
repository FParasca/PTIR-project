package domain;

import java.util.ArrayList;
import java.util.List;

import enums.Gender;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



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