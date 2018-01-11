package weather;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "current")
public class Current {

    private City city;
    private Temperature temperature;
    private Humidity humidity;
    private Pressure pressure;
    private Wind wind;
    private Clouds clouds;
    private Visibility visibility;
    private Precipitation precipitation;
    private Weather weather;
    private Lastupdate lastupdate;

    public City getCity() {
        return city;
    }

    @XmlElement
    public void setCity(City city) {
        this.city = city;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    @XmlElement
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Humidity getHumidity() {
        return humidity;
    }

    @XmlElement
    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    public Pressure getPressure() {
        return pressure;
    }

    @XmlElement
    public void setPressure(Pressure pressure) {
        this.pressure = pressure;
    }

    public Wind getWind() {
        return wind;
    }

    @XmlElement
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    @XmlElement
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    @XmlElement
    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public Precipitation getPrecipitation() {
        return precipitation;
    }

    @XmlElement
    public void setPrecipitation(Precipitation precipitation) {
        this.precipitation = precipitation;
    }

    public Weather getWeather() {
        return weather;
    }

    @XmlElement
    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Lastupdate getLastupdate() {
        return lastupdate;
    }

    @XmlElement
    public void setLastupdate(Lastupdate lastupdate) {
        this.lastupdate = lastupdate;
    }
}
