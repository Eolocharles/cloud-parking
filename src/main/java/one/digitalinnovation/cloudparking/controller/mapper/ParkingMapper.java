package one.digitalinnovation.cloudparking.controller.mapper;

import one.digitalinnovation.cloudparking.controller.dto.ParkingDTO;
import one.digitalinnovation.cloudparking.model.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParkingMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ParkingDTO toParkingDTO(Parking parking) {
        return MODEL_MAPPER.map(parking, ParkingDTO.class);
    }

    public List<ParkingDTO> toParkingDTO(List<Parking> parkingList) {
        return parkingList.stream().map(parking -> new ParkingDTO(parking.getId(), parking.getLicensePlate(), parking.getState(), parking.getModel(), parking.getColor())).collect(Collectors.toList());
    }
}
