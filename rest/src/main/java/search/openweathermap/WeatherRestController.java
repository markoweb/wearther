package search.openweathermap;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import weather.Current;

@RestController
@RequestMapping("/owm/weather")
public class WeatherRestController {

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Current search(@RequestParam(value = "token") String token) {

        RestTemplate template = new RestTemplate();
        String url = "http://api.openweathermap.org/data/2.5/weather?q={token}&mode=xml&units=metric&APPID={apikey}";
        String apiKey = "e6b0d19165248d97ae9b26534222d33e";
        Current current = template.getForObject(url, Current.class, token, apiKey);
        return current;
    }
}
