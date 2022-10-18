package one.digitalinnovation.cloudparking.service;

import one.digitalinnovation.cloudparking.model.Parking;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParkingService {
    private static Map<String, Parking> parkingMap = new HashMap<>();

    static {
        var id = getUUID();
        Parking parking = new Parking(id, "ABC-1234", "SP", "Fiat Uno", "Azul");
        parkingMap.put(id, parking);
    }

    public List<Parking> findAll() {
        return List.copyOf(parkingMap.values());
    }

    private static String getUUID() {
        return java.util.UUID.randomUUID().toString().replace("-","");
    }
}
