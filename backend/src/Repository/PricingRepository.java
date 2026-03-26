package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import domain.Pricing;

@Repository
public interface PricingRepository extends JpaRepository<Pricing, Long> {
    
}