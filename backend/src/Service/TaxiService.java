package Service;

import Repository.TaxiRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import domain.Taxi;

public class TaxiService {

    private static final Map<String, List<String>> BRANDS_AND_MODELS = new LinkedHashMap<>();

    static {
        BRANDS_AND_MODELS.put("Toyota", Arrays.asList("Corolla", "Camry", "Yaris"));
        BRANDS_AND_MODELS.put("Cupra", Arrays.asList("Formentor", "Leon", "Ateca"));
        BRANDS_AND_MODELS.put("Peugeot", Arrays.asList("208", "308", "508"));
        BRANDS_AND_MODELS.put("Tesla", Arrays.asList("Model S", "Model 3", "Model X"));
    }

    public void registerTaxi(Taxi taxi) {

        if (!isValidLicensePlate(taxi.getLicensePlate())) {
            throw new IllegalArgumentException(
                    "Matrícula inválida: não pode ter só dígitos ou só letras.");
        }

        // 2) Verificação de matrícula duplicada
        if (taxiRepository.existsByLicensePlate(taxi.getLicensePlate())) {
            throw new IllegalArgumentException(
                    "Já existe um táxi com a matrícula: " + taxi.getLicensePlate());
        }

        int currentYear = LocalDateTime.now().getYear();
        if (taxi.getYearOfPurchase()> currentYear) {
            throw new IllegalArgumentException(
                    "Ano de compra inválido");
        }

        if (taxi.getComfortLevel() == null) {
            throw new IllegalArgumentException(
                    "Nível de conforto inválido");
        }

        if (taxi.getMotorType() == null) {
            throw new IllegalArgumentException(
                    "Tipo de motor inválido");
        }

        if (!BRANDS_AND_MODELS.containsKey(taxi.getBrand())) {
            throw new IllegalArgumentException(
                    "Marca inválida");
        }
        if (!BRANDS_AND_MODELS.get(taxi.getBrand()).contains(taxi.getModel())) {
            throw new IllegalArgumentException(
                    "Modelo inválido para a marca"
                            + BRANDS_AND_MODELS.get(taxi.getBrand()) + ".");
        }

        taxi.setCreatedAt(LocalDateTime.now());
        // 3) Guardar via repositório em vez de taxis.add()
        taxiRepository.save(taxi);
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

    public List<Taxi> getTaxisSortedByCreationDate() {
        return taxiRepository.findAllSortedByCreationDate();
    }
}
