package controllers;

import domain.Taxi;
import Service.TaxiService;
import dto_response.TaxiResponse;
import dto_request.CreateNewTaxiRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxis")
public class TaxiController {

    private final TaxiService taxiService;

    public TaxiController(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    @PostMapping
    public ResponseEntity<TaxiResponse> register(@RequestBody CreateNewTaxiRequest req) {
        Taxi taxi = new Taxi(req.getLicensePlate(), req.getYearOfPurchase(),
                req.getBrand(), req.getModel(), req.getComfortLevel(), req.getMotorType());
        taxiService.registerTaxi(taxi);
        return ResponseEntity.ok(TaxiResponse.from(taxi));
    }

    @GetMapping
    public List<TaxiResponse> list() {
        return taxiService.getTaxisSortedByCreationDate()
                .stream()
                .map(TaxiResponse::from)
                .toList();
    }

    @GetMapping("/brands")
    public List<String> brands() {
        return taxiService.getAvailableBrands();
    }

    @GetMapping("/brands/{brand}/models")
    public List<String> models(@PathVariable String brand) {
        return taxiService.getModelsByBrand(brand);
    }
}
