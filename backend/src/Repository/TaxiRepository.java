package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import domain.Taxi;
import java.util.Optional;

@Repository
public interface TaxiRepository extends JpaRepository<Taxi, Long> {

    Optional<Taxi> findByLicensePlate(String licensePlate);
}
