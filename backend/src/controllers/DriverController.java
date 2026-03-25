package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Service.DriverService;
import dto_request.CreateDriverRequest;
import dto_response.DriverResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/manage/drivers")
@Tag(name = "Driver API", description = "Driver management")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping
    @Operation(summary = "List drivers", description = "Returns the list of drivers ordered by creation date.")
    public ResponseEntity<List<DriverResponse>> getAllDrivers() {
        List<DriverResponse> drivers = driverService.getAllDrivers();
        return ResponseEntity.ok(drivers);
    }

    @PostMapping
    @Operation(summary = "Create driver", description = "Creates a new driver.")
    public ResponseEntity<DriverResponse> createDriver(@RequestBody CreateDriverRequest request) {
        try {
            DriverResponse novoDriver = driverService.createDriver(request);
            return new ResponseEntity<>(novoDriver, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}