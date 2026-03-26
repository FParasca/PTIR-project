package controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dto_response.PricingDto;
import Service.PricingService;

import java.util.List;

@RestController
@RequestMapping("/api/pricing")
@Tag(name = "Pricing API", description = "Pricing")
public class PricingController {

    @Autowired
    private PricingService pricingService;

    @GetMapping
    @Operation(summary = "get all pricings", description = "returns a list of all pricings")
    public ResponseEntity<List<PricingDto>> getAllPricings() {
        List<PricingDto> pricings = pricingService.getAllPricings();
        return ResponseEntity.ok(pricings);
    }

    @PostMapping
    @Operation(summary = "create pricing", description = "creates a new pricing")
    public ResponseEntity<PricingDto> createPricing(@RequestBody PricingDto pricingDto) {
        try {
            PricingDto novoPricing = pricingService.createPricing(pricingDto);
            return new ResponseEntity<>(novoPricing, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}