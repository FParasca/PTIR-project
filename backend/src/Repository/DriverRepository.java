package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import domain.Driver;
import java.util.Optional;
import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByDriversLicenseNumber(String licenseNumber);
    
    // Devolve a lista já ordenada da base de dado
    List<Driver> findAllByOrderByCreatedAtDesc();
}