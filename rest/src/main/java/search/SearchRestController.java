package search;

import org.springframework.web.bind.annotation.*;
import weather.Weather;

@RestController
@RequestMapping("/search")
public class SearchRestController {

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(method = RequestMethod.GET)
    public Weather search(@RequestParam(value = "q", required = false) String token) {

        if (! "Oulu".equals(token)) {
            throw new CityNotFoundException(token);
        }
        return new Weather(25,"Sunny in " + token);
    }
}
