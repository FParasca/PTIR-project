package Service;

import Repository.TaxiRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Repository.TaxiRepository;
import domain.Taxi;
import dto_request.CreateTaxiRequest;
import dto_response.TaxiResponse;
import enums.ComfortLevel;
import enums.MotorType;

@Service
public class TaxiService {

    @Autowired
    private TaxiRepository taxiRepository;

    private static final Map<String, List<String>> BRANDS_AND_MODELS = new LinkedHashMap<>();

    static {
        BRANDS_AND_MODELS.put("Toyota", Arrays.asList("Corolla", "Camry", "Yaris"));
        BRANDS_AND_MODELS.put("Cupra", Arrays.asList("Formentor", "Leon", "Ateca"));
        BRANDS_AND_MODELS.put("Peugeot", Arrays.asList("208", "308", "508"));
        BRANDS_AND_MODELS.put("Tesla", Arrays.asList("Model S", "Model 3", "Model X"));
    }

    public TaxiResponse mapToTaxiResponse(Taxi taxi) {
        return new TaxiResponse(
                taxi.getId(),
                taxi.getLicensePlate(),
                taxi.getYearOfPurchase(),
                taxi.getBrand(),
                taxi.getModel(),
                taxi.getComfortLevel() != null ? taxi.getComfortLevel().name() : null,
                taxi.getMotorType() != null ? taxi.getMotorType().name() : null,
                taxi.getCreatedAt()
        );
    }

    public List<TaxiResponse> getAllTaxis() {

        List<Taxi> taxis = taxiRepository.findAllByOrderByCreatedAtDesc(); 
        return taxis.stream()
                .map(this::mapToTaxiResponse)
                .toList();
    }

    public TaxiResponse createTaxi(CreateTaxiRequest request) {

        if (!isValidLicensePlate(request.getLicensePlate())) {
            throw new IllegalArgumentException(
                    "Matrícula inválida: não pode ter só dígitos ou só letras.");
        }

        if (taxiRepository.existsByLicensePlate(request.getLicensePlate())) {
            throw new IllegalArgumentException(
                    "Já existe um táxi com a matrícula: " + request.getLicensePlate());
        }

        int currentYear = LocalDateTime.now().getYear();
        if (request.getYearOfPurchase() > currentYear) {
            throw new IllegalArgumentException("Ano de compra inválido");
        }

        if (request.getComfortLevel() == null) {
            throw new IllegalArgumentException("Nível de conforto inválido");
        }
        if (request.getMotorType() == null) {
            throw new IllegalArgumentException("Tipo de motor inválido");
        }

        if (!BRANDS_AND_MODELS.containsKey(request.getBrand())) {
            throw new IllegalArgumentException("Marca inválida");
        }
        if (!BRANDS_AND_MODELS.get(request.getBrand()).contains(request.getModel())) {
            throw new IllegalArgumentException(
                    "Modelo inválido para a marca " + request.getBrand() + ".");
        }

        Taxi taxi = new Taxi();
        taxi.setLicensePlate(request.getLicensePlate());
        taxi.setBrand(request.getBrand());
        taxi.setModel(request.getModel());
        taxi.setYearOfPurchase(request.getYearOfPurchase());
        
        taxi.setComfortLevel(ComfortLevel.valueOf(request.getComfortLevel().toUpperCase()));
        taxi.setMotorType(MotorType.valueOf(request.getMotorType().toUpperCase()));

        taxi.setCreatedAt(LocalDateTime.now());

        Taxi taxiSaved = taxiRepository.save(taxi);

        return mapToTaxiResponse(taxiSaved);
    }

    private boolean isValidLicensePlate(String plate) {
        if (plate == null || plate.isBlank()) {
            return false;
        }

        boolean hasLetter = plate.chars().anyMatch(Character::isLetter);
        boolean hasDigit = plate.chars().anyMatch(Character::isDigit);

        return hasLetter && hasDigit;
    }

    public List<String> getAvailableBrands() {
        return new ArrayList<>(BRANDS_AND_MODELS.keySet());
    }

    public List<String> getModelsByBrand(String brand) {
        if (!BRANDS_AND_MODELS.containsKey(brand)) {
            throw new IllegalArgumentException("Marca não encontrada");
        }
        return new ArrayList<>(BRANDS_AND_MODELS.get(brand));
    }
}