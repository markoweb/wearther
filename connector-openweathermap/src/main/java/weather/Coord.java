package weather;

import javax.xml.bind.annotation.XmlAttribute;

public class Coord {

    private Float lon;
    private Float lat;

    public Float getLon() {
        return lon;
    }

    @XmlAttribute
    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Float getLat() {
        return lat;
    }

    @XmlAttribute
    public void setLat(Float lat) {
        this.lat = lat;
    }
}
