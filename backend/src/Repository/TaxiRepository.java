package repository;

import domain.Taxi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TaxiRepository {

    private final List<Taxi> taxis = new ArrayList<>();

    public void save(Taxi taxi) {
        taxis.add(taxi);
    }

    public List<Taxi> findAllSortedByCreationDate() {
        List<Taxi> sorted = new ArrayList<>(taxis);
        sorted.sort(Comparator.comparing(Taxi::getCreatedAt).reversed());
        return sorted;
    }

    public Optional<Taxi> findByLicensePlate(String licensePlate) {
        return taxis.stream()
                .filter(t -> t.getLicensePlate().equalsIgnoreCase(licensePlate))
                .findFirst();
    }

    public boolean existsByLicensePlate(String licensePlate) {
        return taxis.stream()
                .anyMatch(t -> t.getLicensePlate().equalsIgnoreCase(licensePlate));
    }

    // Devolve todos os táxis
    public List<Taxi> findAll() {
        return new ArrayList<>(taxis);
    }
}
