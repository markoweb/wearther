package net.webservicex;

import net.restfulwebservices.weather.GetForecastByCity;
import net.restfulwebservices.weather.GetForecastByCityResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class ForecastResolver extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(ForecastResolver.class);

    public GetForecastByCityResponse getForecast(String contry, String city) {

        GetForecastByCity request = new GetForecastByCity();
        QName countryQName = new QName("http://www.restfulwebservices.net/ServiceContracts/2008/01", "Country");
        request.setCountry(new JAXBElement<>(countryQName, String.class, contry));

        QName cityQName = new QName("http://www.restfulwebservices.net/ServiceContracts/2008/01", "City");
        request.setCity(new JAXBElement<>(cityQName, String.class, city));

        log.info("Requesting forecast for country " + contry + ", city " + city);

        return (GetForecastByCityResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.restfulwebservices.net/wcf/WeatherForecastService.svc",
                        request,
                        new SoapActionCallback("GetForecastByCity"));
    }
}
