package search.city;

import net.restfulwebservices.weather.GetCitiesByCountryResponse;
import weather.CityResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityRestController {

    @Autowired
    private CityResolver cityResolver;

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(method = RequestMethod.GET)
    public List<String> search(@RequestParam(value = "country") String country) {

        GetCitiesByCountryResponse response = this.cityResolver.getCities(country);

        return response.getGetCitiesByCountryResult().getValue().getString();
    }
}
