package search.favourites;

import favourites.Favourite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import weather.CityResolver;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/owm/favourites")
public class FavouritesRestController {

    private static final Logger log = LoggerFactory.getLogger(CityResolver.class);

    private Collection<Favourite> favourites = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(method = RequestMethod.GET)
    Collection<Favourite> readFavourites() {
        return this.favourites;
    }

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(String city) {
        Favourite favourite = new Favourite(this.counter.incrementAndGet(), city);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(favourite.getId()).toUri();

        favourites.add(favourite);

        log.info(String.valueOf(this.favourites.size()));

        return ResponseEntity.created(location).build();
    }

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(method = RequestMethod.GET, value = "/{favouriteId}")
    Favourite readFavourite(@PathVariable Long favouriteId) {

        for (Favourite favourite: this.favourites){
            if (favouriteId.equals(favourite.getId())) {
                return favourite;
            }
        }
        throw new FavouriteNotFoundException(favouriteId.toString());
    }

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{favouriteId}")
    ResponseEntity<?> removeFavourite(@PathVariable Long favouriteId) {

        for (Favourite favourite: this.favourites){
            if (favouriteId.equals(favourite.getId())) {
                this.favourites.remove(favourite);
                return ResponseEntity.ok(favourite);
            }
        }
        throw new FavouriteNotFoundException(favouriteId.toString());
    }
}
