package Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Taxi;

@Repository
public interface TaxiRepository extends JpaRepository<Taxi, Long> {

    Optional<Taxi> findByLicensePlate(String licensePlate);

    public boolean existsByLicensePlate(String licensePlate) {
        return taxis.stream()
                .anyMatch(t -> t.getLicensePlate().equalsIgnoreCase(licensePlate));
    };

    public List<Taxi> findAllSortedByCreationDate() {
        return taxis.stream()
                .sorted(Comparator.comparing(Taxi::getCreatedAt))
                .toList();
    };
}
