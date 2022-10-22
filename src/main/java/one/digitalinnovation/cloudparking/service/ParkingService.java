package one.digitalinnovation.cloudparking.service;

import one.digitalinnovation.cloudparking.exception.ParkingNotFoundException;
import one.digitalinnovation.cloudparking.model.Parking;
import one.digitalinnovation.cloudparking.repository.ParkingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Transactional(readOnly = true)
    public List<Parking> findAll() {
        return parkingRepository.findAll();
    }

    private static String getUUID() {
        return java.util.UUID.randomUUID().toString().replace("-","");
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Parking findById(String id) {
        return parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));

    }

    @Transactional
    public Parking create(Parking parking) {
        parking.setId(getUUID());
        parking.setEntryDate(LocalDateTime.now());
        return parkingRepository.save(parking);
    }
    @Transactional
    public void deleteById(String id) {
        findById(id);
        parkingRepository.deleteById(id);
    }
    @Transactional
    public Parking update(String id, Parking parking) {
        Parking parkingToUpdate = findById(id);
        parkingToUpdate.setLicensePlate(parking.getLicensePlate());
        parkingToUpdate.setState(parking.getState());
        parkingToUpdate.setModel(parking.getModel());
        parkingToUpdate.setColor(parking.getColor());
        return parkingRepository.save(parkingToUpdate);
    }
    @Transactional
    public Parking checkout(String id) {
        Parking parkingToCheckout = findById(id);
        parkingToCheckout.setExitDate(LocalDateTime.now());
        parkingToCheckout.setBill(ParkingCheckOut.getBill(parkingToCheckout));
        return parkingRepository.save(parkingToCheckout);


    }
}
