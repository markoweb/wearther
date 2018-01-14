package search.openweathermap;

import org.openweathermap.CurrentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/owm/weather")
public class WeatherRestController {

    @Value("${openweathermap.key}")
    private String apiKey;

    @Value("${openweathermap.sample}")
    private String isSample;

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public CurrentType search(@RequestParam(value = "token") String token) {

        String sampleUrl
                = "http://samples.openweathermap.org/data/2.5/weather?q={token}&mode=xml&APPID={apikey}";

        String productionUrl
                = "http://api.openweathermap.org/data/2.5/weather?q={token}&mode=xml&units=metric&APPID={apikey}";

        RestTemplate template = new RestTemplate();
        return template.getForObject(
                ("true".equals(this.isSample)) ? sampleUrl : productionUrl,
                CurrentType.class,
                token,
                this.apiKey
        );
    }
}
