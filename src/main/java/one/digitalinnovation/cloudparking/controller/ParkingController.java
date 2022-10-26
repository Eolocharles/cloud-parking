package one.digitalinnovation.cloudparking.controller;


import one.digitalinnovation.cloudparking.controller.dto.ParkingCreateDTO;
import one.digitalinnovation.cloudparking.controller.dto.ParkingDTO;
import one.digitalinnovation.cloudparking.controller.mapper.ParkingMapper;
import one.digitalinnovation.cloudparking.model.Parking;
import one.digitalinnovation.cloudparking.service.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
        this.parkingMapper = new ParkingMapper();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping

    public ResponseEntity< List<ParkingDTO>> findAll() {
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTO(parkingList);
        return ResponseEntity.ok(result);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
        Parking parking = parkingService.findById(id);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        parkingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO parkingDTO) {
        Parking parking = parkingMapper.toParkingCreate(parkingDTO);
        parking = parkingService.create(parking);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO parkingDTO) {
        Parking parking = parkingMapper.toParkingCreate(parkingDTO);
        parking.setId(id);
        parking = parkingService.update(id,parking);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/{id}/checkout")
    public ResponseEntity<ParkingDTO> checkout(@PathVariable String id) {
        Parking parking = parkingService.checkout(id);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }

}
