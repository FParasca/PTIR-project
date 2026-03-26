package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Service.TaxiService;
import dto_request.CreateTaxiRequest;
import dto_response.TaxiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/taxis")
@Tag(name = "Taxi API", description = "Gestão de Táxis")
public class TaxiController {

    @Autowired
    private TaxiService taxiService;

    @GetMapping
    @Operation(summary = "Listar táxis", description = "Retorna a lista de táxis ordenada pela data de criação.")
    public ResponseEntity<List<TaxiResponse>> getAllTaxis() {
        List<TaxiResponse> taxis = taxiService.getAllTaxis();
        return ResponseEntity.ok(taxis);
    }

    @PostMapping
    @Operation(summary = "Registar táxi", description = "Cria um novo táxi validando regras de negócio.")
    public ResponseEntity<?> createTaxi(@RequestBody CreateTaxiRequest request) {
        try {
            TaxiResponse novoTaxi = taxiService.createTaxi(request);
            return new ResponseEntity<>(novoTaxi, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/brands")
    @Operation(summary = "Listar marcas", description = "Retorna as marcas de táxis suportadas.")
    public ResponseEntity<List<String>> getAvailableBrands() {
        return ResponseEntity.ok(taxiService.getAvailableBrands());
    }

    @GetMapping("/brands/{brand}/models")
    @Operation(summary = "Listar modelos por marca", description = "Retorna os modelos disponíveis para uma determinada marca.")
    public ResponseEntity<?> getModelsByBrand(@PathVariable String brand) {
        try {
            return ResponseEntity.ok(taxiService.getModelsByBrand(brand));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}