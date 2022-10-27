package one.digitalinnovation.cloudparking.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String entity_not_found) {

        super("Parking not found with id: " + entity_not_found);
    }
}
