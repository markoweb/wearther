package weather;

import javax.xml.bind.annotation.XmlAttribute;

public class Weather {

    private String number;
    private String value;
    private String icon;

    public String getNumber() {
        return number;
    }

    @XmlAttribute
    public void setNumber(String number) {
        this.number = number;
    }

    public String getValue() {
        return value;
    }

    @XmlAttribute
    public void setValue(String value) {
        this.value = value;
    }

    public String getIcon() {
        return icon;
    }

    @XmlAttribute
    public void setIcon(String icon) {
        this.icon = icon;
    }
}
