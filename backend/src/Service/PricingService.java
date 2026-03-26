package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dto_response.PricingDto;
import domain.Pricing;
import Repository.PricingRepository;

import java.util.List;

@Service
public class PricingService {

    @Autowired
    private PricingRepository pricingRepository;

    public PricingDto getPricingById(Long id){

        return pricingRepository.findById(id)
                .map(this::mapToPricingDto)
                .orElse(null);
    }

    public PricingDto mapToPricingDto(Pricing pricing){

        return new PricingDto(
                pricing.getId(),
                pricing.getPricePerMinBasic(),
                pricing.getPricePerMinLuxurious(),
                pricing.getNightlySurchargePercent()
        );
    }

    public List<PricingDto> getAllPricings(){
        List<Pricing> pricings = pricingRepository.findAll();
        return pricings.stream()
                .map(this::mapToPricingDto)
                .toList();
    }

    public PricingDto createPricing(PricingDto pricingDto){
        Pricing pricing = new Pricing();
        pricing.setPricePerMinBasic(pricingDto.getPricePerMinBasic());
        pricing.setPricePerMinLuxurious(pricingDto.getPricePerMinLuxurious());
        pricing.setNightlySurchargePercent(pricingDto.getNightlySurchargePercent());

        Pricing pricingSaved = pricingRepository.save(pricing);

        return mapToPricingDto(pricingSaved);
    }
}