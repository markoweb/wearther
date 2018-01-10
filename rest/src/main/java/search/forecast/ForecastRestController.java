package search.forecast;

import net.restfulwebservices.weather.GetForecastByCityResponse;
import weather.ForecastResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class ForecastRestController {

    @Autowired
    private ForecastResolver forecastResolver;

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(method = RequestMethod.GET)
    public GetForecastByCityResponse search(
            @RequestParam(value = "country") String country,
            @RequestParam(value = "city") String city
    ) {
        return this.forecastResolver.getForecast(country, city);
    }
}
