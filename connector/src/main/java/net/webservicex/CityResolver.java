package net.webservicex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import net.restfulwebservices.weather.GetCitiesByCountry;
import net.restfulwebservices.weather.GetCitiesByCountryResponse;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class CityResolver extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CityResolver.class);

    public GetCitiesByCountryResponse getCities(String country) {

        GetCitiesByCountry request = new GetCitiesByCountry();
        QName qName = new QName("http://www.restfulwebservices.net/ServiceContracts/2008/01", "Country");
        request.setCountry(new JAXBElement<>(qName, String.class, country));

        log.info("Requesting cities for county " + country);

        return (GetCitiesByCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.restfulwebservices.net/wcf/WeatherForecastService.svc",
                        request,
                        new SoapActionCallback("GetCitiesByCountry"));
    }
}
