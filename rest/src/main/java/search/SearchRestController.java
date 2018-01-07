package search;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import weather.Weather;

@RestController
@RequestMapping("/search")
public class SearchRestController {

    @RequestMapping(method = RequestMethod.GET)
    public Weather search(@RequestParam(value = "q", required = false) String token) {

        if (! "Oulu".equals(token)) {
            throw new CityNotFoundException(token);
        }
        return new Weather(25,"Sunny in " + token);
    }
}
