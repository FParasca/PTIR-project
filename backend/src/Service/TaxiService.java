package Service;

import domain.Taxi;

import java.time.LocalDateTime;
import java.util.*;

public class TaxiService {

    private List<Taxi> taxis = new ArrayList<>();

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
                "Matrícula inválida: não pode ter só dígitos ou só letras."
            );
        }

        int currentYear = LocalDateTime.now().getYear();
        if (taxi.getYearofPursage() > currentYear) {
            throw new IllegalArgumentException(
                "Ano de compra inválido"
            );
        }

        if (taxi.getComfortLevel() == null) {
            throw new IllegalArgumentException(
                "Nível de conforto inválido"
            );
        }

        // Critério f) — Tipo de motor não pode ser nulo
        if (taxi.getMotorType() == null) {
            throw new IllegalArgumentException(
                "Tipo de motor inválido"
            );
        }

        // Critério c) — Marca e modelo devem ser das listas predefinidas
        if (!BRANDS_AND_MODELS.containsKey(taxi.getBrand())) {
            throw new IllegalArgumentException(
                "Marca inválida"
            );
        }
        if (!BRANDS_AND_MODELS.get(taxi.getBrand()).contains(taxi.getModel())) {
            throw new IllegalArgumentException(
                "Modelo inválido para a marca"
                + BRANDS_AND_MODELS.get(taxi.getBrand()) + "."
            );
        }

        taxi.setCreatedAt(LocalDateTime.now());
        taxis.add(taxi);
    }

    private boolean isValidLicensePlate(String plate) {
        if (plate == null || plate.isBlank()) return false;

        boolean hasLetter = plate.chars().anyMatch(Character::isLetter);
        boolean hasDigit  = plate.chars().anyMatch(Character::isDigit);

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
        List<Taxi> sorted = new ArrayList<>(taxis);
        sorted.sort(Comparator.comparing(Taxi::getCreatedAt).reversed());
        return sorted;
    }
}