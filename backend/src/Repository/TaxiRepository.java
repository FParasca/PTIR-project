package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Taxi;

@Repository
public interface TaxiRepository extends JpaRepository<Taxi, Long> {

    boolean existsByLicensePlate(String licensePlate);
    
    List<Taxi> findAllByOrderByCreatedAtDesc();
}