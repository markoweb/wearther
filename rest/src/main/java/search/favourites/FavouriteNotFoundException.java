package search.favourites;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class FavouriteNotFoundException extends RuntimeException {
    public FavouriteNotFoundException(String favouriteId) {
        super("could not find favourite '" + favouriteId + "'.");
    }
}
