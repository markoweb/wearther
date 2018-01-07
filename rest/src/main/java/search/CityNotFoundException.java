package search;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(String token) {
        super("could not find city '" + token + "'.");
    }
}
