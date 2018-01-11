package weather;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class City {

    private int id;
    private String name;
    private Coord coord;
    private String country;
    private Sun sun;

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    @XmlElement
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    @XmlElement
    public void setCountry(String country) {
        this.country = country;
    }

    public Sun getSun() {
        return sun;
    }

    @XmlElement
    public void setSun(Sun sun) {
        this.sun = sun;
    }
}
