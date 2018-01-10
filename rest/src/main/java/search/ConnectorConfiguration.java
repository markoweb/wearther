package search;

import weather.CityResolver;
import weather.ForecastResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ConnectorConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("net.restfulwebservices.weather");
        return marshaller;
    }

    @Bean
    public CityResolver cityResolver(Jaxb2Marshaller marshaller) {
        CityResolver cityResolver = new CityResolver();
        cityResolver.setDefaultUri("http://www.restfulwebservices.net/wcf/WeatherForecastService.svc");
        cityResolver.setMarshaller(marshaller);
        cityResolver.setUnmarshaller(marshaller);
        return cityResolver;
    }

    @Bean
    public ForecastResolver forecastResolver(Jaxb2Marshaller marshaller) {
        ForecastResolver forecastResolver = new ForecastResolver();
        forecastResolver.setDefaultUri("http://www.restfulwebservices.net/wcf/WeatherForecastService.svc");
        forecastResolver.setMarshaller(marshaller);
        forecastResolver.setUnmarshaller(marshaller);
        return forecastResolver;
    }
}
