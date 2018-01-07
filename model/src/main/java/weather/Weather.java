package weather;

public class Weather {

    private final float temperature;
    private final String description;

    public Weather(float temperature, String description) {
        this.temperature = temperature;
        this.description = description;
    }

    public float getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }
}
