package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Repository.DriverRepository;
import domain.Driver;
import dto_request.CreateDriverRequest;
import dto_response.DriverResponse;
import enums.Gender;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public DriverResponse mapToDriverResponse(Driver driver){
        return new DriverResponse(
                driver.getId(),
                driver.getNif(),
                driver.getName(),
                driver.getGender() != null ? driver.getGender().name() : null,
                driver.getBirthYear(),
                driver.getAddress(),
                driver.getDriversLicenseNumber(), 
                driver.getCreatedAt()
        );
    }

    public List<DriverResponse> getAllDrivers(){
        List<Driver> drivers = driverRepository.findAllByOrderByCreatedAtDesc();
        return drivers.stream()
                .map(this::mapToDriverResponse)
                .toList();
    }

    public DriverResponse createDriver(CreateDriverRequest request) {
        
        Driver driver = new Driver();
        driver.setNif(request.getNif());
        driver.setName(request.getName());
        
        if (request.getGender() != null) {
            driver.setGender(Gender.valueOf(request.getGender().toUpperCase()));
        }
        
        driver.setBirthYear(request.getBirthYear());
        driver.setAddress(request.getAddress());
        driver.setDriversLicenseNumber(request.getLicenseNumber());
        driver.setPassword(request.getPassword());
        
    
        Driver driverSaved = driverRepository.save(driver);

        return mapToDriverResponse(driverSaved);
    }
}